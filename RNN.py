import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from sklearn.preprocessing import MinMaxScaler
from keras.models import Sequential
from keras.layers import Dense
from keras.layers import LSTM
from keras.layers import Dropout

#-------------------------Data Preprocessing-------------------------
dataset_train = pd.read_csv("C:\\Users\\phamp\\code\\github\\code\\Part 3 - Recurrent Neural Networks\\Google_Stock_Price_Train.csv")

training_set = dataset_train.iloc[:,1:2].values


#-------------------------Feature scaling-------------------------
sc = MinMaxScaler(feature_range=(0,1))
#we apply normalisation
#"feature_range" : is the range for the scaled stock prices

training_set_scaled = sc.fit_transform(training_set) #scaled the training set 

#creating the data structure with 60 timesteps and 1 output 
#mean that each new financial day need to base on 60 days before and provide the trend for the current day 

x_train = []
y_train = []

for i in range(60,1258): #bc each financial day based on 60 day before it so we have to sart at day 60th to day 1257th (bc there are only 1258 day on the dataset)
    x_train.append(training_set_scaled[i-60:i,0])
    y_train.append(training_set_scaled[i,0])

x_train,y_train = np.array(x_train),np.array(y_train)

#Reshaping
x_train = np.reshape(x_train, (x_train.shape[0],x_train.shape[1],1)) #reshape into 3D array with one predictors or indicators (the open stock price)


#-------------------------Building RNN-------------------------
regressor = Sequential()
regressor.add(LSTM(units=50, return_sequences=True, input_shape=(x_train.shape[1],1))) #"return sequences" : bc we want the output of the LSTM layer to be the input of the next LSTM layer
regressor.add(Dropout(0.2)) #20% of the neurons in the LSTM layers will be ignored during the training in each iteration 

regressor.add(LSTM(units=50, return_sequences=True)) 
regressor.add(Dropout(0.2)) #20% of the neurons in the LSTM layers will be ignored during the training in each iteration  

regressor.add(LSTM(units=50, return_sequences=True))
regressor.add(Dropout(0.2)) #20% of the neurons in the LSTM layers will be ignored during the training in each iteration  

regressor.add(LSTM(units=50))
regressor.add(Dropout(0.2)) #20% of the neurons in the LSTM layers will be ignored during the training in each iteration  
#to avoid overfitting

regressor.add(Dense(units=1))

regressor.compile(optimizer="adam", loss = "mean_squared_error") #we use the "mean_squared_error" bc we deal with the continous value

#fitting the RNN
regressor.fit(x_train,y_train,epochs = 100, batch_size=32)



#-------------------------Making prediction and visualising the result-------------------------

dataset_test = pd.read_csv("C:\\Users\\phamp\\code\\github\\code\\Part 3 - Recurrent Neural Networks\\Google_Stock_Price_Test.csv")

real_stock_price = dataset_test.iloc[:,1:2].values

dataset_total = pd.concat((dataset_train['Open'],dataset_test['Open']),axis=0)
inputs = dataset_total[len(dataset_total) - len(dataset_test)-60:].values

inputs = inputs.reshape(-1,1)

inputs = sc.transform(inputs)

x_test = []

for i in range(60,80):
    x_test.append(inputs[i-60:i,0])

x_test = np.array(x_test)

x_test = np.reshape(x_test, (x_test.shape[0],x_test.shape[1],1))

pridicted_stock_price = regressor.predict(x_test)

pridicted_stock_price = sc.inverse_transform(pridicted_stock_price)


#-------------------------Visualising the result-------------------------

plt.plot(real_stock_price, color='r',label='Real GG Stock Price')
plt.plot(pridicted_stock_price, color='b',label='Pridicted GG Stock Price')
plt.title("GG Stock Price Prediction")
plt.xlabel('Time')
plt.ylabel('GG Stock Price')
plt.legend()
plt.show()

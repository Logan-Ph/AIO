import numpy as np 
import matplotlib.pyplot as plt
import pandas as pd
from sklearn.preprocessing import MinMaxScaler
from minisom import MiniSom
from pylab import bone,pcolor,colorbar,plot,show
from keras.models import Sequential
from keras.layers import Dense
from sklearn.preprocessing import StandardScaler

#---------------data preprocessing---------------
dataset = pd.read_csv("C:\\Users\\Admin\\code\\Self_Organizing_Maps\\Credit_Card_Applications.csv")

X = dataset.iloc[:,:-1].values
y = dataset.iloc[:,-1].values

#-------------------------Feature scaling-------------------------(bc the dataset is high demensionality)
sc = MinMaxScaler(feature_range=(0,1))

X = sc.fit_transform(X)

#-------------------------Trainning SOM-------------------------

som = MiniSom(x=10, y=10, input_len=15) #x,y is the grid of the SOM
#the "input_len" is the number of atributes (here we have 14 atributes + customer_id)

som.random_weights_init(X) #initialize randow weights

som.train_random(data=X,num_iteration=100)

bone()
pcolor(som.distance_map().T)
colorbar()
markers = ['o','s']
colors = ['r','g']

for i,x in enumerate(X):
    w = som.winner(x)
    plot(w[0] + 0.5,
         w[1] + 0.5,
         markers[y[i]],
         markeredgecolor = colors[y[i]],
         markerfacecolor = 'None',
         markersize = 10,
         markeredgewidth = 2)

show()


mappings = som.win_map(X)
frauds = np.concatenate((mappings[(5,3)],mappings[(8,3)]),axis=0)

frauds = sc.inverse_transform(frauds)


#-------------------------Going from unsupervised to supervised-------------------------

customers = dataset.iloc[:,1:].values
is_fraud = np.zeros(len(dataset))

for i in range*(len(dataset)):
    if dataset.iloc[i,0].values in frauds:
        is_fraud[i] = 1

sc = MinMaxScaler()
customers = sc.fit_transform(customers)

classifier = Sequential()

classifier.add(Dense(units=6,kernel_initializer='uniform', activation='relu', input_dim = 15 )) # 'input_dim' is the columns of the features in the dataset

classifier.add(Dense(units=1, kernel_initializer='uniform', activation='sigmoid'))

classifier.compile(optimizer='adam', loss = 'binary_crossentropy', metrics=['accuracy'])

classifier.fit(customers,is_fraud,batch_size=1,epochs=2)

y_pred = classifier.predict(customers)
y_pred = np.concatenate((dataset.iloc[:,0:1].values,y_pred),axis = 1)

y_pred = y_pred[y_pred[:,1].argsort()]


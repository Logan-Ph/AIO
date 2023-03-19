import numpy as np
import pandas as pd
import tensorflow as tf
from sklearn.compose import ColumnTransformer
from sklearn.preprocessing import LabelEncoder,OneHotEncoder,StandardScaler
from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix,accuracy_score

#---------------data preprocessing---------------
dataset = pd.read_csv("Churn_Modelling.csv")

#extract values form the dataset
X = dataset.iloc[:,3:-1].values
y = dataset.iloc[:,-1].values

#encoding gender collum into binary
le = LabelEncoder()
X[:,2] = le.fit_transform(X[:,2])

#encode the categorical collumn into sth that does not matter
ct = ColumnTransformer(transformers=[('encoder',OneHotEncoder(),[1])],remainder='passthrough')
X = np.array(ct.fit_transform(X))

#split the data
X_train,X_test,y_train,y_test = train_test_split(X,y,test_size = 0.2, random_state = 0)

#Feauture scaling (it is crucial in deeplearning) normalize the data
sc = StandardScaler()
X_train = sc.fit_transform(X_train)
X_test = sc.fit_transform(X_test)

#---------------Building an ANN phase---------------
ann = tf.keras.models.Sequential()
ann.add(tf.keras.layers.Dense(units=6, activation='relu')) # shallow learning (1st hidden layer)
ann.add(tf.keras.layers.Dense(units=6, activation='relu')) #deep learning (2nd hidden layer)
ann.add(tf.keras.layers.Dense(units=1, activation='sigmoid')) #output layer 
#activation sigmoid just for binary classification, soft_max is for non-binary classification

#---------------Training an ANN---------------
ann.compile(optimizer = 'adam', loss = 'binary_crossentropy', metrics = ['accuracy'])
#optimizer 'adam' is stochastic gradient descent
#loss function is cost function 'binary_crossentropy' for binary and 'categorical_crossentropy' for non-binary
ann.fit(X_train, y_train, batch_size = 32, epochs = 100)

# Homework
# Use our ANN model to predict if the customer with the following informations will leave the bank:
# Geography: France
# Credit Score: 600
# Gender: Male
# Age: 40 years old
# Tenure: 3 years
# Balance: $ 60000
# Number of Products: 2
# Does this customer have a credit card? Yes
# Is this customer an Active Member: Yes
# Estimated Salary: $ 50000
# So, should we say goodbye to that customer?

print(ann.predict(sc.transform([[1, 0, 0, 600, 1, 40, 3, 60000, 2, 1, 1, 50000 ]])))
#we have to use 'sc.transform' to scale the testing data before predict it bc the model is trained by the scaled value
#the information have to be in 2D array means that inside 2 square bracket [[.....]]
#the outcome will be the probability bc we use the sigmoid function at the final layer
#so it will tell the probability will that customer leave the bank


#---------------Predicting the test set results---------------
y_pred = ann.predict(X_test)
y_pred = (y_pred > 0.5)

print(np.concatenate((y_pred.reshape(len(y_pred),1),y_test.reshape(len(y_test),1)), axis = 1))

#---------------Making confusion matrix---------------
cm = confusion_matrix(y_test,y_pred)
print(cm)
#[[<correct predictions people stay in the bank>,<incorrect predictions people leave the bank>
# <correct predictions people leave in the bank>,<incorrect predictions saty leave the bank>]]
print(accuracy_score(y_test,y_pred))
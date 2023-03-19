import numpy as np 
import matplotlib.pyplot as plt
import pandas as pd
from IPython.display import display
from sklearn.model_selection import train_test_split
import pandas as pd
import mglearn
import mglearn.datasets
from sklearn.neighbors import KNeighborsRegressor

X,y = mglearn.datasets.make_wave(n_samples=40) #lấy 40 mẫu data make wave từ mglearn.datasets

#split the wave dataset into training and test set
X_train,X_test,y_train,y_test = train_test_split(X,y,random_state=0)

#set the n_neighbors to 3
reg = KNeighborsRegressor(n_neighbors=3)

#train the model
reg.fit(X_train,y_train)

#print the prediction of the data through the model
print("Test set prediction:\n",reg.predict(X_test))
print("Test set R^2: {:.2f}\n".format(reg.score(X_test,y_test)))

#analyzing KNeighborsRegessors

#create sub_graph with have the n-row(1) and n-collums(3), graphsize (1500,400)
fig,axes = plt.subplots(1,3,figsize=(15,4))

#create 1,000 data points, evenly spaced between -3 and 3
line=np.linspace(-3,3,1000).reshape(-1,1) #reshape it into 1 coloum and 1 rows ( '-1' means that we dont need how many rows it contains)

for n_neighbors,ax in zip([1,3,9],axes):
    #make predictions between 1,3,9 neighbors
    reg = KNeighborsRegressor(n_neighbors=n_neighbors)
    reg.fit(X_train,y_train)
    ax.plot(line,reg.predict(line),color="red")
    ax.plot(X_train, y_train, '^', c=mglearn.cm2(0), markersize=8)
    ax.plot(X_test, y_test,'v',c=mglearn.cm2(1), markersize=8)

    ax.set_title("{} neighbor(s) \n train socre: {:.2f} test score: {:.2f}".format(n_neighbors,reg.score(X_train, y_train),reg.score(X_test, y_test)))

    ax.set_xlabel("Feature")
    ax.set_ylabel("Target")

axes[0].legend(["Model predictions","Training data/target","Test data/target"],loc = "best")

plt.show()


import numpy as np 
import matplotlib.pyplot as plt
import pandas as pd
from IPython.display import display
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
import pandas as pd
import mglearn
from sklearn.neighbors import KNeighborsClassifier

knn = KNeighborsClassifier(n_neighbors=1)
iris_dataset = load_iris()

X_train,X_test,y_train,y_test = train_test_split(iris_dataset["data"],iris_dataset["target"],random_state=0)

iris_dataframe = pd.DataFrame(X_train, columns= iris_dataset.feature_names)
pd.plotting.scatter_matrix(iris_dataframe, c=y_train, figsize=(15,15), marker='o',hist_kwds={'bins':20},s=60,alpha=.8,cmap=mglearn.cm3 )

knn.fit(X_train,y_train)

y_pre = knn.predict(X_test) 

print("Test set prediction:\n", y_pre)
print("test set accuracy: {:.3f}".format(np.mean(y_pre == y_test)) )
print("test set accuracy: {:.3f}".format(knn.score(X_test,y_test)) )










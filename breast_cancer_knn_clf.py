import numpy as np 
import matplotlib.pyplot as plt
import pandas as pd
from IPython.display import display
from sklearn.datasets import load_breast_cancer
from sklearn.model_selection import train_test_split
import pandas as pd
import mglearn
import mglearn.datasets
from sklearn.neighbors import KNeighborsClassifier

# vẽ biểu đồ thể hiện độ chính xác giữa trainning và test của breast cancer từ neightbors 0->10

cancer = load_breast_cancer()
print(cancer.target)
X_train,X_test,y_train,y_test = train_test_split(cancer.data, cancer.target, stratify=cancer.target, random_state=66)

test_accuracy = []
trainning_accuracy = []
neighbors_setting = range(1,11)

for n_neighrbors in neighbors_setting:
    clf = KNeighborsClassifier(n_neighbors=n_neighrbors)
    clf.fit(X_train,y_train)
    test_accuracy.append(clf.score(X_test,y_test))
    trainning_accuracy.append(clf.score(X_train,y_train))

plt.plot(neighbors_setting,trainning_accuracy,label ="trainning accuracy")
plt.plot(neighbors_setting,test_accuracy,label ="test accuracy")
plt.xlabel("neighbors")
plt.ylabel("accuracy")
plt.legend()
plt.show()

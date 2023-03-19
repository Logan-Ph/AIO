import numpy as np 
import matplotlib.pyplot as plt
import pandas as pd
from IPython.display import display
from sklearn.model_selection import train_test_split
import pandas as pd
import mglearn
import mglearn.datasets
from sklearn.linear_model import LinearRegression


# X,y = mglearn.datasets.make_wave(n_samples=60)
# X_train,X_test,y_train,y_test = train_test_split(X,y, random_state=42)
# lr = LinearRegression.fit(X_train,y_train)
# print("lr.coef:", lr.coef_)
# print("lr.intercept_:", lr.intercept_)


X,y = mglearn.datasets.load_boston()
X_train,X_tes,y_train,y_test = train_test_split(X,y, random_state=0)
lr = LinearRegression.fit(X_train,y_train)

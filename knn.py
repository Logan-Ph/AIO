from sklearn import datasets
import numpy as np
import math

def caculate_distance(p1,p2):
	dimension = len(p1)
	distance = 0

	for i in range(dimension):
		distance += (p1[i] - p2[i])**2

	return math.sqrt(distance)

def get_k_neighbors(training_x, label_y, point, k):
	distances = []
	neighbors = []

	for p in training_x:
		distance = caculate_distance(p, point)
		distances.append(distance)

	return neighbors

def highest_votes(labels):
	final_labels = 0
	return final_labels 

def predict(training_x, label_y, point, k):
	neighbors_labels = get_k_neighbors(training_x, label_y, point, k)
	return highest_votes(neighbors_labels)

def accuracy_score(predict, labels):
	accuracy = 0
	return accuracy

iris = datasets.load_iris() 
iris_x = iris.data # data (petal length, petal width, sepal length, sepal width)
iris_y = iris.target # label 

randIndex = np.arange(iris_x.shape[0])
np.random.shuffle(randIndex)

iris_x = iris_x[randIndex]
iris_y = iris_y[randIndex]

x_train = iris_x[:100, :]
x_test = iris_x[100:, :]
y_train = iris_y[:100]
y_test = iris_y[100:]

k = 5
y_predict = []
for p in x_test:
	label = predict(x_train, y_train, p, k)
	y_predict.append(label)

print(accuracy_score(y_predict, y_test))
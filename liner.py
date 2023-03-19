import numpy as np 
import matplotlib
import matplotlib.pyplot as plt
 
# random data
b = [2,5,7,9,11,16,19,23,22,29,29,35,37,40,46,42,39,31,30,28,20,15,10,6]
A = [2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25]

#visualize data
plt.plot(A,b, 'ro')

# change row vector to collum vector
A = np.array([A]).T
b = np.array([b]).T

# create vector 1
ones = np.ones((A.shape[0],1), dtype=np.int8)

# combine 1 and A
A = np.concatenate((A, ones), axis=1)

x_square = np.array([A[:,0]**2]).T

# combine A to A square
A = np.concatenate((x_square,A), axis=1)

# use formula
x = np.linalg.inv(A.transpose().dot(A)).dot(A.transpose()).dot(b)

#  test data to draw
x0 = np.linspace(1,25,100000)
y0 = ((x0*x0)*x[0][0]) + x[1][0]*x0 + x[2][0]

plt.plot(x0,y0)

# #  test predicting data 
# x_test = 12
# y_test = x_test*x[0][0] + x[1][0]

plt.show()
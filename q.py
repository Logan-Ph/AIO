import numpy as np 
from mpl_toolkits.mplot3d import Axes3D
import matplotlib.pylab as plt


x = np.linspace(-1.0,1.0,50)
y = np.linspace(-1.0,1.0,50)

xx=[];yy=[];zz=[]

for i in range(50):
    for j in range(50):
        xx.append(x[i])
        yy.append(y[j])
        zz.append(x[i]**2+x[i]*y[j]+y[j]**2)

x = np.array(xx)
y = np.array(yy)
z = np.array(zz)

fig = plt.figure()
ax = fig.add_subplot(111,projection='3d')
ax.scatter(x,y,z,marker = '.',s=2,color='b')
ax.view_init(60,40)
plt.draw()
plt.show()

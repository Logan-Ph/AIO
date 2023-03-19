# import math
# r = float(input())
# print( "the circle area is " + "{:.2f}".format(math.pi*r*r))

# x,y = map(float,input().split())
# print("the area of the triangle is","{:.2f}".format((1/2)*(x*y)))

import math

# Function
def circle_area(r):
    """
    :param r: radius of the circle
    :return: area of the circle
    """
    return "{:.2f}".format(math.pi*r**2)

# Main program 

def main():
    r = float(input("Enter the radius of the circle: "))
    print("The area of the circle is:", circle_area(r))

main()
import math


class Circle:
    def __init__(self, radius: int):
        self.radius = radius

    def getArea(self):
        print(math.pi * self.radius ** 2)

    def getPerimeter(self):
        print(2 * math.pi * self.radius)


circy = Circle(11)
circy.getArea()
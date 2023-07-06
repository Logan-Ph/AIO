import java.util.*;
public class Circle1 implements GeometricObject{
    private double radius;
    public Circle1(double radius){
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*this.radius*this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*this.radius;
    }

    @Override
    public String toString() {
        return "Circle1[" +
                "radius=" + radius +
                ']';
    }
}

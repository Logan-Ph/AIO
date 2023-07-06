import java.util.*;
public class Circle2 implements GeometricObject1{
    protected double radius;

    public Circle2(double radius){
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
        return "Circle[" +
                "radius=" + radius +
                ']';
    }
}

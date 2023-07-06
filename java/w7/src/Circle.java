import java.util.*;
public class Circle {
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea(){
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public String toString() {
        return "Circle[radius="+getRadius()+"]";
    }
}

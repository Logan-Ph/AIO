import java.util.*;
public class Circle extends Shape{
    protected double radius = 1.0;

    public Circle(){
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*getRadius()*getRadius();
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*getRadius();
    }

    @Override
    public String toString() {
        return "Circle["+super.toString()+",radius="+getRadius()+"]";
    }
}

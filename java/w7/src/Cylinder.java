import java.util.*;
public class Cylinder extends Circle{
    private double height;


    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume(){
        return this.getArea() * getHeight();
    }

    @Override
    public double getArea() {
        return super.getArea()*2 + 2*Math.PI*this.getRadius()*getHeight();
    }

    @Override
    public String toString() {
        return "Cylinder[radius="+this.getRadius()+",height="+getHeight()+"]";
    }
}

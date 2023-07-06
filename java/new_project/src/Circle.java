import java.util.*;
public class Circle {
    private double radius;

    public Circle(){

    }

    public Circle(double r){
        this.radius = r;
        //this.radius = r; cái này cx đc
    }

    public double Area (){
        return radius * radius * Math.PI;
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double r){
        radius = r;
    }
}

import java.util.*;
public class Point {
    private double x,y;

    public Point(double X, double Y){
        this.x = X;
        this.y = Y;
    }

    public double distance(Point target){
        return Math.sqrt(Math.pow(target.x - this.x,2) + Math.pow(target.y - this.y,2));
    }
}

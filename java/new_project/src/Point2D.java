import java.util.*;
public class Point2D {
    Scanner input = new Scanner(System.in);
    private int x,y;

    public Point2D(){
        this.x = 0;
        this.y = 0;
    }

    public Point2D(int x1, int y1){
        this.x = x1;
        this.y = y1;
    }

    public Point2D(Point2D p){
        this.x = p.x;
        this.y = p.y;
    }

    public void input(){
        System.out.println("Enter X:");
        int x1 = input.nextInt();
        this.x = x1;

        System.out.println("Enter Y:");
        int y1 = input.nextInt();
        this.y = y1;
    }

    @Override
    public String toString(){
        return "("+x+","+y+")";
    }

    public void move(int x1, int y1){
        this.x = x1;
        this.y = y1;
    }

    public boolean isOrigin(){
        if ((this.x == 0)&&(this.y == 0)){
            return true;
        }
        else {
            return false;
        }
    }

    public double distance(Point2D p){
        return Math.sqrt((Math.pow(this.x-p.x,2))+Math.pow(this.y-p.y,2));
    }

    static double distance(Point2D p1, Point2D p2){
        return Math.sqrt((Math.pow(p1.x-p2.x,2))+Math.pow(p1.y-p2.y,2));
    }
}

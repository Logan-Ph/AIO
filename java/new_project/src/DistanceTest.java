import java.util.*;
public class DistanceTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first point x and y:");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        Point p1 = new Point(x1,y1);

        System.out.println("Enter the second point x and y:");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        Point p2 = new Point(x2,y2);

        double d = p1.distance(p2);

        System.out.printf("The distance beetween X and Y is: %.2f",d);
    }
}

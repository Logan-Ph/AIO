import java.util.*;
public class Exercise5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter circle1's center x-, y-coordinates, and radius: ");
        double c1X = Double.parseDouble(input.next());
        double c1Y = Double.parseDouble(input.next());
        double c1R = Double.parseDouble(input.next());

        System.out.printf("Enter circle2's center x-, y-coordinates, and radius: ");
        double c2X = Double.parseDouble(input.next());
        double c2Y = Double.parseDouble(input.next());
        double c2R = Double.parseDouble(input.next());

        double d = Math.sqrt(Math.pow(c1X - c2X,2)+Math.pow(c1Y - c2Y,2));
        if ((d<Math.abs(c1R - c2R))&&(c1R>c2R)){
            System.out.println("Circle2 is inside circle2");
        } else if ((d<Math.abs(c1R - c2R))&&(c2R>c1R)) {
            System.out.println("Circle1 is inside circle2");
        }
        else {
            System.out.println("Two circle are overlaps");
        }
    }
}

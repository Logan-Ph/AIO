import java.util.*;
public class TestCirlce {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the radius of the circle");
        double radius = input.nextDouble();
        Circle c1 = new Circle(radius);
        System.out.println("The area of the circleL: "+c1.getArea());
        System.out.println("The circle info:"+c1);

        System.out.println("Enter the height of the cylinder");
        double height = input.nextDouble();
        Cylinder cyl = new Cylinder(radius,height);
        System.out.println("The area of the cylinder: "+cyl.getArea());
        System.out.println("The cylinder info:"+cyl);
    }
}

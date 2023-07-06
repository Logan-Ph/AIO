import java.util.*;
public class TestShape {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the color:");
        String color = input.next();
        System.out.println("Enter the length and width of the rectangle:");
        int width = input.nextInt();
        int length = input.nextInt();

        Rectangle rec = new Rectangle(color,length,width);
        System.out.println("The area of the rectangle: "+ rec.getArea());

        System.out.println("The rectangle info:"+rec);

        System.out.println("Enter the base height of the triangle: ");
        int base = input.nextInt();
        int height = input.nextInt();

        Triangle tri = new Triangle(color,base,height);
        System.out.println("The area of the rectangle: "+ tri.getArea());

        System.out.println("The rectangle info:"+tri);

    }
}

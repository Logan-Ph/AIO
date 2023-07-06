import java.util.*;
public class TestRectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter width:");
        int width = input.nextInt();

        System.out.println("Enter height:");
        int height = input.nextInt();

        Rectangle rec1 = new Rectangle(width,height);
        rec1.visualize();
    }
}

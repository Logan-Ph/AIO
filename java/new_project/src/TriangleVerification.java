import java.util.*;
public class TriangleVerification {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 3 numbers for the sides of a triangle:");
        int s1 = input.nextInt();
        int s2 = input.nextInt();
        int s3 = input.nextInt();

        Triangle mytri = new Triangle(s1,s2,s3);
        mytri.verify();
    }
}

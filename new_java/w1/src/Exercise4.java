import java.util.*;
public class Exercise4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("please enter the coordinates of A");
        int Ax = Integer.parseInt(input.next());
        int Ay = Integer.parseInt(input.next());

        System.out.println("please enter the coordinates of B");
        int Bx = Integer.parseInt(input.next());
        int By = Integer.parseInt(input.next());

        int dx = Bx - Ax;
        int dy = By - Ay;

        double lineSegment = Math.sqrt(dx*dx + dy*dy);
        System.out.printf("circumference = %.2f, and area = %.2f",lineSegment*4, lineSegment*lineSegment);
    }
}

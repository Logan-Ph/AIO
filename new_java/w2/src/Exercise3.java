import java.util.*;
public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number");
        double n = input.nextDouble();
        double min=1, max = n;
        double avg = 0;
        boolean run = true;

        while (run){
            avg = (min+max)/2;
            if(avg*avg > n){
                max = avg;
            } else if (avg*avg<n) {
                min = avg;
            }
            else {
                run = false;
            }
        }

        System.out.printf("The square root of %.2f, is %.2f", n,avg);


    }


}

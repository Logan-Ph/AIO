import java.util.*;
public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number");
        double n = Double.parseDouble(String.format("%.5f",input.nextDouble()));
        double min=1, max = n;
        double avg = 0;
        while (true){
            avg = (min+max)/2;
            double sqr = Double.parseDouble(String.format("%.5f",avg*avg));
            if(sqr > n){
                max = avg;
            } else if (sqr<n) {
                min = avg;
            }
            else if (sqr == n){
                break;
            }

        }
        System.out.printf("The square root of %.2f, is %.5f", n,avg);
    }
}

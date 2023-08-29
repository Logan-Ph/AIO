import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0, count = 0;

        while (input.hasNextInt()) {
            int num = input.nextInt();
            sum += num;
            count++;
        }
        if (count > 0) {
            int mean = sum / count;
            System.out.println("Mean: " + mean);
        } else {
            System.out.println("No integers were input. Mean cannot be calculated.");
        }
    }
}
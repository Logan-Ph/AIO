import java.util.*;
public class Exercise3 {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        System.out.println("Please enter the number in seconds");
        int second = input.nextInt();
        int h = second/3600;
        int m = (second%3600)/60;
        second = second - h*3600 - m*60;
        System.out.printf("%d:%d:%d",h,m,second);
    }
}

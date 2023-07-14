import java.awt.*;
import java.util.*;
public class Exercise4 {
    static void method1(){
        Scanner input = new Scanner(System.in);
        double total = input.nextDouble();
        double you = Double.parseDouble(String.format("%.2f",total/3));
        double delta = Double.parseDouble(String.format("%.2f",total-you*3));
        if (delta>0){
            System.out.printf("You and 2 friends pay %.2f, other friend pay %.2f",you,you+0.01);
        } else if (delta<0) {
            System.out.printf("You pay %.2f, 2 friends pay %.2f",you-0.01,you);
        }
        else {
            System.out.printf("Each person has to pay %.2f", you);
        }
    }

    static void method2(){
        Scanner input = new Scanner(System.in);
        double total = input.nextDouble();
        double you = Double.parseDouble(String.format("%.2f",total/3));
        double delta = total%3;
        if (delta==1){
            System.out.printf("You and 2 friends pay %.2f, other friend pay %.2f",you,you+0.01);
        } else if (delta==2) {
            System.out.printf("You pay %.2f, 2 friends pay %.2f",you-0.01,you);
        }
        else {
            System.out.printf("Each person has to pay %.2f", you);
        }
    }

    public static void main(String[] args) {
        method2();
    }
}

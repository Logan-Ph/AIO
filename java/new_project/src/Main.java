// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
public class Main {

    public static double someCalculate(double add, double multiply, double... numberArray){
        double sum = 0;
        System.out.println(numberArray);
        for (double temp: numberArray){
            sum += temp;
        }
        sum += add;
        sum *= multiply;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(someCalculate(4,2,5,6,7,8));
        String s = new String("hello");

    }
}


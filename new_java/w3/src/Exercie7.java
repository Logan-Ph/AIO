import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercie7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the first string");
        String str1 = input.nextLine();

        System.out.println("Please enter the second string");
        String str2 = input.nextLine();

        str1 = str1 + str2;
        str2 = str1.substring(0,str1.length()-str2.length());
        str1 = str1.substring(str2.length());

        System.out.println("str1: "+ str1);
        System.out.println("str2: "+ str2);


    }
}

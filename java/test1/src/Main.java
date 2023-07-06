import java.util.*;
public class Main {
    static void printFirstFiveAdditions(int n, int m){
        for (int i =1; i<6; i++){
            int result = n+i*m;
            System.out.println(n+"+" +i +"*"+m+ "=" + result);
        }
    }

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        printFirstFiveAdditions(3,2);
    }
}
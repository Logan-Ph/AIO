import java.util.*;
public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the side");
        int n = input.nextInt();
        for (int i =0; i<n; i++){
            for (int j = 0; j<n; j++){
                if((i==0)||(i==n-1)){
                    System.out.printf("*");
                } else if ((j == 0)||(j==n-1)) {
                    System.out.printf("*");
                }else {
                    System.out.printf(" ");
                }
            }
            System.out.println();
        }
    }
}

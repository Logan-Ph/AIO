import java.util.*;
public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please enter the side");
        int n = input.nextInt();
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n ; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}

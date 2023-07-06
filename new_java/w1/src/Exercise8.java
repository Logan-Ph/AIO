import java.util.*;
public class Exercise8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.printf("Enter a posistive integer: ");
            int user = input.nextInt();
            if (user<=0){
                break;
            }

            if (user%30==0){
                System.out.printf("%d is divisible by both 5 and 6%n",user);
            } else if ((user%5==0)||(user%6==0)) {
                System.out.printf("%d is divisible by 5 or 6, but not both%n",user);
            } else {
                System.out.printf("%d is neither divisible by 5 nor 6%n",user);
            }
        }
        System.out.println("Goodbye!");
    }
}

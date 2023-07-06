import java.util.*;
public class invalidUserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueloop = true;
        do {
            try{
                System.out.println("Please enter an integer!");
                int n = input.nextInt();
                System.out.println("hehe you are smart!");
                continueloop = false;
            }catch (InputMismatchException e){
                input.nextLine();
                System.out.println("You must enter integers. Please try again!");
            }
        }while (continueloop);
    }
}

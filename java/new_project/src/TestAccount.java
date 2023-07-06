import java.util.*;

public class TestAccount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account account1 = new Account(50.00);
        Account account2 = new Account(-7.53);
        Date d = new Date();
        System.out.println(d.toString());

        System.out.println("The initial balance of the account 1 is " + account1.getBalance());
        System.out.println("The initial balance of the account 2 is " + account2.getBalance());

        double depositAmount;
        System.out.println("Enter deposit amount for account 1: ");
        depositAmount = input.nextDouble();
        account1.credit(depositAmount);

        System.out.printf("\nadding to the account 1 %.2f balance \n\n",depositAmount );

        System.out.println("Enter deposit amount for account 2: ");
        depositAmount = input.nextDouble();
        account2.credit(depositAmount);

        System.out.printf("\nadding to the account 2 %.2f balance \n\n",depositAmount );


        System.out.printf("account1 balance :%.2f\n", account1.getBalance());
        System.out.printf("account1 balance :%.2f\n", account2.getBalance());
    }
}

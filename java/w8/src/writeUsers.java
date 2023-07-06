import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class writeUsers {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new FileWriter("src/users.txt",true));
        System.out.println("Enter name: ");
        String name = input.nextLine();

        System.out.println("Enter address: ");
        String address = input.nextLine();

        System.out.println("Enter age: ");
        int age = input.nextInt();

        pw.println(name + ", " + address +", "+age);
        pw.close();
    }
}

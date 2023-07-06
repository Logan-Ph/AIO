import java.util.*;
import java.io.*;
public class Exercise12 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new FileWriter("src/users.txt",false));

        System.out.println("Please enter your name: ");
        String name = input.nextLine();

        System.out.println("Please enter your address: ");
        String address = input.nextLine();

        System.out.println("Please enter your age: ");
        int age = input.nextInt();

        pw.printf("%s,%s,%d",name,address,age);
        pw.close();

        Scanner read = new Scanner(new File("src/users.txt"));
        while (read.hasNext()){
            String line = read.nextLine();
            StringTokenizer inread = new StringTokenizer(line,",");
            name = inread.nextToken();
            address = inread.nextToken();
            age = Integer.parseInt(inread.nextToken());
            System.out.printf("%s %s %d ",name,address,age);

        }

    }
}

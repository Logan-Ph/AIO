import java.util.*;
import java.io.*;
public class readUsers {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/users.txt"));
        while (file.hasNext()){
            String line = file.nextLine();
            StringTokenizer read = new StringTokenizer(line,", ");
            if (read.countTokens()!= 3){
                throw new IOException("Invalid input format!");
            }
            else {
                String name = read.nextToken();
                String address = read.nextToken();
                int age = Integer.parseInt(read.nextToken());
                System.out.println(name + " lives at " +address +" and is " + age + " years old ");
            }
        }
    }
}

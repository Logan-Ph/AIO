import java.io.File;
import java.io.IOException;
import java.util.*;

public class readFileTest {
    public static void main(String[] args) {
        boolean continueloop = true;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Please enter the file name");
            try (Scanner console = new Scanner(new File(input.next()))) {
                System.out.println(console.nextLine());
                System.out.println(console.nextLine());
                continueloop = false;
            } catch (IOException e) {
                System.out.println("There is something wrong with the file IO!");
                System.out.println("Please check the file path or check if the file exists!");
            } catch (NoSuchElementException e) {
                System.out.println("The content of the file is wrongly formatted! Potentially missing field!");
            }

        } while (continueloop);
    }
}

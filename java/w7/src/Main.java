// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        Scanner filescanner = new Scanner(new File("src/marks.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("src/hello.txt", false));

        while (filescanner.hasNext()){
            pw.println(filescanner.nextLine());
        }

        filescanner.close();
        pw.close();
    }
}
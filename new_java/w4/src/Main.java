import java.util.HashSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        HashSet<String> cars1 = new HashSet<String>();
        HashSet<String> cars2 = new HashSet<String>();

        cars1.add("BMW");
        cars1.add("Maseriti");

        cars1.add("BMW");
        cars1.add("Mec");

        System.out.println(cars1);

    }
}
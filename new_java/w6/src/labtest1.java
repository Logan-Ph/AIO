import java.util.*;

public class labtest1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the string");
        String string = input.nextLine();
        String output = String.valueOf(string.charAt(0));
        for (int i = 1; i < string.length(); i++) {
            if ((Character.isUpperCase(string.charAt(i)) && Character.isLowerCase(string.charAt(i - 1))) || (Character.isLowerCase(string.charAt(i)) && Character.isUpperCase(string.charAt(i - 1)))) {
                output += "&" + string.charAt(i);
            } else {
                output += string.charAt(i);
            }
        }
        System.out.println(output);
    }
}

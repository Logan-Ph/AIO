import java.beans.Introspector;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class Ingredient {
    private Hashtable<String,String> attribute = new Hashtable<String,String>();
    private static Scanner input = new Scanner(System.in);

    private Ingredient(Hashtable<String, String> attribute) {
        this.attribute = attribute;
    }


     static Ingredient createIngredient() {
        String sentinal;
         Hashtable<String,String> attribute = new Hashtable<String,String>();
        do {
            System.out.println("Enter the attribute you want to add to Ingredient:");
            String key = input.nextLine();
            System.out.println("Enter the value of the attribute");
            String value = input.nextLine();
            attribute.put(key, value);
            System.out.println("Enter 'c' to exit or else to add more component to Ingredient");
            sentinal = String.valueOf(input.nextLine().charAt(0));
        } while (!sentinal.equals("c"));

        return new Ingredient(attribute);
    }

    public void displayIngredient(){
        System.out.println("--------------------------");
        System.out.println(this.attribute);
    }

}

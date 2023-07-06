import java.util.*;

public class Ingredient {
    static Scanner input = new Scanner(System.in);
     String name, unit;
     double amount;
     static String[] validation = {"spoon", "teaspoon", "mg", "kg"};

    public Ingredient(String name, String unit, double amount) {
        this.name = name;
        this.unit = unit;
        this.amount = amount;
    }

    public static Ingredient createIngredient() {
        System.out.println("Please input the name of the Ingredient:");
        String name = input.next();
        System.out.println("Please input the measurement of the Ingredient:");
        String unit = input.next();
        while (!Arrays.asList(validation).contains(unit)) {
            System.out.println("Error unit! Please re-enter again:");
            unit = input.next();
        }
        System.out.println("Please input the amount of the Ingredient:");
        double amount = input.nextDouble();

        Ingredient ingre = new Ingredient(name,unit,amount);
        return ingre;
    }

    public void displayIngredient() {
        System.out.println("The Ingredient is: " + this.name + " and the measurement unit is: " + this.unit);
        System.out.printf("The amount is: %.2f\n", this.amount);
        System.out.println("-------------------------");
    }
}

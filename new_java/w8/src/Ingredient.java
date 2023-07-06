import java.util.*;
public class Ingredient implements Comparable<Ingredient>{
    static Scanner input = new Scanner(System.in);
    private String name, unit, cmt;
    private double amount;
    static String[] validation = {"spoon", "teaspoon", "mg", "kg","g","l","ml","cup"};

    public Ingredient(String name, String unit, double amount, String cmt){
        this.name = name;
        this.unit = unit;
        this.amount = amount;
        this.cmt = cmt;
    }

    public static Ingredient createIngredient() {
        input.nextLine();
        System.out.println("Please enter the name of the Ingredient:");
        String name = input.nextLine();
        System.out.println("Please enter the measurement of the Ingredient:");
        String unit = input.nextLine();
        while (!Arrays.asList(validation).contains(unit)) {
            System.out.println("Error unit! Please re-enter again:");
            unit = input.nextLine();
        }
        System.out.println("Please enter the amount of the Ingredient:");
        double amount = input.nextDouble();
        System.out.println("Please provide comment for the ingredient");
        String cmt = input.nextLine();

        Ingredient ingre = new Ingredient(name,unit,amount,cmt);
        return ingre;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public String getCmt() {
        return cmt;
    }

    @Override
    public int compareTo(Ingredient o) {
        if(o.getAmount() == this.amount){
            return 0;
        } else if (o.getAmount()<this.amount) {
            return 1;
        }
        else { return -1;}
    }
}

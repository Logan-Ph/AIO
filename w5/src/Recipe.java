import java.util.ArrayList;
import java.util.Scanner;

public class Recipe {
    private static Scanner input = new Scanner(System.in);
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private final String name;
    private static int number = 0;

    private Recipe(ArrayList<Ingredient> ingredients, String name) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public static Recipe createRecipeComponent(){
        String sentinel;
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        System.out.println("Enter the name of the Recipe");
        String name = input.nextLine();
        do {
            ingredients.add(addComponent());
            System.out.println("Enter 'c' to exit or else to add more Ingredient to Recipe");
            sentinel = String.valueOf(input.nextLine().charAt(0));
        }while (!sentinel.equals("c"));

        number++;
        return new Recipe(ingredients,name);
    }

    private static Ingredient addComponent(){
        return Ingredient.createIngredient();
    }

    public void displayRecipeComponent(){
        System.out.printf("Recipe name: %s%n",this.name);
        for (Ingredient ingredient:this.ingredients){
            ingredient.displayIngredient();
        }
    }

    public static int getNumber() {
        return number;
    }
}

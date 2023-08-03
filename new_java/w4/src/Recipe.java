import java.util.*;

public class Recipe {
    static Scanner input = new Scanner(System.in);
    static private Ingredient[] ingredients;

    private String name;
    private static int count = 0;

    public Recipe(String name, Ingredient[] ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public static Recipe createRecipe() {
        System.out.println("Please enter the name of the recipe: ");
        String name = input.nextLine();
        System.out.println("Please enter the number of the ingredients: ");
        int n = input.nextInt();
        ingredients = new Ingredient[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Adding new component....");
            Ingredient i1 = Ingredient.createIngredient();
            ingredients[i] = i1;
        }
        count = n;

        Recipe r = new Recipe(name, ingredients);
        System.out.println(name + " (Recipe)");
        for (Ingredient i : ingredients) {
            i.displayIngredient();
        }
        return r;
    }
}

import java.util.*;
public class Recipe {
    static Scanner input = new Scanner(System.in);
     static String name;
     static ArrayList<Ingredient> components;
     static int count = 0;
    public Recipe(String name, ArrayList<Ingredient> components){
        this.name= name;
        this.components = components;
        count++;
    }

    public static Recipe createRecipe(){
        System.out.println("Please enter the name of the recipe: ");
        String name = input.nextLine();
        System.out.println("Please enter the number of the ingredients: ");
        int n = input.nextInt();
        components = new ArrayList<>();

        for (int i=0; i<n;i++){
            System.out.println("Adding new component....");
            Ingredient i1 = Ingredient.createIngredient();
            components.add(i1);
        }

        Recipe r = new Recipe(name,components);
        System.out.println(name +" (Recipe)");
        for (Ingredient i: components){
            i.displayIngredient();
        }
        return r;
    }
}

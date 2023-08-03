public class TestRecipe {
    public static void main(String[] args) {
        Recipe r = Recipe.createRecipeComponent();

        Recipe r1 = Recipe.createRecipeComponent();

        r.displayRecipeComponent();
        System.out.println("xxxxxxxxxxxxxxxxxx");
        r1.displayRecipeComponent();

        System.out.println(Recipe.getNumber());
    }
}

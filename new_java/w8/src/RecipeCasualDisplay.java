public class RecipeCasualDisplay{
    public void print(Ingredient[] ingredients){
        for(Ingredient i: ingredients){
            System.out.println("The Ingredient is: " + i.getName() + " and the measurement unit is: " + i.getUnit());
            System.out.printf("The amount is: %.2f%n", i.getAmount());
            System.out.printf("Comment: %s%n",i.getCmt());
            System.out.println("-------------------------");
        }
    }
}

package FactoryPattern.FactoryMethod;

public class NYPizzaStore extends PizzaStore{
    @Override
    public Pizza createPizza(String item) {
        if (String.valueOf(item).equals("cheese")) {
            return new NYStyleCheesePizza();
        }
        return null;
    }
}

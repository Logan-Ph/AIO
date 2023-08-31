package FactoryPattern.FactoryMethod;

public class ChicagoPizzaStore extends PizzaStore{
    @Override
    public Pizza createPizza(String item) {
        if (String.valueOf(item).equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }
}

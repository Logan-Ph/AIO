package DecoratorPattern;

public class Mocha extends CondimentDecorator{
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        switch (beverage.getSize()){
            case TALL: cost+= .1;
                        break;
            case VENTI:cost+=.15;
                        break;
            case GRANDE:cost+=.20;
                        break;
        }
        return cost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}

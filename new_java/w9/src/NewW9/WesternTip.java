package NewW9;

public class WesternTip implements CalculateTipBehavior{
    @Override
    public double calculateTip(double sum) {
        return (sum*0.1);
    }
}

package NewW9;

import java.util.Random;

public class OtherTip implements CalculateTipBehavior{
    @Override
    public double calculateTip(double sum) {
        return (sum* ( (double) new Random().nextInt(0, 11) /100));
    }
}

import java.util.*;
public class Dice {
    Random random = new Random();
    private int value;

    public Dice(){
    }

    public void roll(){
        value = random.nextInt(1,7);
    }

    public int getValue(){
        return value;
    }
}

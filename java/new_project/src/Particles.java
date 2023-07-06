import java.util.*;
public class Particles {
    Random random = new Random();
    protected int x,y;

    public Particles(Box b){
        this.x = random.nextInt(b.width);
        this.y = random.nextInt(b.height);
    }

}

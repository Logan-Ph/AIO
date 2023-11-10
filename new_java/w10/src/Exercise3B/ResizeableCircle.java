package Exercise3B;

public class ResizeableCircle extends Circle implements Resizeable{
    public ResizeableCircle(double radius) {
        super(radius);
    }

    @Override
    public void resize(int percent) {
        radius *= percent/100.0;
    }

    @Override
    public String toString() {
        return "ResizeableCircle{" +
                super.toString() +
                '}';
    }
}

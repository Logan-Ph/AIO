public class ResizeableCircle extends Circle2 implements Resizeable{
    public ResizeableCircle(double radius) {
        super(radius);
    }

    @Override
    public void resize(int percent) {
        this.radius *= percent/100.0;
    }

    @Override
    public String toString() {
        return "ResizeableCircle["+super.toString()+"]";
    }
}

public class Rectangle1 implements GeometricObject{
    private double width;
    private double length;

    public Rectangle1(double width, double length){
        this.length = length;
        this.width = width;
    }
    @Override
    public double getArea() {
        return this.length * this.width;
    }

    @Override
    public double getPerimeter() {
        return 2*(this.length+this.width);
    }

    @Override
    public String toString() {
        return "Rectangle1[" +
                "width=" + width +
                ", length=" + length +
                ']';
    }
}

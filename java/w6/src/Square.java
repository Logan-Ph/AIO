public class Square extends Rectangle{
    private double side;
    public Square(){}
    public Square(double side){
        super(side,side);
    }

    public Square(double side,String color, boolean filled){
        super(color,filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void setWidth(double width) {
        super.setLength(width);
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public String toString() {
        return "Square[" + super.toString() + "]";
    }
}

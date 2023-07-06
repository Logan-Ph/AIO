public class Triangle extends Shape{
    private int base,height;
    public Triangle(String color, int base, int height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return 0.5*getBase()*getHeight();
    }

    @Override
    public String toString() {
        return "Rectangle[color= "+getColor()+", base= "+getBase()+ ", height= "+getHeight()+ "]";
    }


}

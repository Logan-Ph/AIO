public class Rectangle extends Shape{
    private int length, width;
    public Rectangle(String color,int length, int width){
        super(color);
        this.width = width;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public double getArea(){
        return getLength() * getWidth();
    }

    @Override
    public String toString() {
        return "Rectangle[color= "+this.getColor()+", lenght= "+getLength()+", width= "+getWidth() + "]";
    }


}

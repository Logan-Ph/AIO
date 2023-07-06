public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle(15);

        System.out.println("The area of the circle of radius " + c1.getRadius() + " is " + c1.Area());

        Circle c0 = new Circle();
        System.out.println("The area of the circle of radius " + c0.getRadius() + " is " + c0.Area());

        c0.setRadius(10);
        System.out.println("The area of the circle of radius " + c0.getRadius() + " is " + c0.Area());
    }
}

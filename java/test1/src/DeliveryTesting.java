public class DeliveryTesting {
    public static void main(String[] args) {
        Client Jerry = new Client("Jerry");
        Jerry.Booked(2.00,"FoodDeliveryService");
        System.out.println(Jerry);

        Driver Tom = new Driver("Tom");
        Tom.accepts(Jerry);
        System.out.println(Jerry);

        Tom.completes(Jerry);
        System.out.println(Jerry);
        System.out.println(Tom);


        Client Phong = new Client("Phong");
        Phong.Booked(10.00,"ExpressDeliveryService");
        System.out.println(Phong);

        Tom.accepts(Phong);
        System.out.println(Phong);

        Tom.completes(Phong);
        System.out.println(Phong);
        System.out.println(Tom);

    }
}

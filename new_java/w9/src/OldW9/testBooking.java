package OldW9;

public class testBooking {
    public static void main(String[] args) {
        OtherBooking b = new OtherBooking();
        b.addItem(new Item("Iphone",1900));
        b.addItem(new Item("Ipad",3200));
        b.addItem(new Item("macbook",4000));
        System.out.println(b.bookingSum());

    }
}

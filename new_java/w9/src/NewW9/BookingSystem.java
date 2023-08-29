package NewW9;

import OldW9.Item;

public class BookingSystem {
    public static void main(String[] args) {
        Booking b = new WesternBooking();
        b.addDiscount(new VoucherDiscount("GREAT", 50));
        b.addItem(new NewW9.Item("Iphone",1900));
        b.addItem(new NewW9.Item("Ipad",3200));
        b.addItem(new NewW9.Item("macbook",4000));
        System.out.println(b.bookingSum());


        Booking b2 = new OtherBooking();
        b2.addDiscount(new SpecialEventDiscount("OMG", 99));
        b2.addDiscount(new VoucherDiscount("GREAT", 50));
        b2.addDiscount(new VoucherDiscount("GREAT", 50));
        b2.addItem(new NewW9.Item("Iphone",1900));
        b2.addItem(new NewW9.Item("Ipad",3200));
        b2.addItem(new NewW9.Item("macbook",4000));
        System.out.println(b2.bookingSum());
    }
}

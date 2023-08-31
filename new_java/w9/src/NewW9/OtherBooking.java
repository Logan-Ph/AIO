package NewW9;

import java.util.ArrayList;
import java.util.Random;

public class OtherBooking extends Booking {

    public OtherBooking() {
        this.setCalculateTipBehavior(new OtherTip());
    }
}

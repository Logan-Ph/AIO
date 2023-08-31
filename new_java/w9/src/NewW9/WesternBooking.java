package NewW9;

import java.util.ArrayList;

public class WesternBooking extends Booking{

    public WesternBooking(){
        this.setCalculateTipBehavior(new WesternTip());
    }

}

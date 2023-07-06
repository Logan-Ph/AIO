import java.util.ArrayList;
import java.util.Random;

public class OtherBooking extends Booking implements Taxable{
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Discount> discounts = new ArrayList<>();

    Random random = new Random();

    public double bookingSum(){
        int sum = 0;
        double booktip = Double.parseDouble(String.format("%.2f",random.nextInt(0,11)/100.0)) ;
        for (Discount discount: discounts){
            if(discount instanceof VoucherDiscount){
                VoucherDiscount voucherDiscount = (VoucherDiscount) discount;
                sum+=(super.bookingSum()<voucherDiscount.calculateDiscountedAmount())?0:super.bookingSum()- voucherDiscount.calculateDiscountedAmount();
                if (sum == 0){
                    return super.bookingSum()*booktip + this.calculateTax();
                }
            } else if (discount instanceof PercentOffDiscount) {
                PercentOffDiscount percentOffDiscount = (PercentOffDiscount) discount;
                sum += ((int) percentOffDiscount.calculateDiscountedAmount() == 1)?0:super.bookingSum()*percentOffDiscount.calculateDiscountedAmount();
                if (sum == 0){
                    return super.bookingSum()*booktip + this.calculateTax();
                }
            } else if (discount instanceof SpecialEventDiscount) {
                SpecialEventDiscount specialEventDiscount = (SpecialEventDiscount) discount;
                int tip = specialEventDiscount.calculateDiscountedAmount();
                double percent = Double.parseDouble(String.format("%.2f",tip/100.0));
                sum+= (super.bookingSum()-tip<super.bookingSum()*(1-percent/100))?super.bookingSum()-tip:super.bookingSum()*(1-tip/100);
                if (sum<=0){
                    return super.bookingSum()*booktip + this.calculateTax();
                }
            }
        }
        return sum+super.bookingSum()*(booktip+1) + this.calculateTax();
    }

    @Override
    public double calculateTax() {
        return super.bookingSum()*0.1;
    }

    public void addDiscount(Discount discount){
        this.discounts.add(discount);
    }
}

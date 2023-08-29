package NewW9;

public class PercentOffDiscount implements Discount{

    private String code;
    private int percent;

    public PercentOffDiscount(String code, int percent) {
        this.code = code;
        this.percent = percent;
    }

    @Override
    public double calculateDiscountedAmount(double price) {
        return price*((double) (100 - percent) /100);

    }
}

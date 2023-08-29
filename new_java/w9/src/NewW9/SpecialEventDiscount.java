package NewW9;

public class SpecialEventDiscount implements Discount{

    private String code;
    private int value;

    public SpecialEventDiscount(String code, int value) {
        this.code = code;
        this.value = value;
    }

    public SpecialEventDiscount(){}

    @Override
    public double calculateDiscountedAmount(double sum) {
        return Math.min(((this.value > sum) ? 0 : sum - value), (sum * ((double) (100 - this.value) / 100)));
    }
}

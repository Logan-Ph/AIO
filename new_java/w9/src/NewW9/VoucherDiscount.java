package NewW9;

public class VoucherDiscount implements Discount{
    private String code;
    private double amount;


    public VoucherDiscount() {
    }

    public VoucherDiscount(String code, double amount) {
        this.code = code;
        this.amount = amount;
    }

    @Override
    public double calculateDiscountedAmount(double price) {
        return (this.amount > price)? 0: price - amount;
    }

}

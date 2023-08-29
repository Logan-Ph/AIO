package OldW9;

public class VoucherDiscount extends Discount{
    private String code;
    private double amount;

    public VoucherDiscount(String code, double amount) {
        this.amount = amount;
        this.code = code;
    }

   public double calculateDiscountedAmount(){
        return amount;
   }
}

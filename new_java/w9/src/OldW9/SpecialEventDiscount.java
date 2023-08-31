package OldW9;

public class SpecialEventDiscount extends Discount{
    private String code;
    private int value;

    public SpecialEventDiscount(String code, int value){
        this.code = code;
        this.value = value;
    }

    public int calculateDiscountedAmount(){
        return value;
    }
}

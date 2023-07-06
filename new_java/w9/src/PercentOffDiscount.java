import java.util.Random;

public class PercentOffDiscount extends Discount{
    private String code;
    private int percent;

    public PercentOffDiscount(String code, int percent){
        this.code = code;
        this.percent = percent;
    }

    public double calculateDiscountedAmount(){
        double tip = Double.parseDouble(String.format("%.2f",percent/100.0));
        return tip;
    }
}

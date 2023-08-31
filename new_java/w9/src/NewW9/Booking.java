package NewW9;

import java.util.ArrayList;

public abstract class Booking {
    private ArrayList<Item> items = new ArrayList<>();
    private CalculateTipBehavior calculateTipBehavior;
    private ArrayList<Discount> discounts = new ArrayList<>();

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void addDiscount(Discount discount){
        this.discounts.add(discount);
    }

    private double calculateSum(){
        int sum = 0;
        for (Item item: items){
            sum+= item.getPrice();
        }
        return sum;
    }

    public double bookingSum() {
        double price = calculateSum();
        for (Discount discount: this.discounts){
            price = discount.calculateDiscountedAmount(price);
        }
        return price + calculateTip(calculateSum());
    }

    public void setCalculateTipBehavior(CalculateTipBehavior calculateTipBehavior) {
        this.calculateTipBehavior = calculateTipBehavior;
    }

    public double calculateTip(double sum){
        return calculateTipBehavior.calculateTip(sum);
    }
}

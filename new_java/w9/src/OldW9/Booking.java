package OldW9;

import java.util.ArrayList;

public class Booking {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item){
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double bookingSum(){
       int sum = 0;
       for (Item item:this.items){
           sum+=item.getPrice();
       }
       return sum;
    }
}

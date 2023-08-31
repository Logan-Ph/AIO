package NewW9;

public class Item {
    private float price;
    private String name;

    public Item(String name, float price){
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}

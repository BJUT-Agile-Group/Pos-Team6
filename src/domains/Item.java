package domains;

/**
 * Created by Sylvia on 2014/12/30.
 */
public class Item {
    private String barCode;
    private String name;
    private String unit;
    private double price;
    private int quantity;

    public Item(String barCode, String name, String unit, double price) {

        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.quantity=1;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(){
        quantity++;
    }
}

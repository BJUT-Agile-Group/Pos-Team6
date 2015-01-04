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
    private double discount;
    private boolean promotion;

    public Item(String barCode,String name, String unit, double price) {
        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.quantity=1;
        this.discount=1;
        this.promotion=false;
    }

    public Item( String barCode,String name, String unit, double price,double discount) {
        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.quantity=1;
        this.discount=discount;
        this.promotion=false;
    }

    public Item(String barCode,String name, String unit, double price,boolean promotion) {
        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.quantity=1;
        this.discount=1;
        this.promotion=promotion;
    }

    public Item(String barCode,String name, String unit, double price,int quantity){
        this.barCode = barCode;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.quantity=quantity;
        this.discount=1;
        this.promotion=false;
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

    public boolean isPromotion() {
        return promotion;

    }

    public void subQuantity(){
        quantity--;
    }
    public double getDiscount() {
        return discount;
    }

    public String getBarCode() {
        return barCode;
    }
}

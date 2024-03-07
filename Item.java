// item name and price
public class Item {
    private String name;
    private double price;
    // minimum quantity for bulk discount
    private int bulkQuantity;
    private double bulkDiscount; // discounted price for bulk orders

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        this.bulkQuantity = 0; // Default: no bulk discount
        this.bulkDiscount = price; // Default: no discount
    }

    public Item(String name, double price, int bulkQuantity, double bulkDiscount) {
        this.name = name;
        this.price = price;
        this.bulkQuantity = bulkQuantity;
        this.bulkDiscount = bulkDiscount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getBulkQuantity() {
        return bulkQuantity;
    }

    public double getBulkDiscount() {
        return bulkDiscount;
    }

       }
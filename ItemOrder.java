 public class ItemOrder {
    private Item item;
    private int quantity;
// constructor for item order to item and quantity
    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
// get item and quantity
    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}

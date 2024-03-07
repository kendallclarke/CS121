public class Main {
    public static void main(String[] args) {
        // Create an item with bulk discount
        Item tissues = new Item("Tissues", 3.0, 2, 4.0); // 2 boxes for $4

        // Create an item order for 2 boxes of tissues
        ItemOrder order1 = new ItemOrder(tissues, 2);

        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();
        cart.addItemOrder(order1);

        System.out.println("Total price of items in the cart is $" + cart.getTotalPrice());
    }
}
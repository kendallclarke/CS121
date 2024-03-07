
import java.util.ArrayList;

    public class ShoppingCart {
        private ArrayList<ItemOrder> orderList;

        public ShoppingCart() {
            orderList = new ArrayList<>();
        }

        public void addItemOrder(ItemOrder itemOrder) {
            orderList.add(itemOrder);
        }

        public void removeItemOrder(ItemOrder itemOrder) {
            orderList.remove(itemOrder);
        }

        public double getTotalPrice() {
            double totalPrice = 0;
            for (ItemOrder order : orderList) {
                totalPrice += order.getItem().getPrice() * order.getQuantity();
            }
            return totalPrice;
        }}


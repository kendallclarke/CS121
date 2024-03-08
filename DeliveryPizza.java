// sublcass from pizza class that adds double delivery fee and string delivery address
public class DeliveryPizza extends Pizza {
    private double deliveryFee;
    private String deliveryAddress;

    public DeliveryPizza(String[] toppings, String deliveryAddress, int numToppings) {
        super(toppings, numToppings);
        this.deliveryAddress = deliveryAddress;
        calculateDeliveryFee();
    }

    private void calculateDeliveryFee() {
        if (super.getPrice() > 18) {
            deliveryFee = 3;
        } else {
            deliveryFee = 5;
        }
    }

    public String toString() {
        String pizzaDetails = super.toString();
        pizzaDetails += "\nDelivery Address: " + deliveryAddress + "\nDelivery Fee: $" + deliveryFee;
        return pizzaDetails;
    }
}

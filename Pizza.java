// create string array holding up to 10 toppings
public class Pizza {
    private String[] toppings;
    private double price;
// takes in array of toppings and store number of toppings
    public Pizza(String[] toppings, int numToppings) {
        this.toppings = new String[numToppings];
        for (int i = 0; i < numToppings; i++) {
            this.toppings[i] = toppings[i];
        }
        calculatePrice();
    }
// calculate total price of order with toppings
    private void calculatePrice() {
        price = 14 + (2 * toppings.length);
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        StringBuilder description = new StringBuilder("Pizza with toppings: ");
        for (int i = 0; i < toppings.length; i++) {
            description.append(toppings[i]);
            if (i < toppings.length - 1) {
                description.append(", ");
            }
        }
        description.append("\nPrice: $").append(price);
        return description.toString();
    }
}
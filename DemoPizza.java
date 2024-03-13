import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

public class DemoPizza {
    public static void main(String[] args) {
        String[] defaultToppings = {"extra mozzarella", "pepperoni", "parmesan", "basil", "burrata", "prosciutto", "sausage", "peppers", "broccoli rabe", "olives"};
        String[] selectedToppings = new String[10];
        final int[] numToppings = {0};
        final AtomicReference<String>[] input = new AtomicReference[]{new AtomicReference()};
        final String QUIT = "QUIT";

        // GUI for user input, colors, backgrounds
        JFrame frame = new JFrame("Pizza Toppings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Enter your desired toppings with an option of numerical values 1- 10 (or type QUIT to finish):");
        label.setForeground(Color.PINK);
        panel.add(label);
        JTextField textField = new JTextField();
        textField.setForeground(Color.blue);
        panel.add(textField);
        JButton button = new JButton("Add Topping");
        button.setBackground(Color.PINK);
        panel.add(button);
        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);
// action listener for number of toppings entered
        button.addActionListener(e -> {
            input[0].set(textField.getText());
            if (input[0].get().equalsIgnoreCase(QUIT) || numToppings[0] >= 10) {
                frame.dispose();
                if (numToppings[0] > 0) {
                    String[] selectedToppingsTrimmed = new String[numToppings[0]];
                    System.arraycopy(selectedToppings, 0, selectedToppingsTrimmed, 0, numToppings[0]);
                    displayPizza(selectedToppingsTrimmed);
                } else {
                    System.out.println("No toppings selected!");
                }
            } else {
                selectedToppings[numToppings[0]] = String.valueOf(input[0]);
                textArea.append(input[0] + "\n");
                numToppings[0]++;
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
// delivery options and Pizza order display
    public static void displayPizza(String[] toppings) {
        Object[] options = {"Yes", "No"};
        int choice = JOptionPane.showOptionDialog(null, "Do you want the pizza to be delivered?", "Delivery Option", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (choice == JOptionPane.YES_OPTION) {
            String address = JOptionPane.showInputDialog(null, "Enter an address:");
            DeliveryPizza deliveryPizza = new DeliveryPizza(toppings, address, toppings.length);
            JOptionPane.showMessageDialog(null, deliveryPizza.toString(), "Pizza Order", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Pizza pizza = new Pizza(toppings, toppings.length);
            JOptionPane.showMessageDialog(null, pizza.toString(), "Pizza Order", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

      

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TissuesCalculatorGUI {
    private JTextField quantityTextField;
    private JLabel resultLabel;

    public TissuesCalculatorGUI() {
        JFrame frame = new JFrame("Tissues Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);


        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel quantityLabel = new JLabel("Enter quantity of tissues:");
        quantityLabel.setForeground(Color.PINK);
        quantityTextField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBackground(Color.WHITE);
        calculateButton.setForeground(Color.PINK);
        resultLabel = new JLabel();

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int quantity = Integer.parseInt(quantityTextField.getText());
                    double totalPrice = calculateTotalPrice(quantity);
                    resultLabel.setText("Total price: $" + totalPrice);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter a valid integer.");
                }
            }
        });

        panel.add(quantityLabel);
        panel.add(quantityTextField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);
    }

    private double calculateTotalPrice(int quantity) {
        // Create an item with bulk discount
        Item tissues = new Item("Tissues", 3.0, 2, 4.0); // 2 boxes for $4

        double totalPrice = 0.0;
        int bulkQuantity = tissues.getBulkQuantity();
        double bulkDiscount = tissues.getBulkDiscount();

        // If the quantity is greater than or equal to the bulk quantity,
        // apply the bulk discount
        if (quantity >= bulkQuantity) {
            int bulkCount = quantity / bulkQuantity;
            int remainder = quantity % bulkQuantity;
            totalPrice = bulkCount * bulkDiscount + remainder * tissues.getPrice();
        } else {
            totalPrice = quantity * tissues.getPrice();
        }

        return totalPrice;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TissuesCalculatorGUI());
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Use labels and boxes from JFrame
public class PizzaAPP extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JLabel sizeLabel;
    private JLabel toppingsLabel;
    private JComboBox<String> sizeComboBox;
    private JComboBox<Integer> toppingsComboBox;

    private JComboBox<String> extraCheeseBox;
    private JButton calculateButton;
// Create Window Size, Color, name
    public PizzaAPP() {
        setTitle("Pizza Order App");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        // Set background color
        getContentPane().setBackground(Color.PINK);

        // label color, font, size, name
        titleLabel = new JLabel("Pizza Order");
        titleLabel.setFont(new Font("Courier", Font.BOLD, 50));
        titleLabel.setForeground(new Color(147, 135, 214)); // Set text color
        add(titleLabel);
// label color, font, size, name
        sizeLabel = new JLabel("Select size:");
        sizeLabel.setFont(new Font("Courier", Font.ITALIC, 30));
        sizeLabel.setForeground(Color.WHITE); // Set text color
        add(sizeLabel);
// set options for pizza size
        sizeComboBox = new JComboBox<>(new String[]{"Small", "Medium", "Large", "Super"});
        sizeComboBox.setBackground(Color.WHITE); // Set button background color;
        sizeComboBox.setForeground(Color.PINK); // Set text color
        add(sizeComboBox);
// set label for toppings
        toppingsLabel = new JLabel("Select number of toppings:");
        toppingsLabel.setFont(new Font("Courier", Font.ITALIC, 30));
        toppingsLabel.setForeground(Color.WHITE); // Set text color
        add(toppingsLabel);
// set options for pizza toppings
        toppingsComboBox = new JComboBox<>(new Integer[]{0, 1, 2, 3});
        toppingsComboBox.setBackground(Color.WHITE); // Set button background color;
        toppingsComboBox.setForeground(Color.PINK); // Set text color
        add(toppingsComboBox);
        extraCheeseBox = new JComboBox<>(new String[]{"No Extra Cheese", "Extra Cheese"});
        extraCheeseBox.setBackground(Color.WHITE); // Set button background color;
        extraCheeseBox.setForeground(Color.PINK); // Set text color
        add(extraCheeseBox);

// create button to calculate price
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        calculateButton.setBackground(Color.WHITE); // Set button background color
        calculateButton.setForeground(Color.PINK); // Set button text color
        add(calculateButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // set price of pizza size
        int choice = sizeComboBox.getSelectedIndex();
        double basePrice = 0;
        if (choice==0) {
                basePrice = 5; }
        else if (choice==1){
                basePrice = 10;}
        else if (choice==2){
                basePrice = 15;}
        else {
                basePrice = 20;
        }

        int numToppings = (Integer) toppingsComboBox.getSelectedItem();
        double additionalCharge = 0;
        // set price of pizza toppings
        if (numToppings == 1) {
            additionalCharge = 0.5;
        } else if (numToppings == 2) {
            additionalCharge = 1;
        } else if (numToppings == 3) {
            additionalCharge = 1.25;
        }
// calculate total price
        double totalPrice = basePrice + additionalCharge;
        JOptionPane.showMessageDialog(this, "Total price for your order: $" + totalPrice);
    }
// display app
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PizzaAPP().setVisible(true);
            }
        });
    }
}

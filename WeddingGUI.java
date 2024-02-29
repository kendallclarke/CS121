import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class WeddingGUI extends JFrame {
    private JTextField brideFirstNameField;
    private JTextField brideLastNameField;
    private JTextField groomFirstNameField;
    private JTextField groomLastNameField;
    private JTextField weddingDateField;
    private JTextField weddingLocationField;
    private JTextField numberOfGuestsField;
    private JButton createWeddingButton;

    public WeddingGUI() {
        setTitle("Wedding Planner");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Customizing fonts and colors
        Font labelFont = new Font("Serif", Font.BOLD, 14);
        Color labelColor = new Color(75, 105, 153);
        Font textFieldFont = new Font("Serif", Font.PLAIN, 14);
        Color textFieldColor = new Color(75, 105, 153);
// Labels for bride
        JLabel brideLabel = new JLabel("Bride's Name:");
        brideLabel.setFont(labelFont);
        brideLabel.setForeground(labelColor);
        brideFirstNameField = new JTextField(10);
        brideFirstNameField.setFont(textFieldFont);
        brideFirstNameField.setForeground(textFieldColor);
        brideLastNameField = new JTextField(10);
        brideLastNameField.setFont(textFieldFont);
        brideLastNameField.setForeground(textFieldColor);
        JPanel bridePanel = new JPanel();
        bridePanel.add(brideLabel);
        bridePanel.add(brideFirstNameField);
        bridePanel.add(brideLastNameField);
        panel.add(bridePanel);
// groom labels
        JLabel groomLabel = new JLabel("Groom's Name:");
        groomLabel.setFont(labelFont);
        groomLabel.setForeground(labelColor);
        groomFirstNameField = new JTextField(10);
        groomFirstNameField.setFont(textFieldFont);
        groomFirstNameField.setForeground(textFieldColor);
        groomLastNameField = new JTextField(10);
        groomLastNameField.setFont(textFieldFont);
        groomLastNameField.setForeground(textFieldColor);
        JPanel groomPanel = new JPanel();
        groomPanel.add(groomLabel);
        groomPanel.add(groomFirstNameField);
        groomPanel.add(groomLastNameField);
        panel.add(groomPanel);
// date labels
        JLabel weddingDateLabel = new JLabel("Wedding Date (YYYY-MM-DD):");
        weddingDateLabel.setFont(labelFont);
        weddingDateLabel.setForeground(labelColor);
        weddingDateField = new JTextField(10);
        weddingDateField.setFont(textFieldFont);
        weddingDateField.setForeground(textFieldColor);
        JPanel weddingDatePanel = new JPanel();
        weddingDatePanel.add(weddingDateLabel);
        weddingDatePanel.add(weddingDateField);
        panel.add(weddingDatePanel);
// location labels
        JLabel weddingLocationLabel = new JLabel("Wedding Location:");
        weddingLocationLabel.setFont(labelFont);
        weddingLocationLabel.setForeground(labelColor);
        weddingLocationField = new JTextField(20);
        weddingLocationField.setFont(textFieldFont);
        weddingLocationField.setForeground(textFieldColor);
        JPanel weddingLocationPanel = new JPanel();
        weddingLocationPanel.add(weddingLocationLabel);
        weddingLocationPanel.add(weddingLocationField);
        panel.add(weddingLocationPanel);
// guest number label
        JLabel numberOfGuestsLabel = new JLabel("Number of Guests:");
        numberOfGuestsLabel.setFont(labelFont);
        numberOfGuestsLabel.setForeground(labelColor);
        numberOfGuestsField = new JTextField(10);
        numberOfGuestsField.setFont(textFieldFont);
        numberOfGuestsField.setForeground(textFieldColor);
        JPanel numberOfGuestsPanel = new JPanel();
        numberOfGuestsPanel.add(numberOfGuestsLabel);
        numberOfGuestsPanel.add(numberOfGuestsField);
        panel.add(numberOfGuestsPanel);
// create wedding button
        createWeddingButton = new JButton("Create Wedding!!!");
        createWeddingButton.setFont(labelFont);
        createWeddingButton.setForeground(Color.WHITE);
        createWeddingButton.setBackground(new Color(232, 158, 204)); // Custom background color
        createWeddingButton.addActionListener(new CreateWeddingListener());
        panel.add(createWeddingButton);

        // Customizing panel background color
        panel.setBackground(new Color(156, 86, 115)); // Custom panel background color

        add(panel);
        setVisible(true);
    }
// use action listener
    private class CreateWeddingListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String brideFirstName = brideFirstNameField.getText();
            String brideLastName = brideLastNameField.getText();
            String groomFirstName = groomFirstNameField.getText();
            String groomLastName = groomLastNameField.getText();
            String weddingDateString = weddingDateField.getText();
            String weddingLocation = weddingLocationField.getText();
            int numberOfGuests = Integer.parseInt(numberOfGuestsField.getText());

            LocalDate weddingDate = LocalDate.parse(weddingDateString);
// prompts
            Person bride = new Person(brideFirstName, brideLastName);
            Person groom = new Person(groomFirstName, groomLastName);
            Couple couple = new Couple(bride, groom);
            Wedding wedding = new Wedding(couple, weddingDate, weddingLocation, numberOfGuests);
// display inputs
            JOptionPane.showMessageDialog(null, "Wedding details:\n" +
                    "Bride: " + bride.getFirstName() + " " + bride.getLastName() + "\n" +
                    "Groom: " + groom.getFirstName() + " " + groom.getLastName() + "\n" +
                    "Date: " + wedding.getWeddingDate() + "\n" +
                    "Location: " + wedding.getLocation() + "\n" +
                    "Number of Guests: " + wedding.getNumberOfGuests());
        }
    }

    public static void main(String[] args) {
        new WeddingGUI();
    }
}
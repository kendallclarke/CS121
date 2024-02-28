import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// declare variable names
public class PartyGUI extends JFrame {
    private JLabel partyLabel, dinnerPartyLabel;
    private JTextField partyTextField, dinnerPartyTextField;
    private JButton partyButton, dinnerPartyButton;
    private JTextArea outputArea;

    private Party party;
    private DinnerParty dinnerParty;

    public PartyGUI() {
        super("Party Planner");

        party = new Party();
        dinnerParty = new DinnerParty();

        setLayout(new FlowLayout());

        // label color, font, size, name

        partyLabel = new JLabel("Number of guests for the party: ");
        partyLabel.setFont(new Font("Courier", Font.BOLD, 50));
        partyLabel.setForeground(new Color(147, 135, 214)); // Set text color
        add(partyLabel);
        add(partyLabel);

        partyTextField = new JTextField(10);
        add(partyTextField);
//  button color
        partyButton = new JButton("Set Party Guests");
        partyButton.setBackground(Color.WHITE); // Set button background color
        partyButton.setForeground(Color.PINK); // Set button text color
        add(partyButton);

        dinnerPartyLabel = new JLabel("Number of guests for the dinner party: ");
        dinnerPartyLabel.setForeground(new Color(147, 135, 214)); // Set text color
        add(dinnerPartyLabel);

        dinnerPartyTextField = new JTextField(10);
        add(dinnerPartyTextField);

        dinnerPartyButton = new JButton("Set Dinner Party Guests");
        dinnerPartyButton.setBackground(Color.WHITE); // Set button background color
        dinnerPartyButton.setForeground(Color.PINK); // Set button text color
        add(dinnerPartyButton);

        outputArea = new JTextArea(10, 30);
        add(new JScrollPane(outputArea));

        ButtonHandler handler = new ButtonHandler();


        partyButton.addActionListener(handler);
        dinnerPartyButton.addActionListener(handler);
    }
// create options for dinner party guest
    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == partyButton) {
                int numGuests = Integer.parseInt(partyTextField.getText());
                party.setGuests(numGuests);
                outputArea.append("The party has " + party.getGuests() + " guests\n");
                outputArea.append("Please come to my party!\n\n");
            } else if (event.getSource() == dinnerPartyButton) {
                int numGuests = Integer.parseInt(dinnerPartyTextField.getText());
                dinnerParty.setGuests(numGuests);
                int dinnerChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter the menu option: 1 for chicken or 2 for Vegetable"));
                dinnerParty.setDinnerChoice(dinnerChoice);
                outputArea.append("The dinner party has " + dinnerParty.getGuests() + " guests\n");
                outputArea.append("Menu option " + dinnerParty.getDinnerChoice() + " will be served\n");
                outputArea.append("Please come to my party!\n\n");
            }
        }
    }

    public static void main(String[] args) {
        PartyGUI partyGUI = new PartyGUI();
        partyGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        partyGUI.setSize(400, 300);
        partyGUI.setVisible(true);
    }
}
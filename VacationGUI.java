import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;



import static java.awt.Color.BLUE;

public class VacationGUI extends JFrame {
    private JComboBox<Calculate.Location> locationComboBox;
    private JComboBox<Calculate.Hotels> hotelComboBox;
    private JComboBox<Calculate.Meals> mealComboBox;
    private JList<Calculate.Activity> activityList;
    private JList<Calculate.Tours> tourList;
    private JSpinner daysSpinner;
    private JComboBox<Calculate.Flight> flightComboBox;
    private JLabel totalCostLabel;

    public VacationGUI() {
        getContentPane().setBackground(Color.PINK);
        setTitle("Vacation Cost Calculator");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 10, 10));

        JLabel vacationLabel = new JLabel("Plan Your Vacation!", SwingConstants.CENTER);
        vacationLabel.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set the font size and style
        vacationLabel.setForeground(Color.ORANGE); // Set the text color
        vacationLabel.setOpaque(true);
        vacationLabel.setBackground(BLUE); // Set background color
        vacationLabel.setPreferredSize(new Dimension(800, 50)); // Set the size of the label

        // Add the label to the frame
        add(vacationLabel, BorderLayout.NORTH);

        // Add the form panel to the frame
        add(formPanel, BorderLayout.CENTER);
        formPanel.setLayout(new GridLayout(0, 2, 10, 10));
        formPanel.setBackground(Color.PINK);

        locationComboBox = new JComboBox<>(Calculate.Location.values());
        hotelComboBox = new JComboBox<>();
        mealComboBox = new JComboBox<>(Calculate.Meals.values());
        activityList = new JList<>();
        tourList = new JList<>();
        daysSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100000000, 1));
        flightComboBox = new JComboBox<>(Calculate.Flight.values());


        Color boxBackgroundColor = Color.ORANGE;
        locationComboBox.setBackground(boxBackgroundColor);
        locationComboBox.setBackground(boxBackgroundColor);
        hotelComboBox.setBackground(boxBackgroundColor);
        mealComboBox.setBackground(boxBackgroundColor);
        activityList.setBackground(boxBackgroundColor);
        tourList.setBackground(boxBackgroundColor);
        daysSpinner.setBackground(boxBackgroundColor);
        flightComboBox.setBackground(boxBackgroundColor);


        Color boxForegroundColor = Color.BLUE; // Set the text color to blue
        locationComboBox.setForeground(boxForegroundColor);
        hotelComboBox.setForeground(boxForegroundColor);
        mealComboBox.setForeground(boxForegroundColor);
        activityList.setForeground(boxForegroundColor);
        tourList.setForeground(boxForegroundColor);
        daysSpinner.setForeground(boxForegroundColor);
        flightComboBox.setForeground(boxForegroundColor);

        JComponent editor = daysSpinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            ((JSpinner.DefaultEditor) editor).getTextField().setBackground(boxBackgroundColor);
            if (editor instanceof JSpinner.DefaultEditor) {
                ((JSpinner.DefaultEditor) editor).getTextField().setForeground(boxForegroundColor);
            }
            }


        JLabel locationLabel = new JLabel("Select Location:");
        locationLabel.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Set the font size and style
        formPanel.add(locationLabel);
        formPanel.add(locationComboBox);

        JLabel hotelLabel = new JLabel("Select Hotel:");
        hotelLabel.setForeground(BLUE); // Set the text color to white
        hotelLabel.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Set the font size and style
        formPanel.add(hotelLabel);
        formPanel.add(hotelComboBox);

        JLabel mealLabel = new JLabel("Select Style of Meals (If All-Inclusive is Chosen, the price of the hotel is included):");
        mealLabel.setForeground(BLUE); // Set the text color to white
        mealLabel.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Set the font size and style
        formPanel.add(mealLabel);
        formPanel.add(mealComboBox);

        JLabel activitiesLabel = new JLabel("Select Activities:");
        activitiesLabel.setForeground(BLUE); // Set the text color to white
        activitiesLabel.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Set the font size and style
        formPanel.add(activitiesLabel);        locationLabel.setForeground(BLUE); // Set the text color to white

        formPanel.add(new JScrollPane(activityList));

        JLabel toursLabel = new JLabel("Select Tours:");
        toursLabel.setForeground(BLUE); // Set the text color to white
        toursLabel.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Set the font size and style
        formPanel.add(toursLabel);
        formPanel.add(new JScrollPane(tourList));

        JLabel daysLabel = new JLabel("Number of Days:");
        daysLabel.setForeground(BLUE); // Set the text color to white
        daysLabel.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Set the font size and style
        formPanel.add(daysLabel);
        formPanel.add(daysSpinner);

        JLabel flightLabel = new JLabel("Flight Class:");
        flightLabel.setForeground(BLUE); // Set the text color to white
        flightLabel.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Set the font size and style
        formPanel.add(flightLabel);
        formPanel.add(flightComboBox);

        JPanel southPanel = new JPanel();
        JButton calculateButton = new JButton("Calculate Total Cost");
        totalCostLabel = new JLabel("Total Cost: $0");
        calculateButton.addActionListener(new CalculateButtonListener());
        southPanel.add(calculateButton);
        southPanel.add(totalCostLabel);

        add(formPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        locationComboBox.addActionListener(new LocationComboBoxListener());
    }

    private class LocationComboBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calculate.Location location = (Calculate.Location) locationComboBox.getSelectedItem();
            hotelComboBox.removeAllItems();
            for (Calculate.Hotels hotel : Calculate.hotelsMap.get(location)) {
                hotelComboBox.addItem(hotel);
            }

            activityList.setListData(getAvailableActivities(location));
            tourList.setListData(Calculate.Tours.values());
        }
    }

    private Calculate.Activity[] getAvailableActivities(Calculate.Location location) {
        Map<Calculate.Location, Calculate.Activity[]> activityMap = new HashMap<>();
        activityMap.put(Calculate.Location.Canada, new Calculate.Activity[]{Calculate.Activity.Skiing, Calculate.Activity.Beach, Calculate.Activity.Pool});
        activityMap.put(Calculate.Location.Italy, new Calculate.Activity[]{Calculate.Activity.Snorkeling, Calculate.Activity.Wine, Calculate.Activity.Beach, Calculate.Activity.Pool});
        activityMap.put(Calculate.Location.Greece, new Calculate.Activity[]{Calculate.Activity.Snorkeling, Calculate.Activity.Wine, Calculate.Activity.Beach, Calculate.Activity.Pool});
        activityMap.put(Calculate.Location.Egypt, new Calculate.Activity[]{Calculate.Activity.Amusement, Calculate.Activity.Beach, Calculate.Activity.Pool});
        activityMap.put(Calculate.Location.Kenya, new Calculate.Activity[]{Calculate.Activity.Beach, Calculate.Activity.Pool});
        activityMap.put(Calculate.Location.France, new Calculate.Activity[]{Calculate.Activity.Wine, Calculate.Activity.Beach, Calculate.Activity.Pool});

        Calculate.Activity[] activities = activityMap.get(location);
        return activities != null ? activities : new Calculate.Activity[0];
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calculate.Location location = (Calculate.Location) locationComboBox.getSelectedItem();
            Calculate.Hotels hotel = (Calculate.Hotels) hotelComboBox.getSelectedItem();
            Calculate.Meals meal = (Calculate.Meals) mealComboBox.getSelectedItem();
            Calculate.Flight flightClass = (Calculate.Flight) flightComboBox.getSelectedItem();
            int numDays = (int) daysSpinner.getValue();
            Calculate.Activity[] activities = activityList.getSelectedValuesList().toArray(new Calculate.Activity[0]);
            Calculate.Tours[] tours = tourList.getSelectedValuesList().toArray(new Calculate.Tours[0]);

            VacationExpenseReport vacationExpenseReport = new VacationExpenseReport();
            int flightCost = vacationExpenseReport.getFlightCost(location, flightClass);
            int hotelCost = vacationExpenseReport.getHotelCost(location, hotel, numDays, meal);
            int mealCost = vacationExpenseReport.getMealCost(location, meal, numDays);
            int transportationCost = vacationExpenseReport.getTransportationCost(location, numDays);
            int activitiesCost = vacationExpenseReport.getActivitiesCost(location, activities);
            int toursCost = vacationExpenseReport.getToursCost(location, tours);
            int totalCost = flightCost + hotelCost + mealCost + transportationCost + activitiesCost + toursCost;

            totalCostLabel.setText("Total Cost: $" + totalCost);

            // Prepare breakdown string
            StringBuilder breakdown = new StringBuilder();
            breakdown.append("Flight Cost: $").append(flightCost).append("\n");
            breakdown.append("Hotel Cost: $").append(hotelCost).append("\n");
            breakdown.append("Meal Cost: $").append(mealCost).append("\n");
            breakdown.append("Transportation Cost: $").append(transportationCost).append("\n");
            breakdown.append("Activities Cost: $").append(activitiesCost).append("\n");
            breakdown.append("Tours Cost: $").append(toursCost).append("\n");
            breakdown.append("Total Cost: $").append(totalCost);

            // Open breakdown window
            new Details(breakdown.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VacationGUI vacationGUI = new VacationGUI();
            vacationGUI.setVisible(true);
        });
    }
}

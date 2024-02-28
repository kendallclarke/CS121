// Declare a variable for the number of guests, a Party object, and a Scanner object to use for input

import java.util.Scanner;

public class UseDinnerParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Party aParty = new Party();

// Add a statement to display the party invitation
        System.out.print("Enter number of guests for the party >> ");
        int numGuests = scanner.nextInt();
        aParty.setGuests(numGuests);

        System.out.println("The party has " + aParty.getGuests() + " guests");
        aParty.displayInvitation();

        // prompt user for dinner party information
        DinnerParty aDinnerParty = new DinnerParty();

        System.out.print("Enter number of guests for the dinner party >> ");
        int dinnerGuests = scanner.nextInt();
        aDinnerParty.setGuests(dinnerGuests);

        // menu options
        System.out.print("Enter the menu option -- 1 for chicken or 2 for Vegetable >> ");
        int dinnerChoice = scanner.nextInt();
        aDinnerParty.setDinnerChoice(dinnerChoice);

        System.out.println("The dinner party has " + aDinnerParty.getGuests() + " guests");
        System.out.println("Menu option " + aDinnerParty.getDinnerChoice() + " will be served");
        aDinnerParty.displayInvitation();
    }
}
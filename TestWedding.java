import java.time.LocalDate;
import java.util.Scanner;


public class TestWedding {
    public static <Int> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



// Print statements for user to respond
        System.out.print("Enter bride's first name: ");
        String brideFirstName = scanner.nextLine();
        System.out.print("Enter bride's last name: ");
        String brideLastName = scanner.nextLine();

        System.out.print("Enter groom's first name: ");
        String groomFirstName = scanner.nextLine();
        System.out.print("Enter groom's last name: ");
        String groomLastName = scanner.nextLine();

        Person bride = new Person(brideFirstName, brideLastName);
        Person groom = new Person(groomFirstName, groomLastName);

        System.out.print("Enter wedding date (YYYY-MM-DD): ");
        String weddingDateStr = scanner.nextLine();
        LocalDate weddingDate = LocalDate.parse(weddingDateStr);

        System.out.print("Enter wedding location: ");
        String location = scanner.nextLine();

        System.out.print("Enter Number of Guests: ");
        Integer numberOfGuests = Integer.valueOf(Integer.valueOf(scanner.nextLine()));


        Couple couple = new Couple(bride, groom);
        Wedding wedding = new Wedding(couple, weddingDate, location, numberOfGuests);
// combine inputs for output
        System.out.println("\nWedding Details:");
        System.out.println("Bride: " + wedding.getCouple().getBride().getFirstName() + " " + wedding.getCouple().getBride().getLastName());
        System.out.println("Groom: " + wedding.getCouple().getGroom().getFirstName() + " " + wedding.getCouple().getGroom().getLastName());
        System.out.println("Date: " + wedding.getWeddingDate());
        System.out.println("Location: " + wedding.getLocation());
        System.out.println("Number of Guests: " + wedding.getNumberOfGuests());

        scanner.close();




    }
}

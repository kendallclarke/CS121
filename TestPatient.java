import java.util.Scanner;

public class TestPatient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Patient 1 with default values
        Patient patient1 = new Patient();
        System.out.println("Patient 1:");
        System.out.println("ID: " + patient1.getId());
        System.out.println("Age: " + patient1.getAge());
        System.out.println("Blood Type: " + patient1.getBloodData().getBloodType());
        System.out.println("Rh Factor: " + patient1.getBloodData().getRhFactor());

        // Patient 2 with user input
        System.out.print("Enter Patient 2's ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Patient 2's age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter Patient 2's blood type (O, A, B, AB): ");
        String bloodTypeString = sc.nextLine();
        System.out.print("Enter Patient 2's Rh factor (+ or -): ");
        String rhFactorString = sc.nextLine();

        BloodData.BloodType bloodType = BloodData.BloodType.valueOf(bloodTypeString.toUpperCase());
        BloodData.RhFactor rhFactor = rhFactorString.equals("+") ? BloodData.RhFactor.pos : BloodData.RhFactor.neg;

        Patient patient2 = new Patient(id, age, bloodType, rhFactor);
        System.out.println("\nPatient 2:");
        System.out.println("ID: " + patient2.getId());
        System.out.println("Age: " + patient2.getAge());
        System.out.println("Blood Type: " + patient2.getBloodData().getBloodType());
        System.out.println("Rh Factor: " + patient2.getBloodData().getRhFactor());

        // Patient 3 with user input for ID and age, default BloodData
        System.out.print("Enter Patient 3's ID: ");
        id = sc.nextInt();
        System.out.print("Enter Patient 3's age: ");
        age = sc.nextInt();

        Patient patient3 = new Patient(id, age, BloodData.BloodType.O, BloodData.RhFactor.pos);
        System.out.println("\nPatient 3:");
        System.out.println("ID: " + patient3.getId());
        System.out.println("Age: " + patient3.getAge());
        System.out.println("Blood Type: " + patient3.getBloodData().getBloodType());
        System.out.println("Rh Factor: " + patient3.getBloodData().getRhFactor());
    }
}

import java.util.Scanner;
public class MoneyConverter {
    public static void main(String[] args) {
        String ANSI_PURPLE = "\u001B[35m";
        Scanner sc = new Scanner(System.in);
        String total_string  = sc.nextLine().substring(1,5);
        Float total_double = Float.parseFloat(total_string) * 100;
        int total = Math.round(total_double);
        int quarter = total / 25;
        int total_2 = total % 25;
        int dime = total_2 / 10;
        int total_3 = total_2 % 10;
        int nickel = total_3 / 5;
        int total_4 = total_3 % 5;
        int pennies = total_4;
        System.out.println("Quarter: " + quarter);
        System.out.println("Dime: " + dime);
        System.out.println("Nickel: " + nickel);
        System.out.println("Pennies : " + pennies);
        if (quarter < 1) {
        System.out.println(ANSI_PURPLE +  "There are no quarters!"); }
        if (dime < 1) {
                System.out.println(ANSI_PURPLE + "There are no dimes!"); }
        if (nickel < 1) {
                System.out.println(ANSI_PURPLE +  "There are no nickels!");}
        if (pennies < 1) {
                System.out.println(ANSI_PURPLE + "There are no pennies!" );}

    }}
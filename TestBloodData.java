import java.util.Scanner;

public class TestBloodData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Blood Type: ");
        String user_blood = sc.nextLine();

        System.out.print("Enter an Rh Factor: ");
        String user_rh = sc.nextLine();
        BloodData data = new BloodData();

// convert user input to match Bloodtype.O

       BloodData.BloodType convert_blood = BloodData.BloodType.O;
        if (user_blood == "B"){
                convert_blood = BloodData.BloodType.B;}
        if (user_blood == "O"){
            convert_blood = BloodData.BloodType.O;}
        if (user_blood == "A"){
            convert_blood = BloodData.BloodType.A;}
        if (user_blood == "AB"){
            convert_blood = BloodData.BloodType.AB;}


        BloodData.RhFactor convert_factor = BloodData.RhFactor.pos;
        if (user_rh == "+"){
            convert_factor = BloodData.RhFactor.pos;}
        if (user_rh == "-"){
            convert_factor = BloodData.RhFactor.neg;}

        BloodData converted = new BloodData(convert_blood, convert_factor);
// print user input converted
        System.out.println(data.getBloodType());
        System.out.println(converted.getBloodType());

        converted.getRhFactor();
        System.out.println(data.getRhFactor());
        System.out.println(converted.getRhFactor());

    }
}

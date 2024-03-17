public class Car {private int Year;
    private Model model;
    private Color color;
    public Car(int yr, Model m, Color c ){
        Year = yr;
        model = m;
        color = c;

    }
    public void display()
    {
        System.out.println("Car is a " +  Year + " " + color + " " + model + " ");
    }
}

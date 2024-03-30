public class Patient {
    private int id;
    private int age;
    private BloodData bloodData;

    public Patient() {
        id = 0;
        age = 0;
        bloodData = new BloodData();
    }

    public Patient(int id, int age, BloodData.BloodType bloodType, BloodData.RhFactor rhFactor) {
        this.id = id;
        this.age = age;
        this.bloodData = new BloodData(bloodType, rhFactor);
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public BloodData getBloodData() {
        return bloodData;
    }
}


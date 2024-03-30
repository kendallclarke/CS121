// create enum classes
public class BloodData {
    enum BloodType {
        A, B, O, AB
    }

    enum RhFactor {
        pos, neg
    }

    private BloodType BloodType;
    private RhFactor RhFactor;

    public BloodData() {
        BloodType = BloodType.O;
        RhFactor = RhFactor.pos;
    }
// create set and get methods
    public BloodData(BloodType type, RhFactor factor) {
        BloodType = type;
        RhFactor = factor;
    }

    public void setBloodType(BloodData.BloodType bloodType) {
        BloodType = bloodType;
    }

    public BloodData.BloodType getBloodType() {
        return BloodType;
    }

    public void setRhFactor(BloodData.RhFactor rhFactor) {
        RhFactor = rhFactor;
    }

    public BloodData.RhFactor getRhFactor() {
        return RhFactor;
    }
}
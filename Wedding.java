import java.time.LocalDate;
// set data types
public class Wedding {
    private Couple couple;
    private LocalDate weddingDate;
    private String location;
    private int numberOfGuests;

    public Wedding(Couple couple, LocalDate weddingDate, String location, int numberOfGuests) {
        this.couple = couple;
        this.weddingDate = weddingDate;
        this.location = location;
        this.numberOfGuests = numberOfGuests;
    }
// create set and get methods
    public Couple getCouple() {
        return couple;
    }

    public LocalDate getWeddingDate() {
        return weddingDate;
    }

    public String getLocation() {
        return location;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }
}
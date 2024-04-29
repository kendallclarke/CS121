import java.util.HashMap;
import java.util.Map;
// locations
public class Calculate {
    enum Location {
        France, Egypt, Italy, Kenya, Greece, Canada
    }

    enum Flight {
        Economy, Business, First
    }
// activities
    enum Activity {
        Skiing("Go Skiing"),
        Snorkeling("Go Snorkeling"),
        Wine("Wine Tasting"),
        Beach("Go to the beach"),
        Pool("Go to the Pool"),
        Golfing("Go golfing"),
        Amusement("Camel Ride");

        private final String description;

        Activity(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }
// tour options
    enum Tours {
        Museums("Museum Tour"),
        FOOD("Food Tour");

        private final String description;

        Tours(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }
// hotel options
    enum Hotels {
        PullmanParisTourEiffel("Pullman Paris Tour Eiffel"),
        HotelPeyrisOpera("Hotel Peyris Opera"),
        HotelMistral("Hotel Mistral"),
        RixosSharmElSheich("Rixos Sharm El Sheich"),
        HiltonHarghada("Hilton Harghada Plaza"),
        MerkaiResort("Merkai Resort"),
        HotelNHTorinoCenter("Hotel NH Torino Center"),
        FattoriaPianetti("Fattoria Pianetti"),
        NHMilanoCorsoBuenosAires("NH Milano Corso Buenos Aires"),
        HomewoodSuitesbyHilton("Homewood Suites by Hilton"),
        MaraSerenaLodge("Mara Serena Safari Lodge"),
        SheratonBeachVillagio("Sheraton Beach Villagio hotel"),
        WyndhamGrandAthens("Wyndham Grand Athens"),
        GrandHyattAthens("Grand Hyatt Athens"),
        HerodionHotel("Herodion Hotel"),
        HolidayInTorontoDowntown("Holiday in Toronto Downtown"),
        KensingtonSuites("Kensington Suites"),
        TheRitzCarltonToronto("The Ritz Carlton Toronto");

        private final String description;

        Hotels(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    enum Meals {
        INCLUSIVE("All Inclusive Meals"),
        OUT("Dine out");

        private final String description;

        Meals(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    public static Map<Location, Hotels[]> hotelsMap;
    public static Map<Location, Meals[]> mealsMap;

    static {
        hotelsMap = new HashMap<>();
        hotelsMap.put(Location.France, new Hotels[]{Hotels.PullmanParisTourEiffel, Hotels.HotelPeyrisOpera, Hotels.HotelMistral});
        hotelsMap.put(Location.Egypt, new Hotels[]{Hotels.RixosSharmElSheich, Hotels.HiltonHarghada, Hotels.MerkaiResort});
        hotelsMap.put(Location.Italy, new Hotels[]{Hotels.HotelNHTorinoCenter, Hotels.FattoriaPianetti, Hotels.NHMilanoCorsoBuenosAires});
        hotelsMap.put(Location.Kenya, new Hotels[]{Hotels.HomewoodSuitesbyHilton, Hotels.MaraSerenaLodge, Hotels.SheratonBeachVillagio});
        hotelsMap.put(Location.Greece, new Hotels[]{Hotels.WyndhamGrandAthens, Hotels.GrandHyattAthens, Hotels.HerodionHotel});
        hotelsMap.put(Location.Canada, new Hotels[]{Hotels.HolidayInTorontoDowntown, Hotels.KensingtonSuites, Hotels.TheRitzCarltonToronto});

        mealsMap = new HashMap<>();
        mealsMap.put(Location.France, new Meals[]{Meals.INCLUSIVE, Meals.OUT});
        mealsMap.put(Location.Egypt, new Meals[]{Meals.INCLUSIVE, Meals.OUT});
        mealsMap.put(Location.Kenya, new Meals[]{Meals.INCLUSIVE, Meals.OUT});
        mealsMap.put(Location.Greece, new Meals[]{Meals.INCLUSIVE, Meals.OUT});
        mealsMap.put(Location.Canada, new Meals[]{Meals.INCLUSIVE, Meals.OUT});

    }
}
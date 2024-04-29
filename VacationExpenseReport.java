import java.util.HashMap;
import java.util.Map;

public class VacationExpenseReport {
    public static int getFlightCost(Calculate.Location location, Calculate.Flight flightClass) {
        Map<Calculate.Location, int[]> flightPrices = new HashMap<>();
        flightPrices.put(Calculate.Location.France, new int[]{868, 3935, 8936});
        flightPrices.put(Calculate.Location.Egypt, new int[]{2995, 13349, 44162});
        flightPrices.put(Calculate.Location.Italy, new int[]{940, 5518, 8515});
        flightPrices.put(Calculate.Location.Kenya, new int[]{1705, 7483, 18296});
        flightPrices.put(Calculate.Location.Greece, new int[]{1642, 6571, 31005});
        flightPrices.put(Calculate.Location.Canada, new int[]{760, 1350, 2103});

        int[] prices = flightPrices.get(location);
        return prices[flightClass.ordinal()];
    }

    public static int getHotelCost(Calculate.Location location, Calculate.Hotels hotel, int numDays, Calculate.Meals meal) {
        Map<Calculate.Location, Map<Calculate.Hotels, Integer>> hotelPrices = new HashMap<>();
        Map<Calculate.Hotels, Integer> francePrices = new HashMap<>();
        francePrices.put(Calculate.Hotels.PullmanParisTourEiffel, 452);
        francePrices.put(Calculate.Hotels.HotelPeyrisOpera, 180);
        francePrices.put(Calculate.Hotels.HotelMistral, 188);
        hotelPrices.put(Calculate.Location.France, francePrices);

        Map<Calculate.Hotels, Integer> egyptPrices = new HashMap<>();
        egyptPrices.put(Calculate.Hotels.RixosSharmElSheich, 203);
        egyptPrices.put(Calculate.Hotels.HiltonHarghada, 103);
        egyptPrices.put(Calculate.Hotels.MerkaiResort, 148);
        hotelPrices.put(Calculate.Location.Egypt, egyptPrices);

        Map<Calculate.Hotels, Integer> italyPrices = new HashMap<>();
        italyPrices.put(Calculate.Hotels.HotelNHTorinoCenter, 170);
        italyPrices.put(Calculate.Hotels.FattoriaPianetti, 107);
        italyPrices.put(Calculate.Hotels.NHMilanoCorsoBuenosAires, 500);
        hotelPrices.put(Calculate.Location.Italy, italyPrices);

        Map<Calculate.Hotels, Integer> kenyaPrices = new HashMap<>();
        kenyaPrices.put(Calculate.Hotels.HomewoodSuitesbyHilton, 209);
        kenyaPrices.put(Calculate.Hotels.MaraSerenaLodge, 259);
        kenyaPrices.put(Calculate.Hotels.SheratonBeachVillagio, 49);
        hotelPrices.put(Calculate.Location.Kenya, kenyaPrices);

        Map<Calculate.Hotels, Integer> greecePrices = new HashMap<>();
        greecePrices.put(Calculate.Hotels.WyndhamGrandAthens, 99);
        greecePrices.put(Calculate.Hotels.GrandHyattAthens, 143);
        greecePrices.put(Calculate.Hotels.HerodionHotel, 139);
        hotelPrices.put(Calculate.Location.Greece, greecePrices);

        Map<Calculate.Hotels, Integer> canadaPrices = new HashMap<>();
        canadaPrices.put(Calculate.Hotels.HolidayInTorontoDowntown, 244);
        canadaPrices.put(Calculate.Hotels.KensingtonSuites, 84);
        canadaPrices.put(Calculate.Hotels.TheRitzCarltonToronto, 481);
        hotelPrices.put(Calculate.Location.Canada, canadaPrices);

        int hotelPrice = hotelPrices.get(location).get(hotel);
        if (meal == Calculate.Meals.INCLUSIVE) {
            return 0;
        }
        return hotelPrice * numDays;
    }

    public static int getMealCost(Calculate.Location location, Calculate.Meals meal, int numDays) {
        Map<Calculate.Location, Integer> mealPrices = new HashMap<>();
        mealPrices.put(Calculate.Location.France, 1668);
        mealPrices.put(Calculate.Location.Egypt, 1105);
        mealPrices.put(Calculate.Location.Italy, 571);
        mealPrices.put(Calculate.Location.Kenya, 145);
        mealPrices.put(Calculate.Location.Greece, 1719);
        mealPrices.put(Calculate.Location.Canada, 892);

        if (meal == Calculate.Meals.INCLUSIVE) {
            return mealPrices.get(location) * numDays;
        } else {
            Map<Calculate.Location, Integer> dineOutPrices = new HashMap<>();
            dineOutPrices.put(Calculate.Location.France, 81);
            dineOutPrices.put(Calculate.Location.Egypt, 90);
            dineOutPrices.put(Calculate.Location.Italy, 90);
            dineOutPrices.put(Calculate.Location.Kenya, 45);
            dineOutPrices.put(Calculate.Location.Greece, 90);
            dineOutPrices.put(Calculate.Location.Canada, 60);
            return dineOutPrices.get(location) * numDays;
        }
    }

    public static int getTransportationCost(Calculate.Location location, int numDays) {
        Map<Calculate.Location, Integer> transportationPrices = new HashMap<>();
        transportationPrices.put(Calculate.Location.France, 50);
        transportationPrices.put(Calculate.Location.Egypt, 15);
        transportationPrices.put(Calculate.Location.Italy, 70);
        transportationPrices.put(Calculate.Location.Kenya, 20);
        transportationPrices.put(Calculate.Location.Greece, 40);
        transportationPrices.put(Calculate.Location.Canada, 30);

        return transportationPrices.get(location) * numDays;
    }

    public static int getActivitiesCost(Calculate.Location location, Calculate.Activity[] activities) {
        Map<Calculate.Location, Map<Calculate.Activity, Integer>> activityPrices = new HashMap<>();
        Map<Calculate.Activity, Integer> canadaPrices = new HashMap<>();
        canadaPrices.put(Calculate.Activity.Skiing, 98);
        canadaPrices.put(Calculate.Activity.Beach, 0);
        canadaPrices.put(Calculate.Activity.Pool, 0);
        activityPrices.put(Calculate.Location.Canada, canadaPrices);

        Map<Calculate.Activity, Integer> italyPrices = new HashMap<>();
        italyPrices.put(Calculate.Activity.Snorkeling, 1623);
        italyPrices.put(Calculate.Activity.Wine, 252);
        italyPrices.put(Calculate.Activity.Beach, 0);
        italyPrices.put(Calculate.Activity.Pool, 0);
        activityPrices.put(Calculate.Location.Italy, italyPrices);

        Map<Calculate.Activity, Integer> greecePrices = new HashMap<>();
        greecePrices.put(Calculate.Activity.Snorkeling, 270);
        greecePrices.put(Calculate.Activity.Wine, 54);
        greecePrices.put(Calculate.Activity.Beach, 0);
        greecePrices.put(Calculate.Activity.Pool, 0);
        activityPrices.put(Calculate.Location.Greece, greecePrices);

        Map<Calculate.Activity, Integer> egyptPrices = new HashMap<>();
        egyptPrices.put(Calculate.Activity.Amusement, 45);
        egyptPrices.put(Calculate.Activity.Beach, 0);
        egyptPrices.put(Calculate.Activity.Pool, 0);
        activityPrices.put(Calculate.Location.Egypt, egyptPrices);

        Map<Calculate.Activity, Integer> kenyaPrices = new HashMap<>();
        kenyaPrices.put(Calculate.Activity.Beach, 0);
        kenyaPrices.put(Calculate.Activity.Pool, 0);
        activityPrices.put(Calculate.Location.Kenya, kenyaPrices);

        Map<Calculate.Activity, Integer> francePrices = new HashMap<>();
        francePrices.put(Calculate.Activity.Wine, 114);
        francePrices.put(Calculate.Activity.Beach, 0);
        francePrices.put(Calculate.Activity.Pool, 0);
        activityPrices.put(Calculate.Location.France, francePrices);

        int totalCost = 0;
        Map<Calculate.Activity, Integer> locationPrices = activityPrices.get(location);
        for (Calculate.Activity activity : activities) {
            if (locationPrices.containsKey(activity)) {
                totalCost += locationPrices.get(activity);
            }
        }

        return totalCost;
    }


    public static int getToursCost(Calculate.Location location, Calculate.Tours[] tours) {
        int totalCost = 0;

        for (Calculate.Tours tour : tours) {
            switch (tour) {
                case Museums:
                    totalCost += getMuseumTourCost(location);
                    break;
                case FOOD:
                    totalCost += getFoodTourCost(location);
                    break;
            }
        }

        return totalCost;
    }

    private static int getMuseumTourCost(Calculate.Location location) {
        switch (location) {
            case France:
                return 13;
            case Egypt:
                return 11;
            case Italy:
                return 11;
            case Greece:
                return 15;
            case Canada:
                return 33;
            case Kenya:
                return 130;
            default:
                return 0; // Return 0 for other locations
        }
    }

    private static int getFoodTourCost(Calculate.Location location) {
        switch (location) {
            case France:
                return 75;
            case Egypt:
                return 52;
            case Italy:
                return 114;
            case Greece:
                return 78;
            case Canada:
                return 73;
            case Kenya:
                return 123;
            default:
                return 0; // Return 0 for other locations
        }
    }
}
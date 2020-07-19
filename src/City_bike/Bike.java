package CityBike;


import java.util.HashMap;

public class Bike {
    static private int staticID = 0;
    private int bikeID;
    private String bikeName;
    private String bikeColor;
    //Uses Class Enum to create Bike status;
    public enum BikeStatus {
        CanBeRented, CanNotBeRented, InService, Discarded
    }
    private BikeStatus bikeStatus;

    public static HashMap<Integer, Bike> bikeHash = new HashMap<>();

    public Bike(String bikeColor) {
        setBikeID(staticID + 1);
        staticID++;
        setBikeName("bike"+getBikeID());
        setBikeColor(bikeColor);
        setBikeStatus(BikeStatus.CanBeRented);
        bikeHash.put(this.getBikeID(), this);
    }

    public int getBikeID() {
        return bikeID;
    }

    public void setBikeID(int bikeID) {
        this.bikeID = bikeID;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public String getBikeColor() {
        return bikeColor;
    }

    public void setBikeColor(String bikeColor) {
        this.bikeColor = bikeColor;
    }

    public BikeStatus getBikeStatus() {
        return bikeStatus;
    }

    public void setBikeStatus(BikeStatus bikeStatus) {
        this.bikeStatus = bikeStatus;
    }

    public static void printAllBikes () {
        System.out.printf("%n%n%-16s %-16s %-16s %-16s %n","Bike ID", "Bike Name", "Bike Color", "Bike Status");
        bikeHash.forEach((key, value) -> System.out.printf("%-16s %-16s %-16s %-16s %n", key, value.getBikeName(), value.getBikeColor(), value.getBikeStatus()));
    }
}

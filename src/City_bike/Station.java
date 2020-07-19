package CityBike;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Station {
    static private int staticID = 0;
    private int stationID;
    private String stationLocation;
    private HashMap<Integer, Bike> bikeHashStation = new HashMap<>();
    public static HashMap<Integer, Station> stationHashMap = new HashMap<>();


    public Station(String stationLocation) {
        setStationID(staticID + 1);
        staticID++;
        setStationLocation(stationLocation);
        System.out.println("\nNew Station added\n");
        System.out.println(this.toString());
        stationHashMap.put(this.getStationID(), this);
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getStationLocation() {
        return stationLocation;
    }

    public void setStationLocation(String stationLocation) {
        this.stationLocation = stationLocation;
    }

    public HashMap<Integer, Bike> getBikeHashStation() {
        return bikeHashStation;
    }

    public void setBikeHashStation(HashMap<Integer, Bike> bikeHashStation) {
        this.bikeHashStation = bikeHashStation;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationID=" + stationID +
                ", stationLocation='" + stationLocation + '\'' +
                '}';
    }

    public void addBike(Bike newBike) {

        if(newBike.getBikeStatus() == Bike.BikeStatus.CanBeRented) {
            if (this.getBikeHashStation() == null) {
                HashMap<Integer, Bike> bikeHashStation = new HashMap<>();
                bikeHashStation.put(newBike.getBikeID(), newBike);
                this.setBikeHashStation(bikeHashStation);
            }
            if (this.getBikeHashStation().size() < 5) {
                this.getBikeHashStation().put(newBike.getBikeID(), newBike);
                System.out.println("\nNew Bike added to " + this.getStationLocation() + " station.");
                System.out.println("Size" + this.getBikeHashStation().size());
            } else {
                System.out.println("\nThe station, " + this.getStationLocation() + " is full and cannot have more than 5 bikes.");
            }
        } else {
            System.out.println("Bike cannot be rented.");
        }
    }

    public static void printAllStations() {
        System.out.println("List of Bikes and their stations: ");
        System.out.printf("%-16s %-16s %-16s %-16s %-16s %-16s %n", "Station ID", "Station Location", "Bike ID", "Bike Name", "Bike Color", "Bike Status");
        for (Map.Entry<Integer, Station> entry : stationHashMap.entrySet()) {
            if (entry.getValue().getBikeHashStation() == null) {
                System.out.printf("%-16d %-16s %-16s %-16s %-16s %-16s %n", entry.getKey(), entry.getValue().getStationLocation(), "None", "None", "None", "None");
            } else {
                Iterator iterateBike = entry.getValue().getBikeHashStation().entrySet().iterator();
                while (iterateBike.hasNext()) {
                    Map.Entry<Integer, Bike> pairBike = (Map.Entry) iterateBike.next();
                    System.out.printf("%-16d %-16s %-16d %-16s %-16s %-16s %n", entry.getKey(), entry.getValue().getStationLocation(), pairBike.getKey(), pairBike.getValue().getBikeName(), pairBike.getValue().getBikeColor(), pairBike.getValue().getBikeStatus());
                }
            }
        }
    }


}

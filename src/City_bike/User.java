package CityBike;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class User {
    static private int staticID = 0;
    private int userID;
    private String userName;
    private String userSurname;
    private boolean currentlyRentedBike;
    public static HashMap<Integer, User> userHashMap = new HashMap<>();

    public User(String userName, String userSurname) {
        setUserID(staticID + 1);
        staticID++;
        this.userName = userName;
        this.userSurname = userSurname;
        userHashMap.put(this.getUserID(), this);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public boolean isCurrentlyRentedBike() {
        return currentlyRentedBike;
    }

    public void setCurrentlyRentedBike(boolean currentlyRentedBike) {
        this.currentlyRentedBike = currentlyRentedBike;
    }

    public static void printAllUsers() {
        System.out.printf("%-16s %-16s %-16s %-32s %n", "UserID", "First Name", "Last Name", "Current Status");
        Iterator iterate = userHashMap.entrySet().iterator();
        while (iterate.hasNext()) {
            Map.Entry<Integer, User> pair = (Map.Entry) iterate.next();
            System.out.printf("%-16s %-16s %-16s %-32s %n", pair.getKey(), pair.getValue().getUserName(), pair.getValue().getUserSurname(),
                    ((pair.getValue().isCurrentlyRentedBike()) ? "Renting a bike" : "Not renting right now"));
        }
    }
}

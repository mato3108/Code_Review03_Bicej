package CityBike;

import java.util.*;

import static CityBike.Bike.bikeHash;
import static CityBike.Bike.printAllBikes;
import static CityBike.Rent.*;
import static CityBike.Station.printAllStations;
import static CityBike.Station.stationHashMap;
import static CityBike.User.printAllUsers;
import static CityBike.User.userHashMap;


public class Main {
    public static void main(String[] args) {


        Bike bike1 = new Bike("White");
        Bike bike2 = new Bike("Green");
        Bike bike3 = new Bike("Yellow");
        Bike bike4 = new Bike("Grey");
        Bike bike5 = new Bike("Blue");
        Bike bike6 = new Bike("Black");
        Bike bike7 = new Bike("Red");
        Bike bike8 = new Bike("Orange");
        Bike bike9 = new Bike("Purple");


        Station station1 = new Station("Schoenbrunn");
        Station station2 = new Station("Stephansdom");
        Station station3 = new Station("Schwedenplatz");


        station1.addBike(bike1);
        station1.addBike(bike2);
        station1.addBike(bike3);
        station2.addBike(bike4);
        station2.addBike(bike5);
        station2.addBike(bike6);
        station2.addBike(bike7);
        station3.addBike(bike8);
        station3.addBike(bike9);



        User user1 = new User("Matej", "Bicej");
        User user2 = new User("Mathias", "Bicaj");
        User user3 = new User("Martin", "Bicij");
        User user4 = new User("Matt", "Bicoj");



        Rent rent1 = new Rent(user1, station1, bike1, "01.01.2020");
        rent1.returnBike(1, station2, "20.01.2020");

        Rent rent2 = new Rent(user2, station2, bike4, "01.02.2020");
        rent2.returnBike(2, station2, "20.02.2020");

        Rent rent3 = new Rent(user3, station3, bike8, "01.03.2020");

        Rent rent4 = new Rent(user4, station2, bike6, "01.04.2020");
        rent4.returnBike(4, station3, "20.04.2020");

        Rent rent5 = new Rent(user1, station3, bike6, "01.05.2020");

        Rent rent6 = new Rent(user4, station3, bike9, "01.06.2020");
        rent6.returnBike(6, station2, "20.07.2020");



        Scanner inputNumber = new Scanner(System.in);
        Scanner inputText = new Scanner(System.in);


        boolean input1 = true;
        while (input1) {
            boolean input2 = true;
            System.out.print("\nPress 1 if you are the Administrator" +
                    "\nPress 2 if you are a User" +
                    "\nPress 3 to exit" +
                    "\nOption: ");

            if (inputNumber.hasNextInt()) {
                int inputOption1 = inputNumber.nextInt();
                if (inputOption1 == 1) {

                    while (input2) {
                        System.out.print("\n 1 for a new bike " +
                                "\n2 for adding a new bike to the station " +
                                "\n3 to add a new station" +
                                "\nn4 to display details about the the rent" +
                                "\n5 to exit" +
                                "\nOption: ");
                        if (inputNumber.hasNextInt()) {
                            int inputOption2 = inputNumber.nextInt();
                            switch (inputOption2) {

                                case 1:
                                    System.out.print("Color: ");
                                    String inputText11 = inputText.nextLine();
                                    Bike bike = new Bike(inputText11);
                                    System.out.println("New Bike Created");
                                    printAllBikes();
                                    break;

                                case 2:
                                    printAllStations();
                                    System.out.print("Color of the new bike: ");
                                    String inputText12 = inputText.nextLine();
                                    System.out.print("Station ID of the new bike: ");
                                    if (inputNumber.hasNextInt()) {
                                        int inputNumber12 = inputNumber.nextInt();
                                        if (stationHashMap.containsKey(inputNumber12)) {
                                            stationHashMap.get(inputNumber12).addBike(new Bike(inputText12));
                                        }
                                    } else {
                                        System.out.println("Wrong input!");
                                    }
                                    break;

                                case 3:
                                    System.out.print("Location of the new station: ");
                                    String inputText13 = inputText.nextLine();
                                    Station station = new Station(inputText13);
                                    break;

                                case 4:
                                    printAllRentals();
                                    break;

                                case 5:
                                    input2 = false;
                                    break;
                                default:
                                    System.out.println("Please choose one of the options");
                                    break;
                            }
                        } else {
                            System.out.println("Please choose an integer!");
                        }
                    }
                    input1 = false;
                } else if (inputOption1 == 2) {

                    while (input2) {
                        boolean input3 = true;
                        System.out.print("\nPress 00 to register as a new user" +
                                "\nPress 01 if you want to sign in" +
                                "\nOption: ");
                        if (inputNumber.hasNextInt()) {
                            int inputOption3 = inputNumber.nextInt();
                            int userId = 0;
                            switch (inputOption3) {

                                case 00:
                                    System.out.print("Enter your First Name: ");
                                    String inputText211 = inputText.nextLine();
                                    System.out.print("Enter your Last Name: ");
                                    String inputText212 = inputText.nextLine();
                                    User user = new User(inputText211, inputText212);
                                    System.out.println("User created and logged in.");
                                    userId = user.getUserID();
                                    break;

                                case 01:
                                    System.out.print("Enter your User ID: ");
                                    int inputNumber21 = inputNumber.nextInt();
                                    if (userHashMap.containsKey(inputNumber21)) {
                                        userId = inputNumber21;
                                    }
                                    break;
                                default:
                                    System.out.println("Press 00 or 01");
                                    break;
                            }

                            if (userId != 0) {
                                System.out.print("\nPress 02 to rent a bike" +
                                        "\nPress 03 to return a Bike" +
                                        "\nOption: ");
                                if (inputNumber.hasNextInt()) {
                                    int inputOption4 = inputNumber.nextInt();

                                    switch (inputOption4) {

                                        case 02:
                                            printAllStations();
                                            System.out.print("Enter the station ID ");
                                            int inputStationId = inputNumber.nextInt();

                                            if (stationHashMap.containsKey(inputStationId)) {
                                                if (stationHashMap.get(inputStationId).getBikeHashStation() == null) {
                                                    System.out.printf("%-16d %-16s %-16s %-16s %-16s %-16s %n", stationHashMap.get(inputStationId).getStationID(), stationHashMap.get(inputStationId).getStationLocation(), "None", "None", "None", "None");
                                                } else {
                                                    Iterator iterateBike = stationHashMap.get(inputStationId).getBikeHashStation().entrySet().iterator();
                                                    while (iterateBike.hasNext()) {
                                                        Map.Entry<Integer, Bike> pairBike = (Map.Entry) iterateBike.next();
                                                        System.out.printf("%-16d %-16s %-16d %-16s %-16s %-16s %n", stationHashMap.get(inputStationId).getStationID(), stationHashMap.get(inputStationId).getStationLocation(), pairBike.getKey(), pairBike.getValue().getBikeName(), pairBike.getValue().getBikeColor(), pairBike.getValue().getBikeStatus());

                                                    }
                                                }
                                                System.out.print("Enter the Bike ID you want to rent: ");
                                                int inputBikeId = inputNumber.nextInt();
                                                Iterator<Map.Entry<Integer, Bike>> itrBike = stationHashMap.get(inputStationId).getBikeHashStation().entrySet().iterator();
                                                while (itrBike.hasNext()) {
                                                    Map.Entry<Integer, Bike> entryBike = itrBike.next();
                                                    if (entryBike.getKey() == inputBikeId) {
                                                        System.out.print("Enter the start date of your rental only in the format of DD.MM.YYYY: ");
                                                        String rentNewStartDate = inputText.nextLine();
                                                        Rent rent = new Rent(userHashMap.get(userId), stationHashMap.get(inputStationId), entryBike.getValue(), rentNewStartDate, itrBike);
                                                        printAllStations();
                                                        System.out.println("Rental Started");
                                                        printAllRentals();
                                                    }
                                                }
                                            } else {
                                                System.out.println("Please select one of the available stations!");
                                            }
                                            break;
                                        //Returns Bike;
                                        case 03:
                                            Iterator iterateRent = rentHashMap.entrySet().iterator();
                                            String noReturn = "";
                                            while (iterateRent.hasNext()) {
                                                Map.Entry<Integer, Rent> pairRent = (Map.Entry) iterateRent.next();
                                                if ((pairRent.getValue().getUser().getUserID() == userId) &&
                                                        pairRent.getValue().getRentEndDate() == null) {
                                                    printRentalByUser(userHashMap.get(userId));
                                                    try {

                                                        System.out.print("Enter the Rent ID: ");
                                                        int inputNumber24Rent = inputNumber.nextInt();
                                                        System.out.print("Enter the Station ID you want to return the Bike to: ");
                                                        int inputNumber24Station = inputNumber.nextInt();
                                                        System.out.print("Enter the end date of your rental only in the format of DD.MM.YYYY: ");
                                                        String rentNewEndDate = inputText.nextLine();
                                                        rentHashMap.get(inputNumber24Rent).returnBike(inputNumber24Rent, stationHashMap.get(inputNumber24Station), rentNewEndDate);
                                                        printAllRentals();
                                                    } catch (Exception e) {
                                                        System.out.println("Please select the right values in the right format!");
                                                    }
                                                }
                                            }
                                            break;
                                        default:
                                            System.out.println("Press 02 or 03!");
                                            break;
                                    }
                                }
                            }
                        } else {
                            System.out.println("Please enter an integer!");
                            input2 = false;
                        }
                        input2 = false;
                    }
                    input1 = false;
                } else if (inputOption1 == 3) {
                    input1 = false;
                } else {
                    System.out.println("Please choose Option 1 or Option 2\n");
                }
            } else {
                System.out.println("Please choose an integer option!");
            }

            inputNumber.close();
            inputText.close();
        }
    }
}

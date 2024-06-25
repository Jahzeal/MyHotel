
package Project;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeePage {

    public static Statement st = null;

    public static Statement getStatement(){
        if(st !=null)
            return st;
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/Hotel",
                            "root", "Blesing533.");
            st = connection.createStatement();
            return st;
        }
        catch (Exception e){
            return null;
        }
    }


    // display guests
    public static String displayGuests() {
        List<String> guests = new ArrayList<>();
        try {
            String query = "SELECT name FROM guest";
            ResultSet resultSet = getStatement().executeQuery(query);

            while (resultSet.next()) {
                String guest = resultSet.getString("name");
                guests.add(guest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.join(", ", guests);
    }


    public static String[] displayGuestsID() {
        List<Integer> guestIDList = new ArrayList<>();

        try {
            String query = "SELECT GuestID FROM guest";
            ResultSet resultSet = getStatement().executeQuery(query);

            while (resultSet.next()) {
                int guestID = resultSet.getInt("GuestID");
                guestIDList.add(guestID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convert List<Integer> to int[]
        String[]  guestIDs = new String[guestIDList.size()];
        for (int i = 0; i < guestIDList.size(); i++) {
            guestIDs[i] = guestIDList.get(i).toString();
        }
        return guestIDs;
    }
    public static String[] displayTotalReserved() {
        List<Integer> totalReserveList = new ArrayList<>();

        try {
            String query = "SELECT TotalReserved FROM reservation";
            ResultSet resultSet = getStatement().executeQuery(query);

            while (resultSet.next()) {
                int totalReserved = resultSet.getInt("TotalReserved");
                totalReserveList.add(totalReserved);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

            // Convert List to int array
            String[] totalReservedArray = new String[totalReserveList.size()];
            for (int i = 0; i < totalReserveList.size(); i++) {
                totalReservedArray[i] = totalReserveList.get(i).toString();
            }

            return totalReservedArray;
        };

    public static String[] displayPaymentID(){
        List<Integer> paymentidlist = new ArrayList<>();
        try{
            String query = "SELECT * FROM Payment";
            ResultSet gottenResult = getStatement().executeQuery(query);
            while (gottenResult.next()){
                int paymentId = gottenResult.getInt("PaymentID"); //add to front guest id
                paymentidlist.add(paymentId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] paymentidarray = new String[paymentidlist.size()];
        for (int i = 0; i < paymentidlist.size(); i ++){
            paymentidarray[i] = paymentidlist.get(i).toString();
        }
        return paymentidarray;
    };

    public static String[] roomtype() {
        List<String> roomtypeslist = new ArrayList<>();
        try {
            String query = "SELECT RoomType FROM reservation";
            ResultSet resultSet = getStatement().executeQuery(query);
            while (resultSet.next()) {
                String roomtype = resultSet.getString("RoomType");
                roomtypeslist.add(roomtype);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convert ArrayList to String array
        String[] roomtypesarray = new String[roomtypeslist.size()];
        for (int i = 0; i < roomtypeslist.size(); i++) {
            roomtypesarray[i] = roomtypeslist.get(i);
        }
       System.out.println(roomtypesarray);  //work
        return roomtypesarray;
    }






    public static String[] displayPaymentAmounts() {
        List<Integer> paymentAmounts = new ArrayList<>();
        try {
            String query = "SELECT Amount FROM Payment";
            ResultSet gottenResult = getStatement().executeQuery(query);
            while (gottenResult.next()) {
                double amount = gottenResult.getDouble("Amount");
                paymentAmounts.add((int) amount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convert ArrayList to int array
        String [] amountsArray = new String[paymentAmounts.size()];
        for (int i = 0; i < paymentAmounts.size(); i++) {
            amountsArray[i] = paymentAmounts.get(i).toString();
        }

        // Return the string representation of the array
        return amountsArray;
    }





    public static String[] displayEmail() {
        try{
            String query = "SELECT * FROM guest";
            ResultSet resultSet = getStatement().executeQuery(query);
            String [] Emails = new String[5];
            int i = 0;
            while (resultSet.next()) {
                String email = resultSet.getString("Email");
                Emails[i] = email;
                i++;
            }
            return Emails;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    };



    //call manu
    public static String displayPhonenumber() {
        try {
            String query = "SELECT ContactNumber FROM guest";
            ResultSet resultSet = getStatement().executeQuery(query);

            StringBuilder phoneNumberBuilder = new StringBuilder();

            while (resultSet.next()) {
                String number = resultSet.getString("ContactNumber");
                phoneNumberBuilder.append(number).append(", ");
            }

            // Remove the last comma and space if there are any phone numbers
            if (phoneNumberBuilder.length() > 0) {
                phoneNumberBuilder.delete(phoneNumberBuilder.length() - 2, phoneNumberBuilder.length());
            }

            return phoneNumberBuilder.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    // display reservations
//    public static Date[] displayReservations() {
//        try {
//            String query = "SELECT * FROM reservation ";
//            ResultSet resultSet = getStatement().executeQuery(query);
//            java.util.Date[] startdates = new java.util.Date[5];
//            int  i = 0;
//            while (resultSet.next()) {
//                java.util.Date startDate = resultSet.getDate("StartDate");
//                startdates[i] = startDate;
//                i++;
//
////                String paymentStatus = resultSet.getString("PaymentStatus");
////                Date paymentDate = resultSet.getDate("PaymentDAte");
////                int totalReserved = resultSet.getInt("");
////                System.out.println("Payment Status: " + paymentStatus);
////                System.out.println("Payment Date: " + paymentDate);
////                System.out.println("Total Rooms Booked: " + totalReserved);
////                System.out.println();
//            }
//            return (Date[]) startdates;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    };







    public static String displayPaymentDates() {
        try {
            String query = "SELECT PaymentDate FROM reservation";
            ResultSet resultSet = getStatement().executeQuery(query);

            List<String> paymentDates = new ArrayList<>();

            while (resultSet.next()) {
                Date paymentDate = resultSet.getDate("PaymentDate");
                paymentDates.add(paymentDate.toString());
            }
            return String.join(", ", paymentDates);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }








    public static String displayStartDates() {
        try {
            String query = "SELECT * FROM reservation";
            ResultSet resultSet = getStatement().executeQuery(query);

            StringBuilder startDateBuilder = new StringBuilder();

            while (resultSet.next()) {
                java.sql.Date startDate = resultSet.getDate("StartDate");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = dateFormat.format(startDate);
                startDateBuilder.append(formattedDate).append(", ");
            }

            // Remove the last comma and space if there are any dates
            if (startDateBuilder.length() > 0) {
                startDateBuilder.delete(startDateBuilder.length() - 2, startDateBuilder.length());
            }

            return startDateBuilder.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int getroomQuantity() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.");
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM reservation";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int roomQuantity = resultSet.getInt("RoomQuantity");
                return roomQuantity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static int displayReservationsID() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.");
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM reservation";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int reservationID = resultSet.getInt("ReservationID");
                return reservationID;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    };





    public static String getEndDate() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.");
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM reservation";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                Date endDate = resultSet.getDate("EndDate");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return dateFormat.format(endDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    // display rooms
    public static int displayRooms() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.");
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM ROOM";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int availableRooms = resultSet.getInt("AvailableRooms");
                return availableRooms;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    };

    public static int displayRate() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.");
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM ROOM";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int Rate = resultSet.getInt("Rate");
                return Rate;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    };





    public static int displayPaymentTotalroom() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.");
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM Payment";
            ResultSet gottenResult = statement.executeQuery(query);
            while (gottenResult.next()) {
                int TotalRooms = (int) gottenResult.getDouble("Total");  //next

                return TotalRooms;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    };


    public static Date displayPaymentdate() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.");
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM Payment";
            ResultSet gottenResult = statement.executeQuery(query);
            while (gottenResult.next()) {
                Date PaymentDate = gottenResult.getDate("PaymentDate");
                return PaymentDate;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    };










public static boolean login(Scanner scanner) {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.");
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM EmployeesLoginPWD WHERE UserID = ? AND Password = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Login successful.");
                return true;
            } else {
                System.out.println("Invalid username or password.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    };


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (login(scanner)) {
            System.out.println("Welcome to the Jayzee Hotel.");
            roomtype();
        } else {
            System.out.println("Login failed. Exiting...");
        }
        scanner.close();
    }
};
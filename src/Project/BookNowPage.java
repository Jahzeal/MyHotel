package Project;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class BookNowPage {


    static LocalDate ReservationStartDate;
    static LocalDate Enddate;
    static int guestID;
    static int failedCounter = 0;
    static String name;
    static String requestedRoomType;
    static LocalDate today = LocalDate.now();
    static Scanner scanner = new Scanner(System.in);  // Ensure single instance of Scanner
    static String PaymentStatus = "Paid";
    static long totalDays;
    static double sum = 0;



    public void savingInput(String name, String contactNumber, String email, LocalDate StartDate, LocalDate EnDDate, String roomType, LocalDate expiryDateInput, String cvv,int getroomLabel ){
        System.out.println(StartDate);
        System.out.println(EnDDate);
        guestID = generateID();
        confirmCardDetails( LocalDate.from(expiryDateInput),cvv );
        try {
            System.out.println(guestID+" first");
            ReservationStartDate = StartDate;
            Enddate = EnDDate;

            if (!guestIDExists(guestID)) {
                if (validateGuestDetails(name, contactNumber, email)) {
                    if (insertGuest(guestID, name, contactNumber, email)) {
                        checkAvailableRoom(roomType,StartDate,EnDDate,getroomLabel);
                        if (Reservation() && checkAvailableRoom(roomType,StartDate,EnDDate,getroomLabel)){
                            CalculatePayment();
                            if (insertpayment()){
                                System.out.println("Guest inserted successfully.");
                                System.out.println("Reservation details inserted successfully and reservation paid!!");
                                JOptionPane.showMessageDialog(
                                        new BookNowFront(),
                                        "Reservation Booked.!",
                                        "Success",
                                        JOptionPane.INFORMATION_MESSAGE
                                );

                            }
                        } else {
                            System.out.println("Reservation not available.");
                            JOptionPane.showMessageDialog(
                                    new BookNowFront(),
                                    "Reservation not available.!",
                                    "Failed",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        }
                    }
                }
            } else {
                System.out.println("Guest ID already exists.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }


    private static int generateID() {
        return ThreadLocalRandom.current().nextInt(9000000, 9009020);
    }

    private static String getDetails(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    private static LocalDate getReservationDate(Scanner scanner, String prompt) {
        System.out.println(prompt);
        while (true) {
            try {
                String input = scanner.nextLine();
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
            }
        }
    };

    private static boolean validateGuestDetails(String name, String contactNumber, String email) {
        if (name == null || name.isEmpty()) {
            System.out.println("Name is required.");
            return false;
        }
        if (contactNumber == null || contactNumber.isEmpty()) {
            System.out.println("Valid contact number is required.");
            return false;
        }
        if (email == null || email.isEmpty() || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            System.out.println("Valid email is required.");
            return false;
        }
        return true;
    };

    private static boolean Reservation() {
        if (ReservationStartDate.isBefore(today) || ReservationStartDate.isEqual(today)) {
            return false;
        }
        totalDays = ChronoUnit.DAYS.between(ReservationStartDate, Enddate) + 1;
        return true; // Return true if the dates are valid
    }


    private static boolean confirmCardDetails(LocalDate expiryDateInput, String cvv ) {

        LocalDate expiryDate;
        try {
            expiryDate =  expiryDateInput;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid expiry date format. Please use YYYY-MM.");
            return false;
        }

        if (expiryDate.isBefore(LocalDate.now())) {
            System.out.println("The card is expired.");
            return false;
        }

        if (cvv.length() != 3 || !cvv.matches("\\d+")) {
            System.out.println("Invalid CVV. It should be 3 digits.");
            return false;
        }

        return true;
    }

    private static boolean insertpayment() {
        String insert = "INSERT INTO payment(GuestID, Amount, PaymentDate, Total) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.");
             PreparedStatement insertPass = connection.prepareStatement(insert)) {
            insertPass.setInt(1, guestID);
            insertPass.setDouble(2, sum);
            System.out.println(sum);
            insertPass.setDate(3, java.sql.Date.valueOf(today));
            insertPass.setDouble(4, totalDays);
            insertPass.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    };

    private static boolean guestIDExists(int guestID) throws SQLException {
        String checkSQL = "SELECT COUNT(*) FROM guest WHERE GuestID = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.");
             PreparedStatement checkStmt = connection.prepareStatement(checkSQL)) {
            checkStmt.setInt(1, guestID);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
                return false;
            }
        }
    };




    private static void CalculatePayment() throws SQLException {
        String getReservation = "SELECT RoomType FROM RESERVATION WHERE GuestID = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.");
             PreparedStatement getReservationStmt = connection.prepareStatement(getReservation)) {

            getReservationStmt.setInt(1, guestID);
            ResultSet reservationResultSet = getReservationStmt.executeQuery();

            if (reservationResultSet.next()) {
                String roomType = reservationResultSet.getString("RoomType");
                String getRateQuery = "SELECT Rate FROM ROOM WHERE RoomType = ?";

                try (PreparedStatement getRateStmt = connection.prepareStatement(getRateQuery)) {
                    getRateStmt.setString(1, roomType);
                    ResultSet rateResultSet = getRateStmt.executeQuery();

                    if (rateResultSet.next()) {
                        double rate = rateResultSet.getDouble("Rate");
                        sum = totalDays * rate;
                        System.out.println("Total payment for " + totalDays + " days for room type " + roomType + " is: " + sum);
                    } else {
                        System.out.println("Rate not found for room type " + roomType);
                    }
                }
            } else {
                System.out.println("No reservation found for GuestID: " + guestID);
            }
        }
    }



    private static boolean checkAvailableRoom(String roomType, LocalDate StartDate, LocalDate EnDDate, int getroomLabel) {

        requestedRoomType = roomType;
        System.out.println(roomType);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.")) {
            String checkRoomType = "SELECT AvailableRooms FROM ROOM WHERE RoomType = ?";
            try (PreparedStatement checkAvailableRoomsStmt = connection.prepareStatement(checkRoomType)) {
                checkAvailableRoomsStmt.setString(1, requestedRoomType);
                try (ResultSet roomTypeResultSet = checkAvailableRoomsStmt.executeQuery()) {
                    if (roomTypeResultSet.next()) {
                        int availableRooms = roomTypeResultSet.getInt("AvailableRooms");
                        if (availableRooms > 0) {
                            System.out.println("The requested room type " + requestedRoomType + " is available.");
                            System.out.println("How many rooms would you like to book?");
                            int roomSize = getroomLabel;

                            if (roomSize <= availableRooms) {
                                String updateRoomsQuery = "UPDATE ROOM SET AvailableRooms = AvailableRooms - ? WHERE RoomType = ?";
                                try (PreparedStatement updateStmt = connection.prepareStatement(updateRoomsQuery)) {
                                    updateStmt.setInt(1, roomSize);
                                    updateStmt.setString(2, requestedRoomType);
                                    int rowsUpdated = updateStmt.executeUpdate();
                                    if (rowsUpdated > 0) {
                                        System.out.println("Successfully booked " + roomSize + " room(s).");

                                        String addReservationQuery = "INSERT INTO RESERVATION (GuestID, StartDate, EndDate, RoomType, RoomQuantity, PaymentStatus,PaymentDate, TotalReserved) VALUES (?, ?, ?, ?, ?, ?,?, ?)";
                                        System.out.println(guestID+"reserve");
                                        try (PreparedStatement addReservationStmt = connection.prepareStatement(addReservationQuery)) {
                                            addReservationStmt.setInt(1, guestID);
                                            addReservationStmt.setDate(2, java.sql.Date.valueOf(StartDate));
                                            addReservationStmt.setDate(3, java.sql.Date.valueOf(EnDDate));
                                            addReservationStmt.setString(4, requestedRoomType);
                                            addReservationStmt.setInt(5, roomSize);
                                            addReservationStmt.setString(6, PaymentStatus);
                                            addReservationStmt.setDate(7, java.sql.Date.valueOf(today));
                                            addReservationStmt.setInt(8, (int) totalDays);

                                            int reservationAdded = addReservationStmt.executeUpdate();
                                            if (reservationAdded > 0) {
                                                System.out.println("Reservation successfully added.");
                                                return true;
                                            } else {
                                                System.out.println("Reservation failed to add.");
                                            }
                                        }
                                    } else {
                                        System.out.println("Room booking failed.");
                                    }
                                }
                            } else {
                                System.out.println("The number of rooms requested exceeds the available rooms.");
                            }
                        } else {
                            System.out.println("No available rooms for the requested room type.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        failedcount();
        System.out.println("name");
        return false;
        // Return false if reservation fails
    }

    private static void failedcount() {
        failedCounter += 1;
        try {
            insertfailed(failedCounter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean insertfailed(int Failed) throws SQLException {
        String insertfailed = "INSERT INTO Failed (Failed) VALUES (?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.");
             PreparedStatement insertfaileddata = connection.prepareStatement(insertfailed)) {
            insertfaileddata.setInt(1, Failed);
            insertfaileddata.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean insertGuest(int guestID, String name, String contactNumber, String email) {
        String insertSQL = "INSERT INTO guest (GuestID, Name, ContactNumber, Email) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "Blesing533.");
             PreparedStatement insertStmt = connection.prepareStatement(insertSQL)) {
            insertStmt.setInt(1, guestID);
            insertStmt.setString(2, name);
            insertStmt.setString(3, contactNumber);
            insertStmt.setString(4, email);
            System.out.println(guestID);
            insertStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

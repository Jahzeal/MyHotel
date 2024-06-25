//package Project;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static Project.EmployeePage.getStatement;
//
//// This class represents the main guest and handles the retrieval of guest details
//public class Mainguest {
//    private String name;
//    private String startDate;
//    private String endDate;
//    private String roomType;
//    private String paymentStatus;
//    private String paymentDate;


//    private int guestID;
//    private int totalReserved;
//    private int reservationID;
//    private String paymentType;
//    private double amount;
//
//    public Mainguest(String name, String startDate, String endDate, String roomType, String paymentStatus, String paymentDate, int guestID, int totalReserved, int reservationID, String paymentType, double amount) {
//        this.name = name;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.roomType = roomType;
//        this.paymentStatus = paymentStatus;
//        this.paymentDate = paymentDate;
//        this.guestID = guestID;
//        this.totalReserved = totalReserved;
//        this.reservationID = reservationID;
//        this.paymentType = paymentType;
//        this.amount = amount;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getStartDate() {
//        return startDate;
//    }
//
//    public String getEndDate() {
//        return endDate;
//    }
//
//    public String getRoomType() {
//        return roomType;
//    }
//
//    public String getPaymentStatus() {
//        return paymentStatus;
//    }
//
//    public String getPaymentDate() {
//        return paymentDate;
//    }
//
//    public int getGuestID() {
//        return guestID;
//    }
//
//    public int getTotalReserved() {
//        return totalReserved;
//    }
//
//    public int getReservationID() {
//        return reservationID;
//    }
//
//    public String getPaymentType() {
//        return paymentType;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public static Mainguest[] mainGuestDetails() {
//        List<Mainguest> mainguests = new ArrayList<>();
//
//        try {
//            String query = "SELECT g.name,g.GuestID e.StartDate, e.EndDate, e.RoomType, e.PaymentStatus, e.PaymentDate FROM guest g JOIN reservation e ON g.GuestID = e.GuestID";
//            ResultSet resultSet = getStatement().executeQuery(query);
//
//            SELECT g.name, e.TotalReserved, e.ReservationID, e.PaymentType,
//                    d.amount, e.StartDate, e.EndDate, e.RoomType, e.PaymentStatus, e.PaymentDate, e.GuestID
//            FROM guest g
//            INNER JOIN reservation e ON g.GuestID = e.GuestID
//            INNER JOIN Payment d ON e.ReservationID = d.ReservationID;
//
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String startDate = resultSet.getDate("StartDate").toString();
//                String endDate = resultSet.getDate("EndDate").toString();
//                String roomType = resultSet.getString("RoomType");
//                String paymentStatus = resultSet.getString("PaymentStatus");
//                String paymentDate = resultSet.getDate("PaymentDate").toString();
//                int guestID = resultSet.getInt("GuestID");
//                int totalReserved = resultSet.getInt("TotalReserved");
//                int reservationID = resultSet.getInt("ReservationID");
//                String paymentType = resultSet.getString("PaymentType");
//                double amount = resultSet.getDouble("Amount");
//
//                Mainguest mainguest = new Mainguest(name, startDate, endDate, roomType, paymentStatus, paymentDate, guestID, totalReserved, reservationID, paymentType, amount);
//                mainguests.add(mainguest);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return mainguests.toArray(new Mainguest[0]);
//    }
//
//    public static void main(String[] args) {
//        Mainguest[] guestDetails = mainGuestDetails();
//        for (Mainguest mainguest : guestDetails) {
//            System.out.println("Name: " + mainguest.getName());
//            System.out.println("Start Date: " + mainguest.getStartDate());
//            System.out.println("End Date: " + mainguest.getEndDate());
//            System.out.println("Room Type: " + mainguest.getRoomType());
//            System.out.println("Payment Status: " + mainguest.getPaymentStatus());
//            System.out.println("Payment Date: " + mainguest.getPaymentDate());
//            System.out.println("Guest ID: " + mainguest.getGuestID());
//            System.out.println("Total Reserved: " + mainguest.getTotalReserved());
//            System.out.println("Reservation ID: " + mainguest.getReservationID());
//            System.out.println("Payment Type: " + mainguest.getPaymentType());
//            System.out.println("Amount: " + mainguest.getAmount());
//        }
//    }
//}

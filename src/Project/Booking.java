//package Project;
//
////
////this is displaying the mini guest
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static Project.EmployeePage.getStatement;
//
//public class Booking {
//    private String name;
//    private String startDate;
//    private String endDate;
//    private String roomType;
//    private String paymentStatus;
//    private String paymentDate;
//
//    public Booking(String name, String startDate, String endDate, String roomType, String paymentStatus, String paymentDate) {
//        this.name = name;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.roomType = roomType;
//        this.paymentStatus = paymentStatus;
//        this.paymentDate = paymentDate;
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
//    public static Booking[] GuestDetails() {
//        List<Booking> bookings = new ArrayList<>();
//
//        try {
//            String query = "SELECT g.name, e.StartDate, e.EndDate, e.RoomType, e.PaymentStatus, e.PaymentDate " +
//                    "FROM guest g JOIN reservation e ON g.GuestID = e.GuestID";
//            ResultSet resultSet = getStatement().executeQuery(query);
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String startDate = resultSet.getDate("StartDate").toString();
//                String endDate = resultSet.getDate("EndDate").toString();
//                String roomType = resultSet.getString("RoomType");
//                String paymentStatus = resultSet.getString("PaymentStatus");
//                String paymentDate = resultSet.getDate("PaymentDate").toString();
//
//                Booking booking = new Booking(name, startDate, endDate, roomType, paymentStatus, paymentDate);
//                bookings.add(booking);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        Booking[] bookingArray = new Booking[bookings.size()];
//        return bookings.toArray(bookingArray);
//    }
//
//    public static void main(String[] args) {
//        Booking[] guestDetails = GuestDetails();
//        for (Booking booking : guestDetails) {
//            System.out.println("Name: " + booking.getName());
//            System.out.println("Start Date: " + booking.getStartDate());
//            System.out.println("End Date: " + booking.getEndDate());
//            System.out.println("Room Type: " + booking.getRoomType());
//            System.out.println("Payment Status: " + booking.getPaymentStatus());
//            System.out.println("Payment Date: " + booking.getPaymentDate());
//        }
//    }
//}
//

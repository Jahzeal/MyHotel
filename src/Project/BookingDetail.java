package Project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BookingDetail {
        JPanel bookingRow1;
        JLabel bookingDateLabel1;
        JLabel customerLabel1;
        JLabel roomtypelabel1;
        JLabel phoneLabel1;
        JLabel personLabel1;
        JLabel checkINLabel1;
        JLabel checkOutLabel1;
        JLabel amountLabel;
        JLabel totalreservedLabel;
        JLabel guestIDlabel;
        JPanel paymentPanel1;
        BookingDetail(String bookingDetails, String customer,String RoomType, String person, String phone, String entryDate, String checkoutDate, String Amount, String totalReserved, String  ID){

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  CREATING A PANEL WITH 7 COLUMNS FOR THE BOOKING DETAIL >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            bookingRow1 = new JPanel();
            bookingRow1.setPreferredSize(new Dimension(1080, 40));
            bookingRow1.setBorder(new EmptyBorder(5,20,5,20));
            bookingRow1.setBackground(Color.white);
            bookingRow1.setLayout(new GridLayout(1,7));

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< BOOKING DATE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

            bookingDateLabel1 = new JLabel(bookingDetails);
            bookingDateLabel1.setFont(new Font("Sans-serif", Font.PLAIN, 10));
            bookingRow1.add(bookingDateLabel1);


            //-------------------------------------------------------------guestid

            guestIDlabel = new  JLabel(ID);
            guestIDlabel.setFont(new Font("Sans-serif", Font.PLAIN, 10));
            bookingRow1.add(guestIDlabel);



//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< CUSTOMER ROOM MATE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

            personLabel1 = new JLabel(person);
            personLabel1.setFont(new Font("Sans-serif", Font.PLAIN, 10));
            bookingRow1.add(personLabel1);




//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< CUSTOMER NAME >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

            customerLabel1 = new JLabel(customer);
            customerLabel1.setFont(new Font("Sans-serif", Font.PLAIN, 10));
            bookingRow1.add(customerLabel1);






            //---------roomtype

            roomtypelabel1 = new JLabel(RoomType);
            roomtypelabel1.setFont(new Font("Sans-serif", Font.PLAIN, 10));
            bookingRow1.add(roomtypelabel1);


//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< CUSTOMER PHONE NUMBER >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

            phoneLabel1 = new JLabel(phone);
            phoneLabel1.setFont(new Font("Sans-serif", Font.PLAIN, 10));
            bookingRow1.add(phoneLabel1);

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< CUSTOMER ENTRY DATE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

            checkINLabel1 = new JLabel(entryDate);
            checkINLabel1.setFont(new Font("Sans-serif", Font.PLAIN, 10));
            bookingRow1.add(checkINLabel1);

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< CUSTOMER LEAVING DATE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

            checkOutLabel1 = new JLabel(checkoutDate);
            checkOutLabel1.setFont(new Font("Sans-serif", Font.PLAIN, 10));
            bookingRow1.add(checkOutLabel1);

////------------------------------amount
            amountLabel = new JLabel(Amount);
            amountLabel.setFont(new Font("Sans-serif", Font.PLAIN, 10));
            bookingRow1.add(amountLabel);

            //------reserve
            totalreservedLabel = new JLabel(totalReserved);
            totalreservedLabel.setFont(new Font("Sans-serif", Font.PLAIN, 10));
            bookingRow1.add(totalreservedLabel);


//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GREEN PAYMENT PANEL >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

            paymentPanel1 = new JPanel();
            paymentPanel1.setPreferredSize(new Dimension(37, 15));
            paymentPanel1.setBackground(Color.green);
            bookingRow1.add(paymentPanel1);

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< CUSTOMER SUCCEEDED PAYMENT LABEL >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

            JLabel paymentLabel2 = new JLabel("Succeed");
            paymentLabel2.setForeground(Color.white);
            paymentLabel2.setFont(new Font("Sans-serif", Font.PLAIN, 9));
            paymentPanel1.add(paymentLabel2);




        }


}

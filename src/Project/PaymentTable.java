package Project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PaymentTable {

    JPanel paymentRow;
    JLabel bookingDateLabel1;
    JPanel paymentPanel1;
    JLabel roomtypelabel1;

    PaymentTable(String paymentId, String customer, String random) {

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  CREATING A PANEL WITH 7 COLUMNS FOR THE BOOKING DETAIL >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        paymentRow = new JPanel();
        paymentRow.setPreferredSize(new Dimension(1080, 40));
        paymentRow.setBorder(new EmptyBorder(5, 20, 5, 20));
        paymentRow.setBackground(Color.white);
        paymentRow.setLayout(new GridLayout(1, 7));

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< PaymentId >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        bookingDateLabel1 = new JLabel(paymentId);
        bookingDateLabel1.setFont(new Font("Sans-serif", Font.PLAIN, 15));
        paymentRow.add(bookingDateLabel1);

        bookingDateLabel1 = new JLabel(customer);
        bookingDateLabel1.setFont(new Font("Sans-serif", Font.PLAIN, 15));
        paymentRow.add(bookingDateLabel1);

        bookingDateLabel1 = new JLabel(random);
        bookingDateLabel1.setFont(new Font("Sans-serif", Font.PLAIN, 15));
        paymentRow.add(bookingDateLabel1);

        paymentPanel1 = new JPanel();
        paymentPanel1.setPreferredSize(new Dimension(15, 15));
        paymentPanel1.setBackground(Color.green);
        paymentRow.add(paymentPanel1);

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< CUSTOMER SUCCEEDED PAYMENT LABEL >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        JLabel paymentLabel2 = new JLabel("Succeed");
        paymentLabel2.setForeground(Color.white);
        paymentLabel2.setFont(new Font("Sans-serif", Font.PLAIN, 15));
        paymentPanel1.add(paymentLabel2);


        //-------------------------------------------------------------guestid


    }
}
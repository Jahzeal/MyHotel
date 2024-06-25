package Project;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class BookNowFront extends JFrame {

    BookNowFront(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CREATING NAV PANEL <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel nav = new JPanel();
        nav.setLayout(new GridBagLayout());
        nav.setPreferredSize(new Dimension(screenSize.width, 130));
        nav.setBorder(new EmptyBorder(0,30,0,0));
        nav.setBorder(new MatteBorder(0,0,1,0, Color.BLACK));


//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NAV CONTENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        Image scaledImage = getImage("/images/smyth-logo.svg.png", 154, 64);
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setVerticalAlignment(JLabel.CENTER);
//        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 20;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nav.add(imageLabel, gbc);

        // Subcribe content
        Image emailImage = getImage("/images/email (1).png", 30, 30);
        JLabel emailLabel = new JLabel(new ImageIcon(emailImage));
        emailLabel.setPreferredSize(new Dimension(35, 85));

        JLabel subscribeLabel = new JLabel("SUBSCRIBE");
        subscribeLabel.setFont(new Font("Sans-serif", Font.BOLD, 17));
        subscribeLabel.setForeground(Color.black);

        // Subscribe panel
        JPanel subscribePanel = new JPanel();
        subscribePanel.setPreferredSize(new Dimension(120, 70));
        subscribePanel.add(emailLabel, BorderLayout.EAST);
        subscribePanel.add(subscribeLabel, BorderLayout.CENTER);
        subscribePanel.setBorder(new MatteBorder(0,0,1,0, Color.BLACK));

//        subscribePanel.setBackground(Color.decode(bgColor));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nav.add(subscribePanel, gbc);

        // Book now button
        JButton bookButton = new JButton("×");
        bookButton.setOpaque(false);
        bookButton.setFocusable(false);
        bookButton.setContentAreaFilled(false);
        bookButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        bookButton.setFont(new Font("Sans-serif", Font.ITALIC, 80));
        bookButton.setForeground(Color.black);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
        bookButton.setPreferredSize(new Dimension(150, 50));
        nav.add(bookButton, gbc);


//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Creating body content  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridBagLayout()); // Example content, adjust as needed

        JScrollPane scrollPane = new JScrollPane(bodyPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(new LineBorder(Color.white, 0));
//        bodyPanel.setBackground(Color.decode(bgColor));

        JPanel lodgingPanel = new JPanel();
        gbc.gridy=0;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.NONE;
        bodyPanel.add(lodgingPanel, gbc);

        JPanel lodgingPanelDate = new JPanel();
        lodgingPanelDate.setBorder(new LineBorder(Color.black));
        lodgingPanelDate.setPreferredSize(new Dimension(800, 150));
        lodgingPanelDate.setLayout(new GridBagLayout());
        lodgingPanel.add(lodgingPanelDate);

//        ENTRY DATE
        JPanel entryDatePanel = new JPanel();
        entryDatePanel.setPreferredSize(new Dimension(300, 50));
        Border border15 = new LineBorder(Color.black, 1);
        Border border16  = new EmptyBorder(0,15,0,10);
        CompoundBorder compoundBorder7 = new CompoundBorder(border15, border16);
        entryDatePanel.setBorder(compoundBorder7);
        entryDatePanel.setLayout(new BorderLayout());
        gbc.gridy= 0;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,10);
        gbc.fill = GridBagConstraints.NONE;
        lodgingPanelDate.add(entryDatePanel, gbc);

        JLabel entryDateLabel  = new JLabel("Entry Date");
        entryDateLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        entryDateLabel.setForeground(new Color(0, 0, 0));
        entryDatePanel.add(entryDateLabel, BorderLayout.CENTER);


        JTextField entryDateTextField = new JTextField("2024-09-12");
        entryDateTextField.setPreferredSize(new Dimension(200, 50));
        entryDateTextField.setBorder(new MatteBorder(0,2,0,0, Color.black));
        entryDateTextField.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        entryDateTextField.setForeground(new Color(0, 0, 0));
        entryDateTextField.setOpaque(false);
        entryDatePanel.add(entryDateTextField, BorderLayout.EAST);

//        ENTRY DATE
        JPanel outDatePanel = new JPanel();
        outDatePanel.setPreferredSize(new Dimension(300, 50));
        Border border18 = new LineBorder(Color.black, 1);
        Border border19  = new EmptyBorder(0,15,0,10);
        CompoundBorder compoundBorder8 = new CompoundBorder(border18, border19);
        outDatePanel.setBorder(compoundBorder8);
        outDatePanel.setLayout(new BorderLayout());
        gbc.gridy= 0;
        gbc.gridx=1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.NONE;
        lodgingPanelDate.add(outDatePanel, gbc);

        JLabel outDateLabel  = new JLabel("out Date");
        outDateLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        outDateLabel.setForeground(new Color(0, 0, 0));
        outDatePanel.add(outDateLabel, BorderLayout.CENTER);


        JTextField outDateTextField = new JTextField("2024-09-12");
        outDateTextField.setPreferredSize(new Dimension(200, 50));
        outDateTextField.setBorder(new MatteBorder(0,2,0,0, Color.black));
        outDateTextField.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        outDateTextField.setForeground(new Color(0, 0, 0));
        outDateTextField.setOpaque(false);
        outDatePanel.add(outDateTextField, BorderLayout.EAST);

        JButton availabilityButton = new JButton("Check Availability");
        availabilityButton.setOpaque(false);
        availabilityButton.setFocusable(false);
        availabilityButton.setContentAreaFilled(false);
        availabilityButton.setBorder(new LineBorder(Color.BLACK, 1));
        availabilityButton.setPreferredSize(new Dimension(400, 40));
        availabilityButton.setFont(new Font("Sans-serif", Font.PLAIN, 15));
        availabilityButton.setForeground(Color.black);
        gbc.gridy= 1;
        gbc.gridx=0;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.NONE;
        lodgingPanelDate.add(availabilityButton, gbc);

        gbc.gridwidth = 1;


//        Customer details
        JPanel lodgingInputPanel = new JPanel();
        lodgingInputPanel.setPreferredSize(new Dimension(screenSize.width, 850));
        gbc.gridy=1;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.NONE;
//        lodgingInputPanel.setBackground(Color.red);
        bodyPanel.add(lodgingInputPanel, gbc);

        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(new LineBorder(Color.black, 1));
        inputPanel.setPreferredSize(new Dimension(700, 800));
        inputPanel.setLayout(new GridBagLayout());
        lodgingInputPanel.add(inputPanel);

        JPanel imagePanel = new JPanel();
        imagePanel.setPreferredSize(new Dimension(500, 800));
        imagePanel.setBorder(new LineBorder(Color.black, 1));
        lodgingInputPanel.add(imagePanel);

        JPanel namePanel = new JPanel();
        namePanel.setPreferredSize(new Dimension(300, 50));
        Border border = new LineBorder(Color.black, 1);
        Border border1  = new EmptyBorder(0,15,0,0);
        CompoundBorder compoundBorder = new CompoundBorder(border, border1);
        namePanel.setBorder(compoundBorder);
        namePanel.setLayout(new BorderLayout());
        gbc.gridy=0;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,10);
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(namePanel, gbc);

//        Name Label
        JLabel nameLabel = new JLabel("NAME");
        nameLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        nameLabel.setForeground(new Color(0, 0, 0));
        namePanel.add(nameLabel, BorderLayout.CENTER);

        JTextField nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(200, 50));
        nameTextField.setBorder(new MatteBorder(0,2,0,0, Color.black));
        nameTextField.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        nameTextField.setForeground(new Color(0, 0, 0));
        nameTextField.setOpaque(false);
        namePanel.add(nameTextField, BorderLayout.EAST);

        JPanel contactPanel = new JPanel();
        contactPanel.setPreferredSize(new Dimension(300, 50));
        contactPanel.setBorder(new LineBorder(Color.black, 1));
        Border border2 = new LineBorder(Color.black, 1);
        Border border3  = new EmptyBorder(0,15,0,0);
        CompoundBorder compoundBorder1 = new CompoundBorder(border2, border3);
        contactPanel.setBorder(compoundBorder1);
        contactPanel.setLayout(new BorderLayout());
        gbc.gridy=0;
        gbc.gridx=1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(contactPanel, gbc);


//        Contact Label
        JLabel contactLabel = new JLabel("CONTACT");
        contactLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        contactLabel.setForeground(new Color(0, 0, 0));
        contactPanel.add(contactLabel, BorderLayout.CENTER);

        JTextField contactTextField = new JTextField();
        contactTextField.setPreferredSize(new Dimension(200, 50));
        contactTextField.setBorder(new MatteBorder(0,2,0,0, Color.black));
        contactTextField.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        contactTextField.setForeground(new Color(0, 0, 0));
        contactTextField.setOpaque(false);
        contactPanel.add(contactTextField, BorderLayout.EAST);

        JPanel emailPanel = new JPanel();
        emailPanel.setPreferredSize(new Dimension(610, 50));
        emailPanel.setBorder(new LineBorder(Color.black, 1));
        emailPanel.setBorder(new LineBorder(Color.black, 1));
        Border border4 = new LineBorder(Color.black, 1);
        Border border5  = new EmptyBorder(0,15,0,0);
        CompoundBorder compoundBorder2 = new CompoundBorder(border4, border5);
        emailPanel.setBorder(compoundBorder2);
        emailPanel.setLayout(new BorderLayout());
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(emailPanel, gbc);

        //        Email Label
        JLabel emailLabel1 = new JLabel("Email");
        emailLabel1.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        emailLabel1.setForeground(new Color(0, 0, 0));
        emailPanel.add(emailLabel1, BorderLayout.CENTER);

        JTextField emailTextField = new JTextField();
        emailTextField.setPreferredSize(new Dimension(510, 50));
        emailTextField.setBorder(new MatteBorder(0,2,0,0, Color.black));
        emailTextField.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        emailTextField.setForeground(new Color(0, 0, 0));
        emailTextField.setOpaque(false);
        emailPanel.add(emailTextField, BorderLayout.EAST);


        gbc.gridwidth = 1;


        JPanel optionPanel = new JPanel();
        optionPanel.setPreferredSize(new Dimension(610, 50));
        optionPanel.setBorder(new LineBorder(Color.black, 1));
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(optionPanel, gbc);

        String roomList[] = {"Single Room","Double Room", "King Room", "Queen Room", "Suite"};
        JComboBox <String> roomOption = new JComboBox<>(roomList);
        roomOption.setOpaque(false);
//        roomOption.setBorder(new LineBorder(Color.GRAY, 1));
        roomOption.setPreferredSize(new Dimension(600, 40));
        optionPanel.add(roomOption);

        JPanel roomPanel = new JPanel();
        roomPanel.setPreferredSize(new Dimension(300, 50));
        Border border03 = new LineBorder(Color.black, 1);
        Border border04  = new EmptyBorder(0,15,0,10);
        CompoundBorder compoundBorder001 = new CompoundBorder(border03, border04);
        roomPanel.setBorder(compoundBorder001);
        roomPanel.setLayout(new BorderLayout());
        gbc.gridy=4;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.gridwidth  = 1;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(roomPanel, gbc);

        JLabel roomNo = new JLabel("Rooms");
        roomNo.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        roomNo.setForeground(new Color(196, 194, 194));
        roomPanel.add(roomNo, BorderLayout.CENTER);


        JTextField roomLabel = new JTextField();
        roomLabel.setPreferredSize(new Dimension(200, 50));
        roomLabel.setBorder(new MatteBorder(0,2,0,0, Color.gray));
        roomLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        roomLabel.setForeground(new Color(121, 119, 119));
        roomLabel.setOpaque(false);
        roomPanel.add(roomLabel, BorderLayout.EAST);

        JPanel cardDetailsPanel = new JPanel();
        cardDetailsPanel.setPreferredSize(new Dimension(610, 400));
        cardDetailsPanel.setBorder(new LineBorder(Color.black, 1));
        cardDetailsPanel.setLayout(new GridBagLayout());
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.NONE;
        inputPanel.add(cardDetailsPanel, gbc);

//        CARD HEADER
        JPanel cardHeader = new JPanel();
        cardHeader.setPreferredSize(new Dimension(600, 100));
        cardHeader.setBorder(new MatteBorder(0,0,1,0, Color.black));
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.fill = GridBagConstraints.NONE;
        cardDetailsPanel.add(cardHeader, gbc);

        gbc.gridwidth = 1;


        JPanel cardNamePanel = new JPanel();
        cardNamePanel.setPreferredSize(new Dimension(300, 50));
        Border border7 = new LineBorder(Color.black, 1);
        Border border8  = new EmptyBorder(0,15,0,0);
        CompoundBorder compoundBorder3 = new CompoundBorder(border7, border8);
        cardNamePanel.setBorder(compoundBorder3);
        cardNamePanel.setLayout(new BorderLayout());
        gbc.gridy=1;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,10);
        gbc.fill = GridBagConstraints.NONE;
        cardDetailsPanel.add(cardNamePanel, gbc);

        //        Name Label
        JLabel cardNameLabel = new JLabel("NAME");
        cardNameLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        cardNameLabel.setForeground(new Color(0, 0, 0));
        cardNamePanel.add(cardNameLabel, BorderLayout.CENTER);

        JTextField cardNameTextField = new JTextField();
        cardNameTextField.setPreferredSize(new Dimension(200, 50));
        cardNameTextField.setBorder(new MatteBorder(0,2,0,0, Color.black));
        cardNameTextField.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        cardNameTextField.setForeground(new Color(0, 0, 0));
        cardNameTextField.setOpaque(false);
        cardNamePanel.add(cardNameTextField, BorderLayout.EAST);


        JPanel cardExpiryPanel = new JPanel();
        cardExpiryPanel.setPreferredSize(new Dimension(300, 50));
        Border border9 = new LineBorder(Color.black, 1);
        Border border10  = new EmptyBorder(0,15,0,10);
        CompoundBorder compoundBorder4 = new CompoundBorder(border9, border10);
        cardExpiryPanel.setBorder(compoundBorder4);
        cardExpiryPanel.setLayout(new BorderLayout());
        gbc.gridy=2;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.NONE;
        cardDetailsPanel.add(cardExpiryPanel, gbc);

        JLabel cardExpiryLabel = new JLabel("EXPIRES");
        cardExpiryLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        cardExpiryLabel.setForeground(new Color(0, 0, 0));
        cardExpiryPanel.add(cardExpiryLabel, BorderLayout.CENTER);


        JTextField cardExpiryTextField = new JTextField();
        cardExpiryTextField.setPreferredSize(new Dimension(200, 50));
        cardExpiryTextField.setBorder(new MatteBorder(0,2,0,0, Color.black));
        cardExpiryTextField.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        cardExpiryTextField.setForeground(new Color(0, 0, 0));
        cardExpiryTextField.setOpaque(false);
        cardExpiryPanel.add(cardExpiryTextField, BorderLayout.EAST);


        JPanel cardCvvPanel = new JPanel();
        cardCvvPanel.setPreferredSize(new Dimension(300, 50));
        Border border11 = new LineBorder(Color.black, 1);
        Border border12  = new EmptyBorder(0,15,0,10);
        CompoundBorder compoundBorder5 = new CompoundBorder(border11, border12);
        cardCvvPanel.setBorder(compoundBorder5);
        cardCvvPanel.setLayout(new BorderLayout());
        gbc.gridy=3;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.NONE;
        cardDetailsPanel.add(cardCvvPanel, gbc);

        JLabel cardCvvLabel = new JLabel("CVV");
        cardCvvLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        cardCvvLabel.setForeground(new Color(0, 0, 0));
        cardCvvPanel.add(cardCvvLabel, BorderLayout.CENTER);


        JTextField cardCvvTextField = new JTextField();
        cardCvvTextField.setPreferredSize(new Dimension(200, 50));
        cardCvvTextField.setBorder(new MatteBorder(0,2,0,0, Color.black));
        cardCvvTextField.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        cardCvvTextField.setForeground(new Color(0, 0, 0));
        cardCvvTextField.setOpaque(false);
        cardCvvPanel.add(cardCvvTextField, BorderLayout.EAST);


//        JPanel cardNoPanel = new JPanel();
//        cardNoPanel.setPreferredSize(new Dimension(300, 50));
//        Border border0 = new LineBorder(Color.black, 1);
//        Border border01  = new EmptyBorder(0,15,0,10);
//        CompoundBorder compoundBorder0 = new CompoundBorder(border0, border01);
//        cardNoPanel.setBorder(compoundBorder0);
//        cardNoPanel.setLayout(new BorderLayout());
//        gbc.gridy=4;
//        gbc.gridx=0;
//        gbc.weightx = 0;
//        gbc.weighty = 0;
//        gbc.insets = new Insets(0,0,10,0);
//        gbc.fill = GridBagConstraints.NONE;
//        cardDetailsPanel.add(cardNoPanel, gbc);
//
//        JLabel cardNumber = new JLabel("Card No");
//        cardNumber.setFont(new Font("Sans-serif", Font.PLAIN, 14));
//        cardNumber.setForeground(new Color(196, 194, 194));
//        cardNoPanel.add(cardNumber, BorderLayout.CENTER);
//
//
//        JTextField cardNoTextField = new JTextField();
//        cardNoTextField.setPreferredSize(new Dimension(200, 50));
//        cardNoTextField.setBorder(new MatteBorder(0,2,0,0, Color.gray));
//        cardNoTextField.setFont(new Font("Sans-serif", Font.PLAIN, 20));
//        cardNoTextField.setForeground(new Color(121, 119, 119));
//        cardNoTextField.setOpaque(false);
//        cardNoPanel.add(cardNoTextField, BorderLayout.EAST);

//subnmit button
        JButton submitButton = new JButton("Book a room");
        submitButton.setOpaque(false);
        submitButton.setFocusable(false);
        submitButton.setContentAreaFilled(false);
        submitButton.setBorder(new LineBorder(Color.BLACK, 1));
        submitButton.setPreferredSize(new Dimension(600, 70));
        submitButton.setFont(new Font("Sans-serif", Font.PLAIN, 23));
        submitButton.setForeground(Color.black);
        gbc.gridy=2;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,300,0);
        gbc.fill = GridBagConstraints.NONE;
        bodyPanel.add(submitButton,gbc);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                String getName = nameTextField.getText();
                String getContact = contactTextField.getText();
                String getEmail = emailTextField.getText();
                LocalDate getStartDate = LocalDate.parse(entryDateTextField.getText());
                LocalDate getEndDate = LocalDate.parse(outDateTextField.getText());
                String getRoom = (String) roomOption.getSelectedItem();
                String getcardNameTextField = cardNameTextField.getText();
                LocalDate getcardExpiryTextField = LocalDate.parse(cardExpiryTextField.getText());
                String getCvv = cardCvvTextField.getText();
                int getroomLabel = Integer.parseInt(roomLabel.getText());
                BookNowPage bookNowPage = new BookNowPage();

                bookNowPage.savingInput(getName,getContact,getEmail,getStartDate,getEndDate,getRoom,getcardExpiryTextField,getCvv,getroomLabel);


            }
        });

//                to check availability
        availabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getStartDate = entryDateTextField.getText();
                String getEndDate = outDateTextField.getText();
                System.out.println(getStartDate + getEndDate);//work
            }
        });






//







        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(nav, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setSize(screenSize);
        this.setVisible(true);

    }



    public Image getImage(String imgPath, int scaledWidth, int scaledHeight) {
        // Loading image logo
        String projectRoot = System.getProperty("user.dir");
        String imagePath = projectRoot + imgPath;
        // Loading Image
        ImageIcon loadImage = new ImageIcon(imagePath);
        Image originalImage = loadImage.getImage();
        Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        return scaledImage;
    }


    public static void main(String[] args) {
        BookNowFront bookNowFront = new BookNowFront();
    }
}

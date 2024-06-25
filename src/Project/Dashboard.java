package Project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static Project.EmployeePage.*;
import static Project.EmployeePage.displayPaymentAmounts;

public class Dashboard extends JFrame {
    String bgColor = "#093a54";
    JPanel dashboardPanel;

    public Dashboard() throws SQLException {
        Image dashboardImage = getImage("/images/dashboard.png", 15, 15);
        Image roomImage = getImage("/images/hotel-room.png", 15, 15);
        Image suiteImage = getImage("/images/suite.png", 15, 15);
        Image guestImage = getImage("/images/people.png", 15, 15);
        Image paymentImage = getImage("/images/credit-card.png", 15, 15);
        Image settingImage = getImage("/images/settings-4.png", 15, 15);
        Image roomImageIcon = getImage("/images/hotel-room.png", 30, 30);
        Image image1 = getImage("/images/Penthouse-Living-Room-e1692384499125.png", 190,110);
        Image bg1 = getImage("/images/bg2.jpg", 190, 110);
        Image bg2 = getImage("/images/bg1.jpg",190,110);


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;



        this.setLayout(new BorderLayout());
        this.setSize(screenSize);
//        this.getContentPane().setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

//        SIDEBAR CONTENT
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setBackground(Color.decode(bgColor));
        sidebarPanel.setPreferredSize(new Dimension(200, screenSize.height));
        sidebarPanel.setLayout(new GridBagLayout());
        this.add(sidebarPanel, BorderLayout.WEST);

//        SIDEBAR LABEL, PANEL AND ICON
        JPanel dashboardPanels = new JPanel();
        dashboardPanels.setLayout(new BorderLayout());
        dashboardPanels.setPreferredSize(new Dimension(250, 40));
        JLabel dashboardLabel = new JLabel("<html>Dashboard &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp › </html>");
        dashboardLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        dashboardLabel.setForeground(Color.white);
        JLabel dashboardImageLabel = new JLabel(new ImageIcon(dashboardImage));
        dashboardImageLabel.setBorder(new EmptyBorder(0,15,0,8));
        dashboardPanels.setBackground(Color.decode(bgColor));
        dashboardPanels.add(dashboardImageLabel, BorderLayout.WEST);
        dashboardPanels.add(dashboardLabel, BorderLayout.CENTER);

        JPanel roomPanels = new JPanel();
        roomPanels.setLayout(new BorderLayout());
        roomPanels.setPreferredSize(new Dimension(250, 40));
        JLabel roomLabel = new JLabel("<html> Rooms  &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  › </html>");
        roomLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        roomLabel.setForeground(Color.white);
        JLabel roomImageLabel = new JLabel(new ImageIcon(roomImage));
        roomImageLabel.setBorder(new EmptyBorder(0,15,0,8));
        roomPanels.setBackground(Color.decode(bgColor));
        roomPanels.add(roomImageLabel, BorderLayout.WEST);
        roomPanels.add(roomLabel, BorderLayout.CENTER);

        JPanel suitePanels = new JPanel();
        suitePanels.setLayout(new BorderLayout());
        suitePanels.setPreferredSize(new Dimension(250, 40));
        JLabel suiteLabel = new JLabel("<html> Suite &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp › </html>");
        suiteLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        suiteLabel.setForeground(Color.white);
        JLabel suiteImageLabel = new JLabel(new ImageIcon(suiteImage));
        suiteImageLabel.setBorder(new EmptyBorder(0,15,0,8));
        suitePanels.setBackground(Color.decode(bgColor));
        suitePanels.add(suiteImageLabel, BorderLayout.WEST);
        suitePanels.add(suiteLabel, BorderLayout.CENTER);



        JPanel paymentPanels = new JPanel();
        paymentPanels.setLayout(new BorderLayout());
        paymentPanels.setPreferredSize(new Dimension(250, 40));
        JLabel paymentLabel = new JLabel("<html>Payment &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  › </html>");
        paymentLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        paymentLabel.setForeground(Color.white);
        JLabel paymentImageLabel = new JLabel(new ImageIcon(paymentImage));
        paymentImageLabel.setBorder(new EmptyBorder(0,15,0,8));
        paymentPanels.setBackground(Color.decode(bgColor));
        paymentPanels.add(paymentImageLabel, BorderLayout.WEST);
        paymentPanels.add(paymentLabel, BorderLayout.CENTER);

        JPanel guestPanels = new JPanel();
        guestPanels.setLayout(new BorderLayout());
        guestPanels.setPreferredSize(new Dimension(250, 40));
        JLabel guestLabel = new JLabel("<html>Guests &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp › </html>");
        guestLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        guestLabel.setForeground(Color.white);
        JLabel guestImageLabel = new JLabel(new ImageIcon(guestImage));
        guestImageLabel.setBorder(new EmptyBorder(0,15,0,8));
        guestPanels.setBackground(Color.decode(bgColor));
        guestPanels.add(guestImageLabel, BorderLayout.WEST);
        guestPanels.add(guestLabel, BorderLayout.CENTER);

        JPanel settingsPanels = new JPanel();
        settingsPanels.setLayout(new BorderLayout());
        settingsPanels.setPreferredSize(new Dimension(250, 40));
        JLabel settingsLabel = new JLabel("<html>Settings &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp › </html>");
        settingsLabel.setFont(new Font("Sans-serif", Font.PLAIN, 14));
        settingsLabel.setForeground(Color.white);
        JLabel settingsImageLabel = new JLabel(new ImageIcon(settingImage));
        settingsImageLabel.setBorder(new EmptyBorder(0,15,0,8));
        settingsPanels.setBackground(Color.decode(bgColor));
        settingsPanels.add(settingsImageLabel, BorderLayout.WEST);
        settingsPanels.add(settingsLabel, BorderLayout.CENTER);




//          SIDEBAR BUTTON
        JButton dashboardButton = new JButton();
        dashboardButton.setLayout(new BorderLayout());
        dashboardButton.setPreferredSize(new Dimension(250, 40));
        dashboardButton.setOpaque(false);
        dashboardButton.setFocusable(false);
        dashboardButton.setContentAreaFilled(false);
        dashboardButton.setBorder(new MatteBorder(0,0,1,0, new Color(248, 241, 241)));

        dashboardButton.add(dashboardPanels);

        gbc.gridy=0;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(-340,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;//        gbc.insets = new Insets(-160,0,0,0);
        sidebarPanel.add(dashboardButton, gbc);

        JButton roomButton = new JButton();
        roomButton.setLayout(new BorderLayout());
        roomButton.setPreferredSize(new Dimension(250, 40));
        roomButton.setOpaque(false);
        roomButton.setFocusable(false);
        roomButton.setContentAreaFilled(false);
        roomButton.setBorder(new MatteBorder(0,0,1,0, new Color(248, 241, 241)));;

        roomButton.add(roomPanels);
        gbc.gridy=1;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(-290,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        sidebarPanel.add(roomButton, gbc);

        JButton suiteButton = new JButton();
        suiteButton.setLayout(new BorderLayout());
        suiteButton.setPreferredSize(new Dimension(250, 40));
        suiteButton.setOpaque(false);
        suiteButton.setFocusable(false);
        suiteButton.setContentAreaFilled(false);
        suiteButton.setBorder(new MatteBorder(0,0,1,0, new Color(248, 241, 241)));;

        suiteButton.add(suitePanels);
        gbc.gridy=2;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(-240,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        sidebarPanel.add(suiteButton, gbc);

        JButton paymentButton = new JButton();
        paymentButton.setLayout(new BorderLayout());
        paymentButton.setPreferredSize(new Dimension(250, 40));
        paymentButton.setOpaque(false);
        paymentButton.setFocusable(false);
        paymentButton.setContentAreaFilled(false);
        paymentButton.setBorder(new MatteBorder(0,0,1,0, new Color(248, 241, 241)));;

        paymentButton.add(paymentPanels);
        gbc.gridy=3;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(-190,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        sidebarPanel.add(paymentButton, gbc);

        JButton guestButton = new JButton();
        guestButton.setLayout(new BorderLayout());
        guestButton.setPreferredSize(new Dimension(250, 40));
        guestButton.setOpaque(false);
        guestButton.setFocusable(false);
        guestButton.setContentAreaFilled(false);
        guestButton.setBorder(new MatteBorder(0,0,1,0, new Color(248, 241, 241)));;

        guestButton.add(guestPanels);
        gbc.gridy=4;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(-140,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        sidebarPanel.add(guestButton, gbc);

        JButton settingButton = new JButton();
        settingButton.setLayout(new BorderLayout());
        settingButton.setPreferredSize(new Dimension(250, 40));
        settingButton.setOpaque(false);
        settingButton.setFocusable(false);
        settingButton.setContentAreaFilled(false);
        settingButton.setBorder(new MatteBorder(0,0,1,0, new Color(248, 241, 241)));;

        settingButton.add(settingsPanels);
        gbc.gridy=5;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(-90,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        sidebarPanel.add(settingButton, gbc);




//          MAIN CONTENT

//      CRATING A CARD LAYOUT
        CardLayout cardLayout = new CardLayout();

        JPanel centerPanel = new JPanel(cardLayout);
        centerPanel.setBackground(Color.DARK_GRAY);
        this.add(centerPanel, BorderLayout.CENTER);

//        CRATING THE DIFFERENT PANEL
//        DASHBOARD
        JPanel dashboardPanel = new JPanel();


//        DETAILS PANEL
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridBagLayout());
        dashboardPanel.add(detailsPanel);
        centerPanel.add(dashboardPanel,"dashboardPanel");

//        ROOM DETAILS PANEL
        JPanel roomDetail = new JPanel();
        roomDetail.setBackground(Color.white);
        roomDetail.setLayout(new GridBagLayout());
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(30,0,2,20);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomDetail.setPreferredSize(new Dimension(200, 150));
        detailsPanel.add(roomDetail, gbc);

        JPanel roomDetailsTop = new JPanel();
//        roomDetailsTop.setPreferredSize(new );
        roomDetailsTop.setLayout(new GridBagLayout());
        roomDetailsTop.setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomDetailsTop.setPreferredSize(new Dimension(200, 100));
        roomDetail.add(roomDetailsTop, gbc);
//        ROOM ICON

        JPanel roomIconPanel  = new JPanel();
        roomIconPanel. setBackground(new Color(197, 157, 44));
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(20,0,0,10);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomIconPanel.setPreferredSize(new Dimension(50, 50));
        roomDetailsTop.add(roomIconPanel, gbc);

        JLabel roomImageLabelIcon = new JLabel(new ImageIcon(roomImageIcon));
        roomImageLabelIcon.setHorizontalAlignment(SwingConstants.CENTER);
//        roomImageLabelIcon.setVerticalAlignment(SwingConstants.CENTER);
//        roomImageLabelIcon.setBorder(new LineBorder(Color.red, 4));
        roomImageLabelIcon.setPreferredSize(new Dimension(50, 40));
        roomIconPanel.add(roomImageLabelIcon);

//        ROOM Name
        JPanel roomNamePanel  = new JPanel();
        roomNamePanel. setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(20,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomNamePanel.setPreferredSize(new Dimension(100, 80));
        roomDetailsTop.add(roomNamePanel, gbc);

        JLabel labelName = new JLabel("Available Room");
        labelName.setHorizontalAlignment(SwingConstants.LEFT);
        labelName.setForeground(new Color(93, 91, 91));
        labelName.setPreferredSize(new Dimension(100, 20));
        roomNamePanel.add(labelName);

        JLabel labelCount = new JLabel(String.valueOf(displayRooms()));
        labelCount.setFont(new Font("Sans-serif",Font.BOLD, 25));
        labelCount.setHorizontalAlignment(SwingConstants.LEFT);
        labelCount.setPreferredSize(new Dimension(100, 20));

        roomNamePanel.add(labelCount);




        JPanel roomDetailsBottom = new JPanel();
//        roomDetailsTop.setPreferredSize(new );
        roomDetailsBottom.setBackground(new Color(239, 239, 165, 108));
        roomDetailsBottom.setLayout(new GridBagLayout());
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomDetailsBottom.setPreferredSize(new Dimension(200, 50));
        roomDetail.add(roomDetailsBottom, gbc);

        JButton roomBottomButton = new JButton("View Details");
        roomDetailsBottom.setPreferredSize(new Dimension(200, 50));
        gbc.insets = new Insets(0,0,0,0);
        roomBottomButton.setOpaque(false);
        roomBottomButton.setFocusable(false);
        roomBottomButton.setContentAreaFilled(false);
        roomBottomButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        roomDetailsBottom.add(roomBottomButton, gbc);



//        SUITE DETAILS PANEL
        JPanel suiteDetail = new JPanel();
        suiteDetail.setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(30,0,2,20);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        suiteDetail.setPreferredSize(new Dimension(200, 150));
        detailsPanel.add(suiteDetail, gbc);

        JPanel roomDetailsTop1 = new JPanel();
//        roomDetailsTop.setPreferredSize(new );
        roomDetailsTop1.setLayout(new GridBagLayout());
        roomDetailsTop1.setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomDetailsTop1.setPreferredSize(new Dimension(200, 100));
        suiteDetail.add(roomDetailsTop1, gbc);
//        ROOM ICON

        JPanel roomIconPanel1  = new JPanel();
        roomIconPanel1.setBackground(new Color(197, 157, 44));
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(20,0,0,10);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomIconPanel1.setPreferredSize(new Dimension(50, 50));
        roomDetailsTop1.add(roomIconPanel1, gbc);

        JLabel roomImageLabelIcon1 = new JLabel(new ImageIcon(roomImageIcon));
        roomImageLabelIcon1.setHorizontalAlignment(SwingConstants.CENTER);
//        roomImageLabelIcon.setVerticalAlignment(SwingConstants.CENTER);
//        roomImageLabelIcon.setBorder(new LineBorder(Color.red, 4));
        roomImageLabelIcon1.setPreferredSize(new Dimension(50, 40));
        roomIconPanel1.add(roomImageLabelIcon1);

//        ROOM Name
        JPanel roomNamePanel1  = new JPanel();
        roomNamePanel1.setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(20,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomNamePanel1.setPreferredSize(new Dimension(100, 80));
        roomDetailsTop1.add(roomNamePanel1, gbc);

        JLabel labelName1 = new JLabel("Available Suits");
        labelName1.setHorizontalAlignment(SwingConstants.LEFT);
        labelName1.setForeground(new Color(93, 91, 91));
        labelName1.setPreferredSize(new Dimension(100, 20));
        roomNamePanel1.add(labelName1);

        JLabel labelCount1 = new JLabel("35");
        labelCount1.setFont(new Font("Sans-serif",Font.BOLD, 25));
        labelCount1.setHorizontalAlignment(SwingConstants.LEFT);
        labelCount1.setPreferredSize(new Dimension(100, 20));

        roomNamePanel1.add(labelCount1);





        JPanel roomDetailsBottom1 = new JPanel();
//        roomDetailsTop.setPreferredSize(new );
        roomDetailsBottom1.setBackground(new Color(239, 239, 165, 108));
        roomDetailsBottom1.setLayout(new GridBagLayout());
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomDetailsBottom1.setPreferredSize(new Dimension(200, 50));
        suiteDetail.add(roomDetailsBottom1, gbc);

        JButton roomBottomButton1 = new JButton("View Details");
        roomDetailsBottom1.setPreferredSize(new Dimension(200, 50));
        gbc.insets = new Insets(0,0,0,0);
        roomBottomButton1.setOpaque(false);
        roomBottomButton1.setFocusable(false);
        roomBottomButton1.setContentAreaFilled(false);
        roomBottomButton1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        roomDetailsBottom1.add(roomBottomButton1, gbc);


//        CANCELLATION DETAILS PANEL
        JPanel cancellationDetail = new JPanel();
        cancellationDetail.setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(30,0,2,20);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        cancellationDetail.setPreferredSize(new Dimension(200, 150));
        detailsPanel.add(cancellationDetail, gbc);

        JPanel roomDetailsTop2 = new JPanel();
//        roomDetailsTop.setPreferredSize(new );
        roomDetailsTop2.setLayout(new GridBagLayout());
        roomDetailsTop2.setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomDetailsTop2.setPreferredSize(new Dimension(200, 100));
        cancellationDetail.add(roomDetailsTop2, gbc);
//        ROOM ICON

        JPanel roomIconPanel2  = new JPanel();
        roomIconPanel2.setBackground(new Color(197, 157, 44));
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(20,0,0,10);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomIconPanel2.setPreferredSize(new Dimension(50, 50));
        roomDetailsTop2.add(roomIconPanel2, gbc);

        JLabel roomImageLabelIcon2 = new JLabel(new ImageIcon(roomImageIcon));
        roomImageLabelIcon2.setHorizontalAlignment(SwingConstants.CENTER);
//        roomImageLabelIcon.setVerticalAlignment(SwingConstants.CENTER);
//        roomImageLabelIcon.setBorder(new LineBorder(Color.red, 4));
        roomImageLabelIcon2.setPreferredSize(new Dimension(50, 40));
        roomIconPanel2.add(roomImageLabelIcon2);

//        ROOM Name
        JPanel roomNamePanel2  = new JPanel();
        roomNamePanel2.setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(20,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomNamePanel2.setPreferredSize(new Dimension(100, 80));
        roomDetailsTop2.add(roomNamePanel2, gbc);

        JLabel labelName2 = new JLabel("Canceled Booking");
        labelName2.setHorizontalAlignment(SwingConstants.LEFT);
        labelName2.setForeground(new Color(93, 91, 91));
        labelName2.setPreferredSize(new Dimension(100, 20));
        roomNamePanel2.add(labelName2);

        JLabel labelCount2 = new JLabel("35");
        labelCount2.setFont(new Font("Sans-serif",Font.BOLD, 25));
        labelCount2.setHorizontalAlignment(SwingConstants.LEFT);
        labelCount2.setPreferredSize(new Dimension(100, 20));

        roomNamePanel2.add(labelCount2);




        JPanel roomDetailsBottom2 = new JPanel();
//        roomDetailsTop.setPreferredSize(new );
        roomDetailsBottom2.setBackground(new Color(239, 239, 165, 108));
        roomDetailsBottom2.setLayout(new GridBagLayout());
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomDetailsBottom2.setPreferredSize(new Dimension(200, 50));
        cancellationDetail.add(roomDetailsBottom2, gbc);

        JButton roomBottomButton2 = new JButton("View Details");
        roomDetailsBottom2.setPreferredSize(new Dimension(200, 50));
        gbc.insets = new Insets(0,0,0,0);
        roomBottomButton2.setOpaque(false);
        roomBottomButton2.setFocusable(false);
        roomBottomButton2.setContentAreaFilled(false);
        roomBottomButton2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        roomDetailsBottom2.add(roomBottomButton2, gbc);

        //        CANCELLATION DETAILS PANEL
        JPanel cancellationDetail1 = new JPanel();
        cancellationDetail1.setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 3;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(30,0,2,20);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        cancellationDetail1.setPreferredSize(new Dimension(200, 150));
        detailsPanel.add(cancellationDetail1, gbc);

        JPanel roomDetailsTop3 = new JPanel();
//        roomDetailsTop.setPreferredSize(new );
        roomDetailsTop3.setLayout(new GridBagLayout());
        roomDetailsTop3.setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomDetailsTop3.setPreferredSize(new Dimension(200, 100));
        cancellationDetail1.add(roomDetailsTop3, gbc);
//        ROOM ICON

        JPanel roomIconPanel3  = new JPanel();
        roomIconPanel3.setBackground(new Color(197, 157, 44));
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(20,0,0,10);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomIconPanel3.setPreferredSize(new Dimension(50, 50));
        roomDetailsTop3.add(roomIconPanel3, gbc);

        JLabel roomImageLabelIcon3 = new JLabel(new ImageIcon(roomImageIcon));
        roomImageLabelIcon3.setHorizontalAlignment(SwingConstants.CENTER);
//        roomImageLabelIcon.setVerticalAlignment(SwingConstants.CENTER);
//        roomImageLabelIcon.setBorder(new LineBorder(Color.red, 4));
        roomImageLabelIcon3.setPreferredSize(new Dimension(50, 40));
        roomIconPanel3.add(roomImageLabelIcon3);

//        ROOM Name
        JPanel roomNamePanel3  = new JPanel();
        roomNamePanel3.setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(20,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomNamePanel3.setPreferredSize(new Dimension(100, 80));
        roomDetailsTop3.add(roomNamePanel3, gbc);

        JLabel labelName3 = new JLabel("Available Room");
        labelName3.setHorizontalAlignment(SwingConstants.LEFT);
        labelName3.setForeground(new Color(93, 91, 91));
        labelName3.setPreferredSize(new Dimension(100, 20));
        roomNamePanel3.add(labelName3);

        JLabel labelCount3 = new JLabel("35");
        labelCount3.setFont(new Font("Sans-serif",Font.BOLD, 25));
        labelCount3.setHorizontalAlignment(SwingConstants.LEFT);
        labelCount3.setPreferredSize(new Dimension(100, 20));

        roomNamePanel3.add(labelCount3);




        JPanel roomDetailsBottom3 = new JPanel();
//        roomDetailsTop.setPreferredSize(new );
        roomDetailsBottom3.setBackground(new Color(239, 239, 165, 108));
        roomDetailsBottom3.setLayout(new GridBagLayout());
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomDetailsBottom3.setPreferredSize(new Dimension(200, 50));
        cancellationDetail1.add(roomDetailsBottom3, gbc);

        JButton roomBottomButton3 = new JButton("View Details");
        roomDetailsBottom3.setPreferredSize(new Dimension(200, 50));
        gbc.insets = new Insets(0,0,0,0);
        roomBottomButton3.setOpaque(false);
        roomBottomButton3.setFocusable(false);
        roomBottomButton3.setContentAreaFilled(false);
        roomBottomButton3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        roomDetailsBottom3.add(roomBottomButton3, gbc);


//        CANCELLATION PANEL
        JPanel cancellationDetail2 = new JPanel();
        cancellationDetail2.setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 4;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(30,0,2,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        cancellationDetail2.setPreferredSize(new Dimension(200, 150));
        detailsPanel.add(cancellationDetail2, gbc);

        JPanel roomDetailsTop4 = new JPanel();
//        roomDetailsTop.setPreferredSize(new );
        roomDetailsTop4.setLayout(new GridBagLayout());
        roomDetailsTop4.setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomDetailsTop4.setPreferredSize(new Dimension(200, 100));
        cancellationDetail2.add(roomDetailsTop4, gbc);
//        ROOM ICON

        JPanel roomIconPanel4  = new JPanel();
        roomIconPanel4.setBackground(new Color(197, 157, 44));
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(20,0,0,10);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomIconPanel4.setPreferredSize(new Dimension(50, 50));
        roomDetailsTop4.add(roomIconPanel4, gbc);

        JLabel roomImageLabelIcon4 = new JLabel(new ImageIcon(roomImageIcon));
        roomImageLabelIcon4.setHorizontalAlignment(SwingConstants.CENTER);
//        roomImageLabelIcon.setVerticalAlignment(SwingConstants.CENTER);
//        roomImageLabelIcon.setBorder(new LineBorder(Color.red, 4));
        roomImageLabelIcon4.setPreferredSize(new Dimension(50, 40));
        roomIconPanel4.add(roomImageLabelIcon4);

//        ROOM Name
        JPanel roomNamePanel4  = new JPanel();
        roomNamePanel4.setBackground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(20,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomNamePanel4.setPreferredSize(new Dimension(100, 80));
        roomDetailsTop4.add(roomNamePanel4, gbc);

        JLabel labelName4 = new JLabel("Available Room");
        labelName4.setHorizontalAlignment(SwingConstants.LEFT);
        labelName4.setForeground(new Color(93, 91, 91));
        labelName4.setPreferredSize(new Dimension(100, 20));
        roomNamePanel4.add(labelName4);

        JLabel labelCount4 = new JLabel("35");
        labelCount4.setFont(new Font("Sans-serif",Font.BOLD, 25));
        labelCount4.setHorizontalAlignment(SwingConstants.LEFT);
        labelCount4.setPreferredSize(new Dimension(100, 20));

        roomNamePanel4.add(labelCount4);




        JPanel roomDetailsBottom4 = new JPanel();
//        roomDetailsTop.setPreferredSize(new );
        roomDetailsBottom4.setBackground(new Color(239, 239, 165, 108));
        roomDetailsBottom4.setLayout(new GridBagLayout());
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomDetailsBottom4.setPreferredSize(new Dimension(200, 50));
        cancellationDetail2.add(roomDetailsBottom4, gbc);

        JButton roomBottomButton4 = new JButton("View Details");
        roomDetailsBottom4.setPreferredSize(new Dimension(200, 50));
        gbc.insets = new Insets(0,0,0,0);
        roomBottomButton4.setOpaque(false);
        roomBottomButton4.setFocusable(false);
        roomBottomButton4.setContentAreaFilled(false);
        roomBottomButton4.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        roomDetailsBottom4.add(roomBottomButton4, gbc);


//       AVAILABLE ROOM LABEL
        JPanel availableRoomPanel = new JPanel();
        availableRoomPanel.setLayout(new GridBagLayout());
        dashboardPanel.add(availableRoomPanel);
//        availableRoomPanel.setBackground(Color.black);
        availableRoomPanel.setPreferredSize(new Dimension(1100, 40));
        availableRoomPanel.setBorder(new EmptyBorder(0,-930,0,0));

//        LABEL
        JLabel availableRoom = new JLabel("Available Rooms");
        availableRoom.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        gbc.gridy = 0;
        gbc.gridx = 0;
        availableRoomPanel.add(availableRoom, gbc);
//       AVAILABLE ROOM DETAILS

        JPanel roomDetails = new JPanel();
        roomDetails.setLayout(new GridBagLayout());
//        roomDetails.setBorder(new LineBorder(Color.red,2));
        dashboardPanel.add(roomDetails);

//        ROOM PANELS

        new RoomType(bg1, 0,0,20, roomDetails);
        new RoomType(bg2, 1,0, 20, roomDetails);
        new RoomType(image1, 2,0, 20, roomDetails);
        new RoomType(bg2, 3,0, 20, roomDetails);
        new RoomType(bg1, 4,0, 0, roomDetails);




//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  BOOKING LABEL  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        JPanel bookingPanel = new JPanel();
        bookingPanel.setPreferredSize(new Dimension(1080, 40));
//        bookingPanel.setLayout(new GridBagLayout());
        bookingPanel.setBackground(Color.white);
        dashboardPanel.add(bookingPanel);

        JLabel bookingLabel = new JLabel("Booking Details");
        bookingLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        bookingLabel.setPreferredSize(new Dimension(1080, 40));
        bookingLabel.setBorder(new EmptyBorder(0,20,10,0));
        bookingPanel.add(bookingLabel, BorderLayout.WEST);

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   BOOKING COLUMNS    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        JPanel bookingColumn = new JPanel();
        bookingColumn.setPreferredSize(new Dimension(1080, 40));
        bookingColumn.setBorder(new EmptyBorder(0,20,0,0));
        bookingColumn.setLayout(new GridLayout(1,7));
        dashboardPanel.add(bookingColumn);

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   BOOKING COLUMNS DATA   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        JLabel bookingDateLabel = new JLabel("Booking Date");
        JLabel GuestID1 = new JLabel("GuestID");
        JLabel customerLabel = new JLabel("Customer");
        JLabel roomtype = new JLabel("Room type");
        JLabel phoneLabel = new JLabel("Phone");
        JLabel personLabel = new JLabel("Person");
        JLabel checkINLabel = new JLabel("Check-in");
        JLabel checkOutLabel = new JLabel("Check-out");
        JLabel amount = new JLabel("Amount");
        JLabel totalreserved = new JLabel("Total Reserved");
        JLabel paymentLabel1 = new JLabel("Payment");
        bookingDateLabel.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        customerLabel.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        roomtype.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        personLabel.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        phoneLabel.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        checkINLabel.setFont(new Font("Sans-serif", Font.PLAIN, 9)); //update
        checkOutLabel.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        paymentLabel1.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        GuestID1.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        amount.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        totalreserved.setFont(new Font("Sans-serif", Font.PLAIN, 9));

        bookingColumn.add(bookingDateLabel);
        bookingColumn.add(GuestID1);

        bookingColumn.add(personLabel);
        bookingColumn.add(customerLabel);
        bookingColumn.add(roomtype);
        //work second
        bookingColumn.add(phoneLabel);

        bookingColumn.add(checkINLabel);
        bookingColumn.add(checkOutLabel);
        bookingColumn.add(amount);
        bookingColumn.add(totalreserved);
        bookingColumn.add(paymentLabel1);


//    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> BOOKING ROWS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

//    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<    ROW 1     >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        String dates = displayPaymentDates();
        String[] splittedDate = dates.split(",");

        String guests = displayGuests();
        String[] splittedguest = guests.split(",");

        String phonenumber = displayPhonenumber();
        String[] splittednumber = phonenumber.split(",");

        String checkins = displayStartDates();
        String[] splittedcheckins = checkins.split(",");


      
        String [] splittedid =  displayGuestsID();
        String[] splitedtotal = displayTotalReserved();

        String[] splitedamount = displayPaymentAmounts();

        String[] splittedroomtype = roomtype();

        for (int i = 0; i < 3; i++) {
            BookingDetail bookingDetail = new BookingDetail(splittedDate[i], splittedguest[i], splittedroomtype[i], "2xAdults 1xChild",
                    splittednumber[i], splittedcheckins[i], getEndDate(), splitedamount[i], splitedtotal[i], splittedid[i]);
            dashboardPanel.add(bookingDetail.bookingRow1);
        }







//        DO NOT TOUCH THIS CODE FOR NOW OOO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ROOM SIDEBAR CONTENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        JPanel roomPanel = new JPanel();
        JScrollPane roomScrollPanel = new JScrollPane(roomPanel);
        roomScrollPanel.add(new JLabel("roomPanel"));
        centerPanel.add(roomScrollPanel,"roomPanel");

        JPanel roomPanel1 = new JPanel();
        JScrollPane roomScrollPanel1 = new JScrollPane(roomPanel1);
        roomScrollPanel1.setBorder(new LineBorder(Color.white,  0));
        roomScrollPanel1.add(new JLabel("roomPanel"));
        centerPanel.add(roomScrollPanel1,"roomPanel");


        JPanel roomDetails1 = new JPanel();
        roomDetails1.setLayout(new GridBagLayout());
        roomDetails1.setLayout(new GridBagLayout());
        roomPanel1.add(roomDetails1);

        new RoomType(bg1, 0,0,20, roomDetails1);
        new RoomType(bg2, 1,0, 20, roomDetails1);
        new RoomType(image1, 2,0, 20, roomDetails1);
        new RoomType(bg1, 3,0, 20, roomDetails1);
        new RoomType(image1, 4,0, 0, roomDetails1);

        new RoomType(bg2, 0,1,20, roomDetails1);
        new RoomType(bg2, 1,1, 20, roomDetails1);
        new RoomType(bg1, 2,1, 20, roomDetails1);
        new RoomType(bg2, 3,1, 0, roomDetails1);
        new RoomType(bg1, 4,1, 0, roomDetails1);

        new RoomType(bg1, 0,2,20, roomDetails1);
        new RoomType(image1, 1,2, 20, roomDetails1);
        new RoomType(bg1, 2,2, 20, roomDetails1);
        new RoomType(image1, 3,2, 20, roomDetails1);
        new RoomType(bg1, 4,2, 0, roomDetails1);

        new RoomType(bg2, 0,3,20, roomDetails1);
        new RoomType(bg1, 1,3, 20, roomDetails1);
        new RoomType(bg2, 2,3, 20, roomDetails1);
        new RoomType(bg1, 3,3, 20, roomDetails1);
        new RoomType(bg2, 4,3, 0, roomDetails1);

        new RoomType(bg1, 0,4,20, roomDetails1);
        new RoomType(image1, 1,4, 20, roomDetails1);
        new RoomType(bg2, 2,4, 20, roomDetails1);
        new RoomType(image1, 3,4, 20, roomDetails1);
        new RoomType(bg2, 4,4, 0, roomDetails1);

        new RoomType(bg2, 0,5,20, roomDetails1);
        new RoomType(image1, 1,5, 20, roomDetails1);
        new RoomType(bg2, 2,5, 20, roomDetails1);
        new RoomType(image1, 3,5, 20, roomDetails1);
        new RoomType(bg2, 4,5, 0, roomDetails1);

        new RoomType(bg1, 0,6,20, roomDetails1);
        new RoomType(bg2, 1,6, 20, roomDetails1);
        new RoomType(bg2, 2,6, 20, roomDetails1);
        new RoomType(bg1, 3,6, 20, roomDetails1);
        new RoomType(bg1, 4,6, 0, roomDetails1);

        new RoomType(image1, 0,7,20, roomDetails1);
        new RoomType(bg1, 1,7, 20, roomDetails1);
        new RoomType(bg2, 2,7, 20, roomDetails1);
        new RoomType(bg1, 3,7, 20, roomDetails1);
        new RoomType(image1, 4,7, 0, roomDetails1);

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  SUITE SIDEBAR CONTENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        JPanel suitePanel = new JPanel();
        suitePanel.add(new JLabel("suitePanel"));
        centerPanel.add(suitePanel,"suitePanel" );

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  PAYMET SIDEBAR CONTENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        JPanel paymentPanel = new JPanel();
        paymentPanel.add(new JLabel("paymentPanel"));
        centerPanel.add(paymentPanel,"paymentPanel" );

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  GUEST SIDEBAR CONTENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        JPanel guestPanel = new JPanel();

        centerPanel.add(guestPanel,"guestPanel" );
        JPanel bookingPanel1 = new JPanel();
        bookingPanel1.setPreferredSize(new Dimension(1080, 40));
//        bookingPanel1.setLayout(new GridBagLayout());
        bookingPanel1.setBackground(Color.white);
        guestPanel.add(bookingPanel1);

        JLabel bookingLabel1 = new JLabel("Booking Details");
        bookingLabel1.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        bookingLabel1.setPreferredSize(new Dimension(1080, 40));
        bookingLabel1.setBorder(new EmptyBorder(0,20,10,0));
        bookingPanel1.add(bookingLabel1, BorderLayout.WEST);

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   BOOKING COLUMNS    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        JPanel bookingColumn1 = new JPanel();
        bookingColumn1.setPreferredSize(new Dimension(1080, 40));
        bookingColumn1.setBorder(new EmptyBorder(0,20,0,0));
        bookingColumn1.setLayout(new GridLayout(1,7));
        guestPanel.add(bookingColumn1);

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   BOOKING COLUMNS DATA   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        JLabel bookingDateLabel1 = new JLabel("Booking Date");
        JLabel GuestID = new JLabel("GuestID");
        JLabel customerLabel1 = new JLabel("Customer");
        JLabel RoomType1 = new JLabel("Room type");
        JLabel personLabel1 = new JLabel("Person");
        JLabel phoneLabel1 = new JLabel("Phone");
        JLabel checkINLabel1 = new JLabel("Check-in");
        JLabel checkOutLabel1 = new JLabel("Check-out");
        JLabel amount1 = new JLabel("Amount");
        JLabel totalreservedlabel = new JLabel("Total Reserved");
        JLabel paymentLabel11 = new JLabel("Payment");
        bookingDateLabel.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        customerLabel.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        RoomType1.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        personLabel.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        phoneLabel.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        checkINLabel.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        checkOutLabel.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        paymentLabel1.setFont(new Font("Sans-serif", Font.PLAIN, 9));
        amount1.setFont(new Font("Sans-serif", Font.PLAIN, 9));

        bookingColumn1.add(bookingDateLabel1);
        bookingColumn1.add(GuestID);

        bookingColumn1.add(personLabel1);
        bookingColumn1.add(customerLabel1);
        bookingColumn1.add(RoomType1);
        //work second
        bookingColumn1.add(phoneLabel1);

        bookingColumn1.add(checkINLabel1);
        bookingColumn1.add(checkOutLabel1);
        bookingColumn1.add(amount1);
        bookingColumn1.add(totalreservedlabel);
        bookingColumn1.add(paymentLabel11);



        for (int i = 0; i < 14; i++) {
            BookingDetail bookingDetail = new BookingDetail(splittedDate[i], splittedguest[i], splittedroomtype[i], "2xAdults 1xChild",
                    splittednumber[i], splittedcheckins[i], getEndDate(), splitedamount[i], splitedtotal[i], splittedid[i]);
            guestPanel.add(bookingDetail.bookingRow1);
        }




//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  SETTINGS SIDEBAR CONTENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        JPanel settingPanel = new JPanel();
        settingPanel.add(new JLabel("settingPanel"));
        centerPanel.add(settingPanel,"settingPanel" );


//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ADDING ACTION LISTENER TO THE SIDEBAR >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        dashboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "dashboardPanel");
            }
        });

        roomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "roomPanel");
            }
        });

        suiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "suitePanel");
            }
        });
         paymentButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 cardLayout.show(centerPanel, "paymentPanel");
             }
         });
        settingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "settingPanel");
            }
        });
        guestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "guestPanel");
            }
        });
    }






//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> GETTING IMAGE FROM ROOT DIRECTORY >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
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

    public static void main(String[] args) throws SQLException {
        new Dashboard();
    }
}

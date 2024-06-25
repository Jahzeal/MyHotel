package Project;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class HomeScreen extends JFrame {
    String bgColor = "#093a54";

    HomeScreen() {
        // CREATING NAV PANEL
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel nav = new JPanel();
        nav.setBackground(Color.decode(bgColor));
        nav.setLayout(new GridBagLayout());

        Image scaledImage = getImage("/images/logo.png", 154, 64);
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nav.add(imageLabel, gbc);

        // Subcribe content
        Image emailImage = getImage("/images/email (1).png", 30, 30);
        JLabel emailLabel = new JLabel(new ImageIcon(emailImage));
        emailLabel.setPreferredSize(new Dimension(35, 85));

        JLabel subscribeLabel = new JLabel("FEEDBACK");    //connect to backend
        subscribeLabel.setFont(new Font("Sans-serif", Font.BOLD, 17));
        subscribeLabel.setForeground(Color.white);

        // Subscribe panel
        JPanel subscribePanel = new JPanel();
        subscribePanel.setPreferredSize(new Dimension(200, 80));
        subscribePanel.add(emailLabel, BorderLayout.EAST);
        subscribePanel.add(subscribeLabel, BorderLayout.CENTER);
        subscribePanel.setBackground(Color.decode(bgColor));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nav.add(subscribePanel, gbc);

        // Book now button
        JButton bookButton = new JButton("Book Now");
        bookButton.setOpaque(false);
        bookButton.setFocusable(false);
        bookButton.setContentAreaFilled(false);
        bookButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        bookButton.setFont(new Font("Sans-serif", Font.BOLD, 17));
        bookButton.setForeground(Color.WHITE);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
        bookButton.setPreferredSize(new Dimension(150, 50));
        nav.add(bookButton, gbc);

        // Screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Creating body content
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridBagLayout()); // Example content, adjust as needed

        JScrollPane scrollPane = new JScrollPane(bodyPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(new LineBorder(Color.white, 0));
        bodyPanel.setBackground(Color.decode(bgColor));

        // Custom JPanel panel1 with background image
        Image backgroundImage = getImage("/images/bg2.jpg", screenSize.width, screenSize.height); // Adjust the path and size
        JPanel panel1 = new ImagePanel(backgroundImage, 1);
        gbc.gridy=0;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,1000,0);
        gbc.fill = GridBagConstraints.NONE;
        panel1.setPreferredSize(new Dimension(screenSize.width, 650));
        panel1.setLayout(new GridBagLayout());
        bodyPanel.add(panel1, gbc);
        System.out.println(screenSize);


//        panel1 content

        JPanel panel1Content1 = new JPanel();
        panel1Content1.setBackground(new Color(9, 58, 84, (int) (0.7 * 255)));
        panel1Content1.setOpaque(false);
        panel1Content1.setLayout(new GridBagLayout());
//        panel1.setBackground(Color.white);
//        panel1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gbc.gridy=0;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        panel1Content1.setPreferredSize(new Dimension(1008, 500));
        panel1.add(panel1Content1, gbc);

        JLabel homeLabel1 = new JLabel("<html>Stay with us feel like <br> home in our hotel </html>");
        homeLabel1.setFont(new Font("Sans-serif", Font.BOLD, 60));
        homeLabel1.setForeground(Color.white);
//        homeLabel1.setBorder(new LineBorder(Color.white,2));
        gbc.gridy=0;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        homeLabel1.setPreferredSize(new Dimension(900, 180));
        gbc.fill = GridBagConstraints.NONE;
        panel1Content1.add(homeLabel1, gbc);

//
        JLabel homeLabel2 = new JLabel("<html>Trusted and suited hotel with reliable services for you and your family, escape to stylish comfort in one of our spacious suites and enjoy 10% savings when you stay two nights or more</html>");
        homeLabel2.setForeground(Color.white);
        homeLabel2.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        gbc.gridy=1;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        homeLabel2.setPreferredSize(new Dimension(700, 100));
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panel1Content1.add(homeLabel2, gbc);
//
//
//
        JButton homeButton = new JButton("Book Now");
        homeButton.setOpaque(false);
        homeButton.setFocusable(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        homeButton.setFont(new Font("Sans-serif", Font.BOLD, 17));
        homeButton.setForeground(Color.WHITE);
        gbc.gridy=2;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        homeButton.setPreferredSize(new Dimension(150, 50));
        panel1Content1.add(homeButton,gbc);

        JPanel panel1Content = new JPanel();
        panel1Content.setBackground(new Color(9, 58, 84, (int) (0.7 * 255)));
//        panel1.setBackground(Color.white);
//        panel1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        gbc.gridy=1;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;

        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;
        panel1Content.setPreferredSize(new Dimension(1006, 114));
//        panel1.add(panel1Content, gbc);

        // Custom JPanel panel2
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc.gridy=1;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(-10,0,10,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;//        gbc.insets = new Insets(-160,0,0,0);
        panel2.setPreferredSize(new Dimension(screenSize.width, 1100));
        panel2.setBackground(Color.decode(bgColor));
        bodyPanel.add(panel2,gbc);

//        panel2 content
        Image panel2GetImage = getImage("/images/bg1.jpg",560,537);
        JLabel panel2Image = new JLabel(new ImageIcon(panel2GetImage));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(-200,0,0,0);
        gbc.fill = GridBagConstraints.NONE;
        panel2Image.setPreferredSize(new Dimension(590, 537));
//        panel2Image.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        panel2.add(panel2Image, gbc);

        JPanel panel2Content = new JPanel();
//        panel2Content.setBackground(Color.red);
        panel2Content.setLayout(new GridBagLayout());


        gbc.gridy = 0;
        gbc.gridx = 1;
//        gbc.gridx = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(100,0,0,0);
        panel2Content.setPreferredSize(new Dimension(750, 800));
        panel2Content.setBackground(Color.decode(bgColor));
//        panel2Content.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        panel2.add(panel2Content, gbc);

//        panel2 content text
        JLabel panel2ContentHeader = new JLabel("<html>A TRIBECA CORNERSTONE<html>");
        panel2ContentHeader.setFont(new Font("Sans-serif", Font.PLAIN, 48));
        panel2ContentHeader.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,10,0);
        gbc.fill = GridBagConstraints.NONE;
//        panel2ContentHeader.setPreferredSize(new Dimension(590, 50) );
        panel2Content.add(panel2ContentHeader, gbc);

        JLabel panel2ContentBody = new JLabel("<html>Tailored and timeless, Smyth Tribeca is rooted in the history and artistic soul of one of New York City’s most iconic neighborhoods. Discover curated cultural experiences and boutique accommodations in a place where cobblestones and cocktails mix and mingle.<html>");
        panel2ContentBody.setFont(new Font("Sans-serif", Font.PLAIN, 18));
        panel2ContentBody.setForeground(Color.white);

        gbc.gridx = 0;
        gbc.gridy = 1;
//        gbc.weightx = .5;
//        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,0,10,0);
//        panel2ContentBody.setPreferredSize(new Dimension(590, 50) );
        panel2Content.add(panel2ContentBody, gbc);


        JButton panel2Button = new JButton("DISCOVER THE SMYTH →");
        panel2Button.setFont(new Font("Sans-serif", Font.BOLD, 18));
        panel2Button.setOpaque(false);
        panel2Button.setFocusable(false);
        panel2Button.setContentAreaFilled(false);
        panel2Button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        panel2Button.setForeground(Color.white);

        gbc.gridx = 0;
        gbc.gridy = 2;
//        gbc.weightx = 0;
//        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,50,0);
        gbc.fill = GridBagConstraints.NONE;
//        panel2ContentHeader.setPreferredSize(new Dimension(590, 50) );
        panel2Content.add(panel2Button, gbc);


        Image panel2ContentGetImage = getImage("/images/bg2.jpg",415,350);
        JLabel panel2ContentImage = new JLabel(new ImageIcon(panel2ContentGetImage));
        gbc.gridx = 0;
        gbc.gridy = 3;
//        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.fill = GridBagConstraints.NONE;
        panel2Content.add(panel2ContentImage, gbc);

//        PANEL 3
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc.gridy=2;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(-50,0,10,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;//        gbc.insets = new Insets(-160,0,0,0);
        panel3.setPreferredSize(new Dimension(screenSize.width, 200));
        panel3.setBackground(Color.decode("#093a54"));
        bodyPanel.add(panel3,gbc);

        JLabel pane3Label = new JLabel("<html>SUITES, CHIC DOWNTOWN <br> STYLE</html>");
        pane3Label.setFont(new Font("Sans-serif", Font.PLAIN, 48));
//        pane3Label.setBackground(Color.black);
        pane3Label.setForeground(Color.white);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.fill = GridBagConstraints.NONE;
        panel3.add(pane3Label, gbc);



        //        panel3buttons

        JPanel panel3buttons = new JPanel();
        panel3buttons.setBackground(Color.decode("#093a54"));
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.ipady = 10;
        gbc.insets = new Insets(12,0,0,0);
        gbc.fill = GridBagConstraints.NONE;
        panel3buttons.setPreferredSize(new Dimension(560, 120 ));
        panel3buttons.setLayout(new GridBagLayout());
        panel3.add(panel3buttons, gbc);


        //        panel3buttons button
        JButton suiteButton = new JButton("SUITES");
        suiteButton.setForeground(Color.white);
        suiteButton.setOpaque(false);
        suiteButton.setFocusable(false);
        suiteButton.setContentAreaFilled(false);
        suiteButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        suiteButton.setFont(new Font("Sans-serif", Font.BOLD, 17));
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.insets = new Insets(0,200,0,50);
        panel3buttons.add(suiteButton, gbc);

        JButton roomButton = new JButton("ROOM");
        roomButton.setOpaque(false);
        roomButton.setFocusable(false);
        roomButton.setContentAreaFilled(false);
        roomButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        roomButton.setForeground(Color.white);
        roomButton.setFont(new Font("Sans-serif", Font.BOLD, 17));
        gbc.insets = new Insets(0,0,0,50);
        gbc.gridy = 0;
        gbc.gridx = 1;
        panel3buttons.add(roomButton, gbc);

        JButton viewALlButton = new JButton("VIEW ALL →");
        viewALlButton.setOpaque(false);
        viewALlButton.setFocusable(false);
        viewALlButton.setContentAreaFilled(false);
        viewALlButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        viewALlButton.setForeground(Color.white);
        viewALlButton.setFont(new Font("Sans-serif", Font.BOLD, 17));
        gbc.insets = new Insets(0,0,0,50);
        gbc.gridy = 0;
        gbc.gridx = 2;
        panel3buttons.add(viewALlButton, gbc);

//        panel 4
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.decode(bgColor));
        panel4.setLayout(new GridBagLayout());
        gbc.gridy=3;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(-30,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;//        gbc.insets = new Insets(-160,0,0,0);
        panel4.setPreferredSize(new Dimension(screenSize.width, 350));
        bodyPanel.add(panel4,gbc);

//        panel 4 bacground image
        Image panel4BackgroundImage1 = getImage("/images/bg1.jpg", 350, 350); // Adjust the path and size
        JPanel panel4Image1 = new ImagePanel(panel4BackgroundImage1, 2);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(-80,0,0,20);
        panel4Image1.setPreferredSize(new Dimension(350, 350));
        panel4.add(panel4Image1,gbc);

        Image panel4BackgroundImage2 = getImage("/images/bg2.jpg", 350, 350); // Adjust the path and size
        JPanel panel4Image2 = new ImagePanel(panel4BackgroundImage2, 2);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(-80,0,0,20);
        panel4Image2.setPreferredSize(new Dimension(350, 350));
        panel4.add(panel4Image2, gbc);

        Image panel4BackgroundImage3 = getImage("/images/bg1.jpg", 350, 350); // Adjust the path and size
        JPanel panel4Image3 = new ImagePanel(panel4BackgroundImage3, 2);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(-80,0,0,20);
        panel4Image3.setPreferredSize(new Dimension(350, 350));
        panel4.add(panel4Image3, gbc);

//        panel 5

        JPanel panel5 = new JPanel();
//        panel5.setBorder(new LineBorder(Color.white, 3));
//        panel4.setBorder(new LineBorder(Color.white, 3));
        panel5.setPreferredSize(new Dimension(screenSize.width, 700));
        panel5.setBackground(Color.decode(bgColor));
        panel5.setLayout(new GridBagLayout());
        gbc.gridy=4;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;//        gbc.insets = new Insets(-160,0,0,0);
//        panel3.setBackground(Color.decode("#093a54"));
        bodyPanel.add(panel5,gbc);

        JPanel panel5LabelPanel = new JPanel();
        panel5LabelPanel.setLayout(new GridBagLayout());
        panel5LabelPanel.setBackground(Color.decode(bgColor));
        panel5LabelPanel.setPreferredSize(new Dimension(400, 500));
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weighty = 0;
        gbc.weightx = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.fill = GridBagConstraints.NONE;
        panel5.add(panel5LabelPanel, gbc);

//        panel 5 label

        JLabel panel5TopLabel = new JLabel("<html>‘Y’ MARKS <br> THE SPOT</html>");
        panel5TopLabel.setForeground(Color.white);
        panel5TopLabel.setFont(new Font("Sans-serif", Font.PLAIN, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.fill = GridBagConstraints.NONE;
        panel5LabelPanel.add(panel5TopLabel, gbc);

        JLabel panel5MiddleLabel = new JLabel("<html>You’ll find us in the center of an <br> iconic neighborhood, where contemporary style and culture come <br> alive in a nostalgic Old Manhattan <br> atmosphere.</html>");
        panel5MiddleLabel.setForeground(Color.white);
        panel5MiddleLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        panel5MiddleLabel.setPreferredSize(new Dimension(350,200));
        panel5MiddleLabel.setVerticalAlignment(JLabel.CENTER);
        panel5MiddleLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.fill = GridBagConstraints.NONE;
        panel5LabelPanel.add(panel5MiddleLabel, gbc);

        JButton panel5Button = new JButton("EXPLORER TRIBECA →");
        panel5Button.setFont(new Font("Sans-serif", Font.BOLD, 17));
        panel5Button.setOpaque(false);
        panel5Button.setFocusable(false);
        panel5Button.setContentAreaFilled(false);
        panel5Button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        panel5Button.setForeground(Color.white);
//        panel5Button.setPreferredSize(new Dimension(500, 50));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.fill = GridBagConstraints.NONE;
        panel5LabelPanel.add(panel5Button, gbc);


//        panel 5 background image

        JPanel scrollContent = new JPanel();
        scrollContent.setBackground(Color.decode(bgColor));
        scrollContent.setLayout(new GridBagLayout());

        JScrollPane panel5Scroll = new JScrollPane(scrollContent);
        panel5Scroll.setPreferredSize(new Dimension(screenSize.width-500, 700));
        panel5Scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel5Scroll.setBorder(new LineBorder(Color.WHITE, 0));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,0);
        panel5.add(panel5Scroll, gbc);



        Image panel5BackgroundImage1 = getImage("/images/bg1.jpg", 350, 700); // Adjust the path and size
        JPanel panel5Image1 = new ImagePanel(panel5BackgroundImage1, 2);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,30);
        panel5Image1.setPreferredSize(new Dimension(400, 550));
        scrollContent.add(panel5Image1,gbc);

        Image panel5BackgroundImage2 = getImage("/images/bg2.jpg", 250, 500); // Adjust the path and size
        JPanel panel5Image2 = new ImagePanel(panel5BackgroundImage2, 2);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,30);
        panel5Image2.setPreferredSize(new Dimension(300, 450));
        scrollContent.add(panel5Image2,gbc);

        Image panel5BackgroundImage3 = getImage("/images/bg1.jpg", 150, 350); // Adjust the path and size
        JPanel panel5Image3 = new ImagePanel(panel5BackgroundImage3, 2);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,0);
        panel5Image3.setPreferredSize(new Dimension(200, 300));
        scrollContent.add(panel5Image3,gbc);



//        panel 6

        JPanel panel6 = new JPanel();
        panel6.setPreferredSize(new Dimension( screenSize.width, 600));
        panel6.setBackground(new Color(10, 39, 52));
        panel6.setLayout(new GridBagLayout());
        gbc.gridy=5;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;//        gbc.insets = new Insets(-160,0,0,0);
//        panel3.setBackground(Color.decode("#093a54"));
        bodyPanel.add(panel6,gbc);

//        panel 6 Images
        Image panel6BackgroundImage1 = getImage("/images/bg1.jpg", 400, 450); // Adjust the path and size
        Image panel6BackgroundImage2 = getImage("/images/bg2.jpg", 400, 450); // Adjust the path and size


        JLabel panel6Image1 = new JLabel(new ImageIcon(panel6BackgroundImage1));
        panel6Image1.setPreferredSize(new Dimension(400,450));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,30);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        panel6.add(panel6Image1, gbc);

        JLabel panel6Image2 = new JLabel(new ImageIcon(panel6BackgroundImage2));
        panel6Image2.setPreferredSize(new Dimension(400,450));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(-80,0,0,30);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        panel6.add(panel6Image2, gbc);

        JPanel panel6Label = new JPanel();
        panel6Label.setPreferredSize(new Dimension(350,350));
        panel6Label.setLayout(new GridBagLayout());
        panel6Label.setBackground(new Color(10, 39, 52));
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        panel6.add(panel6Label, gbc);

        JLabel panel6TopLabel= new JLabel("<html>A TASTE OF <br> TRADITION</html>");
        panel6TopLabel.setFont(new Font("Sans-serif", Font.BOLD, 35));
        panel6TopLabel.setPreferredSize(new Dimension(350,100));
        panel6TopLabel.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        panel6Label.add(panel6TopLabel,gbc);

        JLabel panel6MiddleLabel= new JLabel("<html>Sip a class cocktail and dine on upper club-inspired dishes surrounded abundant artwork at Symth Tavern and Galerie Bar. </html>");
        panel6MiddleLabel.setPreferredSize(new Dimension(350,150));
        panel6MiddleLabel.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        panel6MiddleLabel.setForeground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        panel6Label.add(panel6MiddleLabel,gbc);

        JButton panel6Button = new JButton("DINE WITH US→");
        panel6Button.setFont(new Font("Sans-serif", Font.BOLD, 17));
        panel6Button.setForeground(Color.white);
        panel6Button.setOpaque(false);
        panel6Button.setFocusable(false);
        panel6Button.setContentAreaFilled(false);
        panel6Button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        panel6Label.add(panel6Button,gbc);

//        panel 7
        Image panel7Logo = getImage("/images/logo.png", 300, 100); // Adjust the path and size

        JLabel label7 = new JLabel(new ImageIcon(panel7Logo));
        label7.setPreferredSize(new Dimension(screenSize.width, 102));
        gbc.gridy=6;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(30,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        bodyPanel.add(label7,gbc);

//        panel 8
        JLabel label8 = new JLabel("85 West Broadway,NewYork, NY10007-1045");
        label8.setForeground(Color.white);
        label8.setFont(new Font("Sans-srif", Font.PLAIN, 13));
        label8.setHorizontalAlignment(JLabel.CENTER);
        label8.setPreferredSize(new Dimension(screenSize.width, 50));
        gbc.gridy=7;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        bodyPanel.add(label8,gbc);

        //        panel 9
        JLabel label9 = new JLabel("@copyright Symth Tribeca");
        label9.setForeground(Color.white);
        label9.setFont(new Font("Sans-srif", Font.PLAIN, 12));
        label9.setHorizontalAlignment(JLabel.CENTER);
        label9.setPreferredSize(new Dimension(screenSize.width, 50));
        gbc.gridy=8;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        bodyPanel.add(label9,gbc);

        JButton adminButton = new JButton("Admin");
        adminButton.setOpaque(false);
        adminButton.setFocusable(false);
        adminButton.setContentAreaFilled(false);
        adminButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        adminButton.setFont(new Font("Sans-serif", Font.BOLD, 17));
        adminButton.setPreferredSize(new Dimension(150, 50) );
        adminButton.setForeground(Color.WHITE);
        gbc.gridy=9;
        gbc.gridx=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,600,20,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        bodyPanel.add(adminButton,gbc);

















        // Setting up the frame window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(nav, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setSize(screenSize);
        this.setVisible(true);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    Dashboard dashboard =  new Dashboard();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                BookNowFront bookNowFront = new BookNowFront();

            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                BookNowFront bookNowFront = new BookNowFront();
            }
        });
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

    static class ImagePanel extends JPanel {
        private final Image backgroundImage;
        int count;

        public ImagePanel(Image backgroundImage, int count) {
            this.count = count;
            this.backgroundImage = backgroundImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null && count == 1 ) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

                g2d.setColor(new Color(0));
                g2d.fillRect(0,0, getWidth(), getHeight());
                g2d.dispose();


            }else if(backgroundImage != null  && count == 2){
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

            }
        }
    }

}
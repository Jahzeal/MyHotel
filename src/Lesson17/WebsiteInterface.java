//package Lesson17;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class WebsiteInterface extends JFrame {
//    private static final int SPLASH_SCREEN_DURATION = 10000; // 10 seconds in milliseconds
//
//    public WebsiteInterface() {
//        // Set up JFrame
//        setTitle("Website Interface");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the JFrame
//
//        // Create navigation panel
//        JPanel navigationPanel = new JPanel();
//        navigationPanel.setBackground(Color.BLUE);
//        navigationPanel.setPreferredSize(new Dimension(getWidth(), 50)); // Adjust height as needed
//        JLabel navLabel = new JLabel("Navigation");
//        navLabel.setForeground(Color.WHITE);
//        navigationPanel.add(navLabel);
//
//        // Create scrollable body panel
//        JPanel bodyPanel = new JPanel();
//        bodyPanel.setLayout(new GridLayout(100, 1)); // Example content, adjust as needed
//        for (int i = 0; i < 100; i++) {
//            bodyPanel.add(new JLabel("Content " + (i + 1)));
//        }
//        JScrollPane scrollPane = new JScrollPane(bodyPanel);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//
//        // Add components to JFrame
//        getContentPane().setLayout(new BorderLayout());
//        getContentPane().add(navigationPanel, BorderLayout.NORTH);
//        getContentPane().add(scrollPane, BorderLayout.CENTER);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            showSplashScreen();
//        });
//    }
//
//    private static void showSplashScreen() {
//        // Create a splash screen JFrame
//        JFrame splashScreen = new JFrame("Company Logo");
//        splashScreen.setUndecorated(true); // Remove window decorations
//
//        // Create a JLabel for the company logo
//        JLabel logoLabel = new JLabel(new ImageIcon("company_logo.png")); // Replace with actual logo path
//        splashScreen.add(logoLabel, BorderLayout.CENTER);
//        splashScreen.setBackground(Color.red);
//
//        // Set splash screen size to match screen resolution
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        splashScreen.setSize(screenSize);
//
//        splashScreen.setAlwaysOnTop(true); // Ensure splash screen is always on top
//        splashScreen.setVisible(true);
//
//        // Schedule a task to close the splash screen after a delay
//        Timer timer = new Timer(SPLASH_SCREEN_DURATION, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                splashScreen.dispose(); // Close the splash screen
//                // Create and display the WebsiteInterface after the splash screen is closed
//                WebsiteInterface websiteInterface = new WebsiteInterface();
//                websiteInterface.setVisible(true);
//            }
//        });
//        timer.setRepeats(false); // Run the timer only once
//        timer.start();
//    }
//}
//
//
//package Project;
//
//        import javax.swing.*;
//        import javax.swing.border.EmptyBorder;
//        import java.awt.*;
//
//public class HomeScreen extends JFrame {
//
//
//    HomeScreen(){
//
//
////                   CREATING NAV PANEL
////        loading image logo
//        String projectRoot = System.getProperty("user.dir");
//        String imagePath = projectRoot + "/images/logo.png";
////        loading Image
//        ImageIcon loadImage = new ImageIcon(imagePath);
//        Image originalImage = loadImage.getImage();
//        Image scaledImage = originalImage.getScaledInstance(154, 64,Image.SCALE_SMOOTH);
//
//        JLabel imageLabel = new JLabel();
//        imageLabel.setIcon(new ImageIcon(scaledImage));
//        imageLabel.setVerticalAlignment(JLabel.CENTER);
//        imageLabel.setHorizontalAlignment(JLabel.CENTER);
////        imageLabel.setPreferredSize(new Dimension(152, 64));
//
//
////          Subscribe button
//        JPanel subscribePanel = new JPanel();
//        subscribePanel.setBackground(Color.red);
//        subscribePanel.setPreferredSize(new Dimension(200, 80));
//
////        book now button
//        JButton bookButton = new JButton("Book Now");
//        bookButton.setPreferredSize(new Dimension(157,50));
////        bookButton.setSize(new Dimension(157, 50));
//
//
//
////      creating nav panel
//        JPanel nav = new JPanel();
////       setting nav panel
//        nav.setBackground(Color.decode("#093a54"));
//        nav.setBorder(BorderFactory.createEmptyBorder(100, 100, 100,100));
//        nav.setPreferredSize(new Dimension(10343, 80));
//        nav.setLayout(new BorderLayout());
//        nav.add(subscribePanel, BorderLayout.WEST);
//        nav.add(imageLabel, BorderLayout.CENTER);
//        nav.add(bookButton, BorderLayout.EAST);
////      GETing screen size
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
//
//        subscribePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
//        imageLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
//        nav.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
//
//
//
//
////                  SETTING UP THE FRAME WINDOW
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLayout(new BorderLayout());
//        this.add(nav, BorderLayout.NORTH);
//        this.setSize(screenSize);
////        this.getContentPane().setBackground(new Color(147, 94, 234));
//        this.setVisible(true);
//
//    }
//
//}
//
//

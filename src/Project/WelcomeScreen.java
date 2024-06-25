package Project;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen {
    String projectRoot = System.getProperty("user.dir");
    String imagePath = projectRoot + "/images/logo.png";
    private static final int SPLASH_SCREEN_DURATION = 10000; // 10 seconds in milliseconds

    static JFrame frame = new JFrame();

    WelcomeScreen(){
//        Border border = BorderFactory.createLineBorder();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(imagePath));
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        frame.setTitle("Welcome Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(imageLabel);
        frame.setSize(screenSize);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(Color.decode("#093a54"));
        frame.setVisible(true);

        timer();


        
    }
    
    public static void timer(){
        Timer timer = new Timer(SPLASH_SCREEN_DURATION, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the splash screen
                // Create and display the WebsiteInterface after the splash screen is closed
                HomeScreen homeScreen = new HomeScreen();
                homeScreen.setVisible(true);
            }
        });
        timer.setRepeats(false); // Run the timer only once
        timer.start();
    }
    
}

package Lesson17;


import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public Dashboard() {
        setTitle("Dashboard Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Create the sidebar
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        // Create navigation buttons
        JButton homeButton = new JButton("Home");
        homeButton.setBorder(new MatteBorder(0,0,100,0, Color.black));
        JButton settingsButton = new JButton("Settings");
        JButton profileButton = new JButton("Profile");

        // Add buttons to the sidebar
        sidebar.add(homeButton);
        sidebar.add(settingsButton);
        sidebar.add(profileButton);

        // Create the main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create different panels for each section
        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("Home Screen"));
        JPanel settingsPanel = new JPanel();
        settingsPanel.add(new JLabel("Settings Screen"));
        JPanel profilePanel = new JPanel();
        profilePanel.add(new JLabel("Profile Screen"));

        // Add panels to the main panel
        mainPanel.add(homePanel, "Home");
        mainPanel.add(settingsPanel, "Settings");
        mainPanel.add(profilePanel, "Profile");

        // Add action listeners to buttons
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Home");
            }
        });

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Settings");
            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Profile");
            }
        });

        // Add sidebar and main panel to the frame
        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
}
package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import static Project.EmployeePage.getStatement;

public class LoginPage extends JPanel implements ActionListener {
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Constructor to setup the GUI
    public LoginPage() {
        setLayout(null);

        titleLabel = new JLabel("Login Page");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        titleLabel.setBounds(150, 10, 200, 30);
        add(titleLabel);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameLabel.setBounds(50, 50, 100, 20);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameField.setBounds(150, 50, 200, 20);
        add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordLabel.setBounds(50, 90, 100, 20);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setBounds(150, 90, 200, 20);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
        loginButton.setBounds(150, 130, 100, 30);
        loginButton.addActionListener(this);
        add(loginButton);
    }

    // Method to handle login button click
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getStatement().getConnection();
            String query = "SELECT * FROM EmployeesLoginPWD WHERE UserID = ? AND Password = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(this, "Login successful", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Close the current JFrame
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                topFrame.dispose();

                // Open the dashboard
                JFrame dashboardFrame = new JFrame("Dashboard");
                dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dashboardFrame.setSize(800, 600);
                dashboardFrame.add(new Dashboard()); // Ensure the Dashboard class is properly defined
                dashboardFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);

        LoginPage loginPage = new LoginPage();
        frame.add(loginPage);

        frame.setVisible(true);
    }

}

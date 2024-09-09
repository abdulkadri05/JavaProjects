package MainUserPage;  // Ensure this matches your actual package

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaSwing.SwingDataDisplay;  // Import the class from the correct package

public class AdminLoginPage {

    private static final String ADMIN_USERNAME = "admin";  // Replace with actual username
    private static final String ADMIN_PASSWORD = "password";  // Replace with actual password

    private JFrame frame;
    private JPanel cardPanel;

    public AdminLoginPage() {
        frame = new JFrame("Admin Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        cardPanel = new JPanel(new CardLayout());
        frame.add(cardPanel);

        createLoginPanel();
        createDataPanel();

        frame.setVisible(true);
    }

    private void createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
                    // Switch to the data panel
                    CardLayout cl = (CardLayout) (cardPanel.getLayout());
                    cl.show(cardPanel, "DataPanel");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cardPanel.add(loginPanel, "LoginPanel");
    }

    private void createDataPanel() {
        SwingDataDisplay dataDisplay = new SwingDataDisplay();
        JPanel dataPanel = dataDisplay.createPatientDataPanel();  // Use the updated method

        cardPanel.add(dataPanel, "DataPanel");
    }
}

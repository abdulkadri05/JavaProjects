package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaswing.SwingDataDisplay;
import java.util.HashMap;
import java.util.Map;

public class AdminHomePage {

    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private Map<String, JPanel> panels = new HashMap<>();

    public AdminHomePage() {
        frame = new JFrame("Admin Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        mainPanel = new JPanel(new CardLayout());
        cardLayout = (CardLayout) mainPanel.getLayout();

        // Create sidebar
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(0, 1)); // Vertical layout for buttons
        sidebar.setPreferredSize(new Dimension(200, frame.getHeight()));

        JButton homeButton = new JButton("Home");
        JButton viewPatientsButton = new JButton("View Patients");
        JButton orderManagementButton = new JButton("Order Management");
        JButton reportsButton = new JButton("Reports");
        JButton settingsButton = new JButton("Settings");

        sidebar.add(homeButton);
        sidebar.add(viewPatientsButton);
        sidebar.add(orderManagementButton);
        sidebar.add(reportsButton);
        sidebar.add(settingsButton);

        // Add action listeners for buttons
        homeButton.addActionListener(e -> showPanel("HomePanel"));
        viewPatientsButton.addActionListener(e -> showPanel("ViewPatientsPanel"));
        orderManagementButton.addActionListener(e -> showPanel("OrderManagementPanel"));
        reportsButton.addActionListener(e -> showPanel("ReportsPanel"));
        settingsButton.addActionListener(e -> showPanel("SettingsPanel"));

        // Create panels for each section
        JPanel homePanel = createHomePanel();
        JPanel viewPatientsPanel = new SwingDataDisplay().createPatientDataPanel();
        JPanel orderManagementPanel = createOrderManagementPanel();
        JPanel reportsPanel = createReportsPanel();
        JPanel settingsPanel = createSettingsPanel();

        panels.put("HomePanel", homePanel);
        panels.put("ViewPatientsPanel", viewPatientsPanel);
        panels.put("OrderManagementPanel", orderManagementPanel);
        panels.put("ReportsPanel", reportsPanel);
        panels.put("SettingsPanel", settingsPanel);

        // Add sidebar and main panel to the frame
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);

        // Add panels to mainPanel
        for (Map.Entry<String, JPanel> entry : panels.entrySet()) {
            mainPanel.add(entry.getValue(), entry.getKey());
        }

        // Show the home panel by default
        showPanel("HomePanel");

        frame.setVisible(true);
    }

    private void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    private JPanel createHomePanel() {
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());

        // Define buttons or other components here
        homePanel.add(new JLabel("Admin Home Page with buttons", SwingConstants.CENTER), BorderLayout.CENTER);

        return homePanel;
    }

    private JPanel createOrderManagementPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Order Management Section"));
        return panel;
    }

    private JPanel createReportsPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Reports Section"));
        return panel;
    }

    private JPanel createSettingsPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Settings Section"));
        return panel;
    }

    public JFrame getFrame() {
        return frame; // Return the JFrame instance
    }

    public JPanel getMainPanel() {
        return mainPanel; // This should be your main JPanel containing all sections
    }
}

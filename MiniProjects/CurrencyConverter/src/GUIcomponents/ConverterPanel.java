package GUIcomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BusinessLogic.CurrencyConverter;

public class ConverterPanel extends JPanel {
    private JTextField amountField;
    private JComboBox<String> fromCurrencyCombo;
    private JComboBox<String> toCurrencyCombo;
    private JLabel resultLabel;
    private JButton convertButton;

    public ConverterPanel() {
        // Set the layout to GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        gbc.anchor = GridBagConstraints.CENTER; // Center components

        // Initialize components
        amountField = new JTextField(15);
        fromCurrencyCombo = new JComboBox<>(new String[]{"USD", "EUR", "JPY"});
        toCurrencyCombo = new JComboBox<>(new String[]{"USD", "EUR", "JPY"});
        resultLabel = new JLabel("Result: ");
        convertButton = new JButton("Convert");

        // Apply some styling
        amountField.setFont(new Font("Arial", Font.PLAIN, 14));
        amountField.setBackground(Color.WHITE);
        amountField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        fromCurrencyCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        toCurrencyCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        convertButton.setFont(new Font("Arial", Font.BOLD, 14));
        convertButton.setBackground(Color.LIGHT_GRAY);
        convertButton.setBorder(BorderFactory.createRaisedBevelBorder());

        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Add components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Amount:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("From Currency:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(fromCurrencyCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("To Currency:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(toCurrencyCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(convertButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(resultLabel, gbc);

        // Set up the action for the button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        try {
            // Use the CurrencyConverter class to perform conversion
            double amount = Double.parseDouble(amountField.getText());
            String fromCurrency = (String) fromCurrencyCombo.getSelectedItem();
            String toCurrency = (String) toCurrencyCombo.getSelectedItem();
            assert fromCurrency != null;
            double result = CurrencyConverter.convert(amount, fromCurrency, toCurrency);
            resultLabel.setText("Result: " + result);
        } catch (Exception ex) {
            resultLabel.setText("Error: " + ex.getMessage());
        }
    }
}

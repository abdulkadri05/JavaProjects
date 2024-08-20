package GUIcomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BusinessLogic.GameLogic;

public class JPanelFile extends JPanel {

    private JTextField field;
    private JLabel resultLabel;
    private GameLogic gameLogic;

    public JPanelFile() {
        // Initialize GameLogic with the number of tries (e.g., 3)
        gameLogic = new GameLogic(3);

        // Set the layout manager to GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Configure GridBagConstraints for the JTextField
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Create and add the JTextField
        field = new JTextField(20);
        add(field, gbc);

        // Configure GridBagConstraints for the JButton
        gbc.gridy = 1; // Move to the next row
        JButton button = new JButton("Guess");
        add(button, gbc);

        // Configure GridBagConstraints for the JLabel
        gbc.gridy = 2; // Move to the next row
        resultLabel = new JLabel(""); // Initially empty
        add(resultLabel, gbc);

        // Create an ActionListener and attach it to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Retrieve the text from the JTextField and convert it to an int
                    int userInput = Integer.parseInt(field.getText());

                    // Process the input with GameLogic and get the result
                    String resultMessage = gameLogic.processGuess(userInput);

                    // Display the result in the JLabel
                    resultLabel.setText(resultMessage);

                    // Check if the game is over
                    if (gameLogic.isGameOver()) {
                        resultLabel.setText(resultMessage + " " + gameLogic.getGameStatus());
                        button.setEnabled(false); // Disable the button after game over
                    }

                } catch (NumberFormatException ex) {
                    // Handle the case where the input is not a valid integer
                    resultLabel.setText("Please enter a valid number.");
                }
            }
        });
    }
}

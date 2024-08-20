package GUIcomponents;

import javax.swing.*;

public class JFrameFile extends JFrame {

    public JFrameFile() {
        // Set up the frame
        setTitle("Number Guessing Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create and add components
        JLabel label = new JLabel("Welcome to the Number Guessing Game!");
        add(label); // Add the label to the frame

        // Add an instance of JPanelFile
        JPanelFile panel = new JPanelFile();
        add(panel);

        // Make the frame visible
        setVisible(true);
    }
}

package GUIcomponents;

import javax.swing.JFrame;
import GUIcomponents.ConverterPanel;

public class ConverterFrame extends JFrame {
    public ConverterFrame() {
        // Set up the frame
        setTitle("Currency Converter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the main panel
        add(new ConverterPanel());

        // Make the frame visible
        setVisible(true);
    }
}

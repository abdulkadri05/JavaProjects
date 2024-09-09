import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.concurrent.ThreadLocalRandom;

public class clicker {
    private static boolean clicking = true;
    private static int amountClicked = 0;
    private static int rate = 0;
    private static int targetClicks = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Autoclicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(5, 1));

        // Input for number of clicks
        JLabel clickLabel = new JLabel("Number of clicks:");
        JTextField clickField = new JTextField();
        frame.add(clickLabel);
        frame.add(clickField);

        // Input for speed
        JLabel speedLabel = new JLabel("Max speed (in milliseconds):");
        JTextField speedField = new JTextField();
        frame.add(speedLabel);
        frame.add(speedField);

        // Start button
        JButton startButton = new JButton("Start Autoclicker");
        frame.add(startButton);

        // Click counter label
        JLabel clickCounterLabel = new JLabel("Clicks: 0");
        frame.add(clickCounterLabel);

        // Start button action
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    targetClicks = Integer.parseInt(clickField.getText());
                    rate = Integer.parseInt(speedField.getText());

                    if (targetClicks < 1) {
                        JOptionPane.showMessageDialog(frame, "Must be at least 1 click.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (rate < 100) {
                        JOptionPane.showMessageDialog(frame, "Max speed must be at least 500 milliseconds.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Start autoclicker in a new thread
                    new Thread(() -> startAutoclicker(targetClicks, rate, clickCounterLabel)).start();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void startAutoclicker(int targetClicks, int rate, JLabel clickCounterLabel) {
        try {
            clicking = true;
            amountClicked = 0;
            System.out.println("Autoclicker started! Please move your mouse to stop it.");
            System.out.println("---  Sleeping for 5 seconds   ---");

            Thread.sleep(5000); // Give the user time to position the mouse

            Point initialPosition = MouseInfo.getPointerInfo().getLocation();
            Robot robot = new Robot();

            while (clicking && amountClicked < targetClicks) {
                Point currentPosition = MouseInfo.getPointerInfo().getLocation();

                // Stop if the mouse has moved
                if (Math.round(currentPosition.getX() + currentPosition.getY()) != Math.round(initialPosition.getX() + initialPosition.getY())) {
                    System.out.println("Mouse moved! Stopping the autoclicker.");
                    clicking = false;
                    break;
                }

                // Random delay between clicks
                int randomDelay;
                if (rate > 15000) {
                    randomDelay = ThreadLocalRandom.current().nextInt(15000, rate + 1);
                } else {
                    randomDelay = ThreadLocalRandom.current().nextInt(100, rate + 1);
                }

                Thread.sleep(randomDelay);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                amountClicked++;

                // Update click counter in the GUI
                SwingUtilities.invokeLater(() -> clickCounterLabel.setText("Clicks: " + amountClicked));

                if (amountClicked >= targetClicks) {
                    clicking = false;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

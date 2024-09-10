package javaswing;  // Make sure this matches your actual directory structure

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import database.Patient;
import database.PatientDAO;
import java.util.List;

public class SwingDataDisplay {

    public JPanel createPatientDataPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[]{"ID", "Name", "Age", "Diagnosis"}, 0);

        JTable table = new JTable(tableModel);
        populateTable(tableModel); // Populate the table with existing data

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel for adding/removing a patient
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10)); // Added space for two buttons
        JTextField nameField = new JTextField(10);
        JTextField ageField = new JTextField(10);
        JTextField diagnosisField = new JTextField(10);
        JButton addButton = new JButton("Add Patient");
        JButton removeButton = new JButton("Remove Patient");

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Diagnosis:"));
        inputPanel.add(diagnosisField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        panel.add(inputPanel, BorderLayout.SOUTH);

        // ActionListener for Add Patient button
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String ageText = ageField.getText();
            String diagnosis = diagnosisField.getText();

            try {
                int age = Integer.parseInt(ageText); // Parse the age to an integer

                // Create a new patient object
                Patient newPatient = new Patient(0, name, age, diagnosis);

                // Add the patient using PatientDAO
                PatientDAO patientDAO = new PatientDAO();
                patientDAO.addPatient(newPatient);

                // Clear the table and reload data
                tableModel.setRowCount(0);
                populateTable(tableModel);

                // Clear input fields
                nameField.setText("");
                ageField.setText("");
                diagnosisField.setText("");

            } catch (NumberFormatException ex) {
                // Show error if age is not a valid number
                JOptionPane.showMessageDialog(panel, "Please enter a valid age", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // ActionListener for Remove Patient button
        removeButton.addActionListener(e -> {
            String idText = JOptionPane.showInputDialog(panel, "Enter Patient ID to Remove:");

            try {
                int id = Integer.parseInt(idText); // Parse the ID to an integer

                // Remove the patient using PatientDAO
                PatientDAO patientDAO = new PatientDAO();
                patientDAO.removePatient(id);

                // Clear the table and reload data
                tableModel.setRowCount(0);
                populateTable(tableModel);

            } catch (NumberFormatException ex) {
                // Show error if ID is not a valid number
                JOptionPane.showMessageDialog(panel, "Please enter a valid ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        return panel;
    }

    // Method to populate the table with patient data
    private void populateTable(DefaultTableModel tableModel) {
        PatientDAO patientDAO = new PatientDAO();
        List<Patient> patients = patientDAO.getAllPatients();

        // Add each patient to the table
        for (Patient patient : patients) {
            tableModel.addRow(new Object[]{patient.getId(), patient.getName(), patient.getAge(), patient.getDiagnosis()});
        }
    }
}

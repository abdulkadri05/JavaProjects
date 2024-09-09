package javaSwing;  // Ensure this matches the package used in the import statement

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import database.Patient;
import database.PatientDAO;

public class SwingDataDisplay {

    public JPanel createPatientDataPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[]{"ID", "Name", "Age", "Diagnosis"}, 0);

        JTable table = new JTable(tableModel);

        PatientDAO patientDAO = new PatientDAO();
        List<Patient> patients = patientDAO.getAllPatients();

        for (Patient patient : patients) {
            tableModel.addRow(new Object[]{patient.getId(), patient.getName(), patient.getAge(), patient.getDiagnosis()});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }
}

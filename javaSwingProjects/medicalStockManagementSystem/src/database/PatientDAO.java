package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    // Update with your database connection details
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/hospital";
        String user = "root";
        String password = ""; // Update with your actual password
        return DriverManager.getConnection(url, user, password);
    }

    public void removePatient(int id) {
        String query = "DELETE FROM patients WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // A function to add a patient
    public void addPatient(Patient patient) {
        String query = "INSERT INTO patients (name, age, diagnosis) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setString(3, patient.getDiagnosis());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get all patients
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patients";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String diagnosis = rs.getString("diagnosis");
                Patient patient = new Patient(id, name, age, diagnosis);
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }
}

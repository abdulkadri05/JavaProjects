package utils;

import database.Patient;
import database.PatientDAO;

public class PatientUtils {

    public static void addPatient(String name, int age, String diagnosis) {
        // Create a PatientDAO instance
        PatientDAO patientDAO = new PatientDAO();

        // Create a Patient object with id 0 since it will be auto-generated
        Patient patient = new Patient(0, name, age, diagnosis);

        // Call the DAO method to add the patient
        patientDAO.addPatient(patient);
    }
}

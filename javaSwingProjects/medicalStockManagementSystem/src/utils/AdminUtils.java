package utils;

import database.Patient;
import database.PatientDAO;

public class AdminUtils {

    public static void addPatient(String name, int age, String diagnosis) {
        PatientDAO patientDAO = new PatientDAO();
        Patient patient = new Patient(0, name, age, diagnosis);
        patientDAO.addPatient(patient);
    }
}

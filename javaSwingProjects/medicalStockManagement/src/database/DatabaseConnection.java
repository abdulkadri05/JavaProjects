package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/hospital";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Ryzenpro5$$";

    public static Connection getConnection() throws SQLException {
        // Load the JDBC driver class (optional)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }

        // Establish and return the connection
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}

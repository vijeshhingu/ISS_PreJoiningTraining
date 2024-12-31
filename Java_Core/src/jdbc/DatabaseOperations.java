package jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DatabaseOperations {
    private static final Logger logger = LogManager.getLogger(DatabaseOperations.class);

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            logger.info("Connected to the database.");

            String query = "SELECT * FROM employees";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    logger.info("Employee ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
                }
            }
        } catch (SQLException e) {
            logger.error("Database error: " + e.getMessage());
        }
    }
}

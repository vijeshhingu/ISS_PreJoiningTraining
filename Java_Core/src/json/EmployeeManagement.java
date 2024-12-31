package json;

import org.apache.logging.log4j.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class EmployeeManagement {
    private static final Logger logger = LogManager.getLogger(EmployeeManagement.class);

    public static void main(String[] args) {
        String filePath = "src/json/employees.json";

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray employees = new JSONArray(content);

            for (int i = 0; i < employees.length(); i++) {
                JSONObject employee = employees.getJSONObject(i);
                logger.info("Employee: " + employee.getString("name") + ", Age: " + employee.getInt("age"));
            }
        } catch (Exception e) {
            logger.error("Error reading JSON file: " + e.getMessage());
        }
    }
}

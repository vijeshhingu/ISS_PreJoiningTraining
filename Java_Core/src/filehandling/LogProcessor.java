package filehandling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class LogProcessor {
    private static final Logger logger = LogManager.getLogger(LogProcessor.class);

    public static void main(String[] args) {
        String inputPath = "src/filehandling/input.log";
        String outputPath = "src/filehandling/output.log";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            logger.info("File copied successfully.");
        } catch (IOException e) {
            logger.error("File operation failed: " + e.getMessage());
        }
    }
}

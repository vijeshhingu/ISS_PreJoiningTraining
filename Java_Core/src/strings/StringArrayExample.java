package strings;

import org.apache.logging.log4j.*;

public class StringArrayExample {
    private static final Logger logger = LogManager.getLogger(StringArrayExample.class);

    public static void main(String[] args) {
        String name = "Hello, World!";
        logger.info(name.toUpperCase());  // Using String method

        String[] students = {"Alice", "Bob", "Charlie"};
        for (String student : students) {
            logger.info(student);
        }
    }
}

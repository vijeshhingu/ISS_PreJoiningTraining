package loops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberChecker {
    private static final Logger logger = LogManager.getLogger(NumberChecker.class);

    public static void main(String[] args) {
        int number = 10;

        if (number % 2 == 0) {
            logger.info(number + " is even");
        } else {
            logger.info(number + " is odd");
        }
        for (int i = 0; i < 5; i++) {
            logger.info("Counting: " + i);
        }
    }
}

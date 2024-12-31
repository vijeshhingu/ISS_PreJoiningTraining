package exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        BankAccount account = new BankAccount(12345, 5000);

        logger.info("Account Number: " + account.getAccountNumber());
        logger.info("Initial Balance: " + account.getBalance());

        account.deposit(1000);

        try {
            account.withdraw(7000); // This will throw an exception
        } catch (InvalidAccountsException e) {
            logger.error("Error: " + e.getMessage());
        }

        try {
            account.withdraw(2000);
        } catch (InvalidAccountsException e) {
            logger.error("Error: " + e.getMessage());
        }
    }
}

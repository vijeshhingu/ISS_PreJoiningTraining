package exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccount {
    private static final Logger logger = LogManager.getLogger(BankAccount.class);

    private int accountNumber;
    private double balance;

    // Constructor
    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Encapsulation: Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            logger.warn("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        logger.info("Deposited: " + amount + ", New Balance: " + balance);
    }

    // Method to withdraw money
    public void withdraw(double amount) throws InvalidAccountsException {
        if (amount <= 0) {
            throw new InvalidAccountsException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new InvalidAccountsException("Insufficient balance.");
        }
        balance -= amount;
        logger.info("Withdrew: " + amount + ", Remaining Balance: " + balance);
    }
}

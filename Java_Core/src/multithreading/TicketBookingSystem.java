package multithreading;

import org.apache.logging.log4j.*;
import java.util.concurrent.*;

public class TicketBookingSystem {
    private static final Logger logger = LogManager.getLogger(TicketBookingSystem.class);
    private volatile int availableTickets = 10;

    // Synchronized method to ensure thread safety
    public synchronized void bookTicket(String customerName) {
        if (availableTickets > 0) {
            logger.info(customerName + " successfully booked a ticket. Remaining tickets: " + (--availableTickets));
        } else {
            logger.warn("No tickets available for " + customerName);
        }
    }

    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();

        Runnable bookingTask = () -> {
            String threadName = Thread.currentThread().getName();
            system.bookTicket(threadName);
        };

        // Using a thread pool executor
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 15; i++) {
            executorService.execute(bookingTask);
        }

        executorService.shutdown();
    }
}

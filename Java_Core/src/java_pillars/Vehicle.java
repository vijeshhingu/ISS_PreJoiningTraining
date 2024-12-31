package java_pillars;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Abstract class
public abstract class Vehicle {
    private static final Logger logger = LogManager.getLogger(Vehicle.class);
    private String name;
    private int speed;

    // Constructor
    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    // Encapsulation: Getters and Setters
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Abstract method
    public abstract void start();

    // Concrete method
    public void stop() {
        logger.info(name + " has stopped.");
    }
}

package java_pillars;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Inheriting from Vehicle
public class Car extends Vehicle {
    private static final Logger logger = LogManager.getLogger(Car.class);
    private int numberOfDoors;

    public Car(String name, int speed, int numberOfDoors) {
        super(name, speed);
        this.numberOfDoors = numberOfDoors;
    }

    // Overriding abstract method
    @Override
    public void start() {
        logger.info("Car " + getName() + " is starting at speed " + getSpeed() + " km/h.");
    }

    public void displayDetails() {
        logger.info("Car Name: " + getName() + ", Speed: " + getSpeed() + " km/h, Doors: " + numberOfDoors);
    }
}

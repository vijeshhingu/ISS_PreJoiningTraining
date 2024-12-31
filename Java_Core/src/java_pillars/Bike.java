package java_pillars;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bike extends Vehicle {
    private static final Logger logger = LogManager.getLogger(Bike.class);

    public Bike(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void start() {
        logger.info("Bike " + getName() + " is starting at speed " + getSpeed() + " km/h.");
    }
}

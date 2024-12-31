package java_pillars;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceCentre implements VehicleService {
    private static final Logger logger = LogManager.getLogger(ServiceCentre.class);

    @Override
    public void performService() {
        logger.info("Vehicle service is being performed.");
    }
}

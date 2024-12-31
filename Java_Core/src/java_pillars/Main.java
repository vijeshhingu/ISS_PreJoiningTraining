package java_pillars;

public class Main {

    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", 120, 4); // Polymorphism
        Vehicle bike = new Bike("Harley", 80);  // Polymorphism

        car.start();
        car.stop();

        bike.start();
        bike.stop();

        ((Car) car).displayDetails();  // Downcasting

        // Using the interface
        ServiceCentre serviceCenter = new ServiceCentre();
        serviceCenter.performService();
    }
}

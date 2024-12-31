package basics2;

import org.apache.logging.log4j.*;

public class Employee {
    private static final Logger logger = LogManager.getLogger(Employee.class);
    private final int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void displayDetails() {
        logger.info("Employee ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }

    public static void main(String[] args) {
        Employee employee = new Employee(1, "John Doe", 50000);
        employee.displayDetails();
    }
}

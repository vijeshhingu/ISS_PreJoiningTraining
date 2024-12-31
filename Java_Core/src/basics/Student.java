package basics;

import org.apache.logging.log4j.*;

public class Student {
    private static final Logger logger = LogManager.getLogger(Student.class);

    private String studentName;
    private int studentAge;

    public Student(String studentName, int studentAge) {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public void displayStudentDetails() {
        logger.info("Student Name: " + studentName + ", Age: " + studentAge);
    }
}
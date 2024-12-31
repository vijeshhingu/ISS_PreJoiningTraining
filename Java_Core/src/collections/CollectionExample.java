package collections;

import org.apache.logging.log4j.*;
import java.util.*;

public class CollectionExample {
    private static final Logger logger = LogManager.getLogger(CollectionExample.class);

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Alice"));
        studentList.add(new Student(2, "Bob"));

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student(1, "Alice"));
        studentSet.add(new Student(3, "Charlie"));

        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, new Student(1, "Alice"));
        studentMap.put(2, new Student(2, "Bob"));

        studentList.forEach(student -> logger.info(student));
        studentSet.forEach(student -> logger.info(student));
        studentMap.forEach((key, value) -> logger.info(key + ": " + value));
    }
}

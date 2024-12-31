package xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

import java.io.File;

public class StudentRecords {
    private static final Logger logger = LogManager.getLogger(StudentRecords.class);

    public static void main(String[] args) {
        String filePath = "src/xml/student.xml";

        try {
            File file = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            NodeList studentList = doc.getElementsByTagName("student");

            for (int i = 0; i < studentList.getLength(); i++) {
                Node node = studentList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    logger.info("Student Name: " + element.getElementsByTagName("name").item(0).getTextContent());
                    logger.info("Age: " + element.getElementsByTagName("age").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            logger.error("Error processing XML file: " + e.getMessage());
        }
    }
}

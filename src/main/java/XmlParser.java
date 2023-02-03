import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {
    private List<Employee> staff = new ArrayList<>();

    public List<Employee> parseXML(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));
            Node root = doc.getDocumentElement();
            root.normalize();
            read(root);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return staff;
    }

    private void read(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) currentNode;
                var text = element.getTextContent();
                var elems = text.split("\\n");
                var id = elems[1].trim();
                var firstName = elems[2].trim();
                var lastName = elems[3].trim();
                var country = elems[4].trim();
                var age = elems[5].trim();
                staff.add(new Employee(Long.parseLong(id), firstName, lastName, country, Integer.parseInt(age)));
            }
        }
    }
}

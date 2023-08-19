import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ParseXML {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("patient_data.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            NodeList nodeList = document.getElementsByTagName("patient");

            StringBuilder htmlTable = new StringBuilder();
            htmlTable.append("<table border='1'>");
            htmlTable.append("<tr><th>Name</th><th>Age</th><th>Symptoms</th></tr>");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String age = element.getElementsByTagName("age").item(0).getTextContent();
                    String symptoms = element.getElementsByTagName("symptoms").item(0).getTextContent();

                    htmlTable.append("<tr><td>").append(name).append("</td><td>").append(age).append("</td><td>")
                            .append(symptoms).append("</td></tr>");
                }
            }

            htmlTable.append("</table>");

            writeHtmlTableToFile(htmlTable.toString(), "patient_table.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeHtmlTableToFile(String tableContent, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<style>");
            writer.println("</style>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println(tableContent);
            writer.println("</body>");
            writer.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

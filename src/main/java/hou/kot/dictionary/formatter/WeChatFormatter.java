package hou.kot.dictionary.formatter;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Render display for wechat client
 */
@Service
public class WeChatFormatter implements Formatter{

    private DocumentBuilder dBuilder ;

    static WeChatFormatter formatter;

    public static WeChatFormatter getInstance() {
        if (formatter != null) return formatter;
        formatter = new WeChatFormatter();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            formatter.dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            // TODO: contact system administrator
        }

        return formatter;
    }

    private WeChatFormatter(){}

    public String format(String original) {
        String result = "";
        try {

            ByteArrayInputStream bis = new ByteArrayInputStream(original.getBytes("UTF-8"));
            Document doc = dBuilder.parse(bis);
            doc.getDocumentElement().normalize();
            NodeList nl = doc.getElementsByTagName("li");
            List<Node> nodeList = new ArrayList<Node>();
            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                if (i != 0) {
                    result += "\n" + node.getTextContent();
                } else {
                    result = node.getTextContent();
                }
            }
        } catch (
                SAXException e) {
            // send alert to server admin
            e.printStackTrace();
        } catch (
                IOException e) {
            // send alert to server admin
            e.printStackTrace();
        }

        return result;
    }

    public DocumentBuilder getdBuilder() {
        return dBuilder;
    }

    public void setdBuilder(DocumentBuilder dBuilder) {
        this.dBuilder = dBuilder;
    }
}

package DAO;

import application.entity.Reciept;
import application.entity.Customer;
import application.entity.impl.Entity;
import application.entity.impl.Factory;
import application.storage.impl.Storage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ParseFile {
    /**
     * Метод чтения xml-файла в репозиторий {@link Storage}
     * @param factory1 - фабрика, которую необходимо использовать
     * @param fileS - название файла, откуда читать информацию*/
    public static void parse(Factory factory1, String fileS)
    {
        String path = "./src/dataBase/"+fileS+".xml";
        File file = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try
        {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName(fileS);
            for (int i = 0; i < nodeList.getLength(); i++) {
                getEntity(nodeList.item(i), factory1, fileS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void getEntity(Node node, Factory factory, String fileS) throws Exception {
        String []args;
        String []props;
        if(fileS.equals("Person")) {
            props = Customer.CustomerProperties;
        }
        else
        {
            props = Reciept.properties;
        }
        Entity person = null;
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            args = new String[props.length];
            for (int i = 0; i < props.length; i++) {
                args[i]=getTagValue(props[i], element);
            }
            try {
                person = factory.create(true, args);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}

package DAO;

import application.entity.Check;
import application.entity.Customer;
import application.entity.impl.Entity;
import application.storage.PersonStorage;
import application.storage.impl.Storage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ParseCustomer {
    public static void parse(Storage storage, String file)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            // создаем пустой объект Document, в котором будем
            // создавать наш xml-файл
            Document doc = builder.newDocument();
            // создаем корневой элемент
            Element rootElement =
                    doc.createElementNS("?", file+"s");
            doc.appendChild(rootElement);
            for (int i = 0; i < storage.size() ; i++) {
                rootElement.appendChild(getEntity(doc, storage.get(i), file));
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult file1 = new StreamResult(new File("./src/dataBase/"+file+".xml"));
            transformer.transform(source, file1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // метод для создания нового узла XML-файла
    private static Node getEntity(Document doc, Entity person, String file) {
        Element node = doc.createElement(file);
        String[] propNames = Customer.CustomerProperties;
        String[] props = person.getProps();
        if(!file.equals("Person"))
        {
            propNames = Check.properties;
        }
        for (int i = 0; i < propNames.length; i++) {
            node.appendChild(getEntityElements(doc, node, propNames[i], props[i]));
        }
        return node;
    }
    private static Node getEntityElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}

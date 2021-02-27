package Homework_XML.Parser.Dom;

import Homework_XML.customer.Customer;
import Homework_XML.Parser.I_Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements I_Parser {

    @Override
    public List<Customer> parser(String place) {
        ArrayList<Customer> list = new ArrayList<>();
        DocumentBuilderFactory docbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        Document document=null;
        {
                try {
                    documentBuilder=docbf.newDocumentBuilder();
                    document = documentBuilder.parse(new File(place));
                    document.getDocumentElement().normalize();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
        NodeList customers= document.getElementsByTagName("customer");
        for (int i=0; i< customers.getLength(); i++){
            Node customer = customers.item(i);
            if(customer.getNodeType()==Node.ELEMENT_NODE){
                Element element=(Element) customer;
                String name=element.getAttribute("name");
                String lastname = element.getAttribute("lastname");
                Integer age =Integer.parseInt(element.getAttribute("age"));
            list.add(new Customer(name,lastname,age));
            }
        }
        return list;
    }
}

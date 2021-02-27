package Homework_XML.Parser.Sax;

import Homework_XML.customer.Customer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CustomerHandler extends DefaultHandler {
    private List<Customer> customerList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("customer")) {
            String name = attributes.getValue("name");
            String lastname = attributes.getValue("lastname");
            int age = Integer.parseInt(attributes.getValue("age"));
            customerList.add(new Customer(name, lastname, age));
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Обработка начата.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Обработка завершена.");
    }

    public List<Customer> getCustomerList() {
        return customerList;


    }
}


package Homework_XML;

import Homework_XML.Parser.Dom.DomParser;
import Homework_XML.Parser.Sax.SaxParser;
import Homework_XML.customer.Customer;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DomParser domParser=new DomParser();
        System.out.println("Dom: ");

        List<Customer> list1= domParser.parser("Customers.xml");

        list1.stream().forEach(customer -> System.out.println("Name: " +customer.getName() +", Lastname: "
            + customer.getLastname()+ ", age: " +customer.getAge()));

        System.out.println(" ");
        System.out.println("SAX: ");

        SaxParser saxParser = new SaxParser();

        List<Customer> list2 = saxParser.parser("Customers.xml");

        list2.stream().forEach((customer -> System.out.println("Name: " + customer.getName() + ", Lastname: "
                + customer.getLastname() + ", age: " + customer.getAge())));
    }
}

package by.epam.home.parser.sax;

import by.epam.home.entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {

    private CargoService cargoService;
    private Customer customer;
    private Driver driver;
    private Weight weight;
    private Price price;
    private Order order;
    private Car car;
    private LiftCapacity liftCapacity;
    private List<Customer> customers = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();
    private String content;

    public CargoService getCargoService() {
        return cargoService;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started!");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "cargo-service":
                cargoService = new CargoService();
                break;
            case "customer":
                customer = new Customer();
                customer.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "order":
                order = new Order();
                order.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "weight":
                weight = new Weight();
                weight.setUnit(attributes.getValue("unit"));
                break;
            case "price":
                price = new Price();
                price.setCurrency(attributes.getValue("currency"));
                break;
            case "driver":
                driver = new Driver();
                driver.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "car":
                car = new Car();
                car.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "liftCapacity":
                liftCapacity = new LiftCapacity();
                liftCapacity.setUnit(attributes.getValue("unit"));
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.copyValueOf(ch, start, length ).trim();

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "customerFirstName":
                customer.setCustomerFirstName(content);
                break;
            case "customerLastName":
                customer.setCustomerLastName(content);
                break;
            case "phone":
                customer.setPhone(content);
                break;
            case "order":
                customer.setOrder(order);
                break;
            case "name":
                order.setName(content);
                break;
            case "value":
                weight.setValue(Integer.parseInt(content));
                break;
            case "weight":
                order.setWeight(weight);
                break;
            case "from":
                order.setFrom(content);
                break;
            case "to":
                order.setTo(content);
                break;
            case "amount":
                price.setAmount(Integer.parseInt(content));
                break;
            case "price":
                order.setPrice(price);
                break;
            case "customer":
                customers.add(customer);
                break;
            case "driverFirstName":
                driver.setDriverFirstName(content);
                break;
            case "driverLastName":
                driver.setDriverLastName(content);
                break;
            case "driverPhone":
                driver.setDriverPhone(content);
                break;
            case "brand":
                car.setBrand(content);
                break;
            case "model":
                car.setModel(content);
                break;
            case "capacity":
                liftCapacity.setCapacity(Integer.parseInt(content));
                break;
            case "liftCapacity":
                car.setLiftCapacity(liftCapacity);
                break;
            case "yearOfIssue":
                car.setYearOfIssue(Integer.parseInt(content));
                break;
            case "car":
                driver.setCar(car);
                break;
            case "driver":
                drivers.add(driver);
                break;
            case "cargo-service":
                cargoService.setCustomers(customers);
                cargoService.setDrivers(drivers);
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing ended!");
    }
}

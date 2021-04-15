package by.epam.home.parser.dom;

import by.epam.home.entity.*;
import by.epam.home.parser.XMLParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class DomPars extends XMLParser {
    private CargoService cargoService = new CargoService();

    @Override
    public CargoService getCargoService(String pathToSourceFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(pathToSourceFile);
        List<Customer> customersFromDocument = (List<Customer>) getCustomersFromDocument(document);
        List<Driver> driversFromDocument = (List<Driver>) getDriversFromDocument(document);
        cargoService.setCustomers(customersFromDocument);
        cargoService.setDrivers(driversFromDocument);
        return cargoService;
    }

    public List<Customer> getCustomersFromDocument(Document document) {
        List<Customer> customers = new ArrayList<>();
        NodeList customersNodeList = document.getElementsByTagName("customer");
        for (int i = 0; i < customersNodeList.getLength(); i++) {
            Node customerNode = customersNodeList.item(i);
            if (customerNode.getNodeType() == Node.ELEMENT_NODE) {
                Customer customer = new Customer();
                Element element = ((Element) customerNode);
                String customerId = element.getAttribute("id");
                customer.setId(Integer.parseInt(customerId));

                String customerFirstName = element.getElementsByTagName("customerFirstName").item(0).getTextContent();
                String customerLastName = element.getElementsByTagName("customerLastName").item(0).getTextContent();
                String phone = element.getElementsByTagName("phone").item(0).getTextContent();
                customer.setCustomerFirstName(customerFirstName);
                customer.setCustomerLastName(customerLastName);
                customer.setPhone(phone);

                NodeList orderNodeList = element.getElementsByTagName("order");
                for (int j = 0; j < orderNodeList.getLength(); j++) {
                    Node orderNode = orderNodeList.item(j);
                    if(orderNode.getNodeType() == Node.ELEMENT_NODE) {
                        Order order = new Order();
                        Element orderElement = ((Element) orderNode);
                        String orderId = orderElement.getAttribute("id");
                        order.setId(Integer.parseInt(orderId));

                        String name = orderElement.getElementsByTagName("name").item(0).getTextContent();
                        String from = orderElement.getElementsByTagName("from").item(0).getTextContent();
                        String to = orderElement.getElementsByTagName("to").item(0).getTextContent();
                        order.setFrom(from);
                        order.setName(name);
                        order.setTo(to);

                        NodeList weightNodeList = orderElement.getElementsByTagName("weight");
                        for (int k = 0; k < weightNodeList.getLength(); k++) {
                            Node weightNode = weightNodeList.item(k);
                            if (weightNode.getNodeType() == Node.ELEMENT_NODE) {
                                Weight weight = new Weight();
                                Element weightElement = ((Element) weightNode);
                                String unit = weightElement.getAttribute("unit");
                                String value = weightElement.getElementsByTagName("value").item(0).getTextContent();
                                weight.setUnit(unit);
                                weight.setValue(Integer.parseInt(value));
                                order.setWeight(weight);
                            }

                        }
                        NodeList priceNodeList = orderElement.getElementsByTagName("price");
                        for (int k = 0; k < priceNodeList.getLength(); k++) {
                            Node priceNode = priceNodeList.item(k);
                            if (priceNode.getNodeType() == Node.ELEMENT_NODE) {
                                Price price = new Price();
                                Element priceElement = ((Element) priceNode);
                                String currency = priceElement.getAttribute("currency");
                                String amount = priceElement.getElementsByTagName("amount").item(0).getTextContent();
                                price.setCurrency(currency);
                                price.setAmount(Integer.parseInt(amount));
                                order.setPrice(price);
                            }
                        }
                        customer.setOrder(order);
                    }
                }
                customers.add(customer);
            }
        }
        return customers;
    }

    public List<Driver> getDriversFromDocument(Document document) {
        List<Driver> drivers = new ArrayList<>();
        NodeList driversNodeList = document.getElementsByTagName("driver");
        for (int i = 0; i < driversNodeList.getLength(); i++) {
            Node driverNode = driversNodeList.item(i);
            if (driverNode.getNodeType() == Node.ELEMENT_NODE) {
                Element driverElement = ((Element) driverNode);
                Driver driver = new Driver();
                String driverId = driverElement.getAttribute("id");
                driver.setId(Integer.parseInt(driverId));
                String firstName = driverElement.getElementsByTagName("driverFirstName").item(0).getTextContent();
                String lastName = driverElement.getElementsByTagName("driverLastName").item(0).getTextContent();
                String phone = driverElement.getElementsByTagName("driverPhone").item(0).getTextContent();
                driver.setDriverFirstName(firstName);
                driver.setDriverLastName(lastName);
                driver.setDriverPhone(phone);

                NodeList carNodeList = driverElement.getElementsByTagName("car");
                for (int j = 0; j < carNodeList.getLength(); j++) {
                    Node carNode = carNodeList.item(j);
                    if (carNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element carElement = ((Element) carNode);
                        Car car = new Car();
                        String carId = carElement.getAttribute("id");
                        car.setId(Integer.parseInt(carId));
                        String brand = carElement.getElementsByTagName("brand").item(0).getTextContent();
                        String model = carElement.getElementsByTagName("model").item(0).getTextContent();
                        String yearOfIssue = carElement.getElementsByTagName("yearOfIssue").item(0).getTextContent();
                        car.setBrand(brand);
                        car.setModel(model);
                        car.setYearOfIssue(Integer.parseInt(yearOfIssue));

                        NodeList liftCapacityNodeList = carElement.getElementsByTagName("liftCapacity");
                        for (int k = 0; k < liftCapacityNodeList.getLength(); k++) {
                            Node capacityNode = liftCapacityNodeList.item(k);
                            if (capacityNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element capacityElement = ((Element) capacityNode);
                                LiftCapacity liftCapacity = new LiftCapacity();
                                String unit = capacityElement.getAttribute("unit");
                                String capacity = capacityElement.getElementsByTagName("capacity").item(0).getTextContent();
                                liftCapacity.setUnit(unit);
                                liftCapacity.setCapacity(Integer.parseInt(capacity));
                                car.setLiftCapacity(liftCapacity);
                            }

                        }
                        driver.setCar(car);
                    }

                }
                drivers.add(driver);
            }
        }
        return drivers;
    }
}

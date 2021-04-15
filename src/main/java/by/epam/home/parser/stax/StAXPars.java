package by.epam.home.parser.stax;

import by.epam.home.entity.*;
import by.epam.home.parser.XMLParser;

import javax.xml.stream.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StAXPars extends XMLParser {

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

    @Override
    public CargoService getCargoService(String pathToSourceFile) throws XMLStreamException, IOException {
        File fileByPath = new File(pathToSourceFile);
        FileReader fileReader = new FileReader(fileByPath);
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(fileReader);
        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "cargo-service":
                            cargoService = new CargoService();
                            break;
                        case "customer":
                            customer = new Customer();
                            int customerId = Integer.parseInt(reader.getAttributeValue(0));
                            customer.setId(customerId);
                            break;
                        case "order":
                            order = new Order();
                            int orderId = Integer.parseInt(reader.getAttributeValue(0));
                            order.setId(orderId);
                            break;
                        case "weight":
                            weight = new Weight();
                            String unit = reader.getAttributeValue(0);
                            weight.setUnit(unit);
                            break;
                        case "price":
                            price = new Price();
                            String currency = reader.getAttributeValue(0);
                            price.setCurrency(currency);
                            break;
                        case "driver":
                            driver = new Driver();
                            int driverId = Integer.parseInt(reader.getAttributeValue(0));
                            driver.setId(driverId);
                            break;
                        case "car":
                            car = new Car();
                            int carId = Integer.parseInt(reader.getAttributeValue(0));
                            car.setId(carId);
                            break;
                        case "liftCapacity":
                            liftCapacity = new LiftCapacity();
                            String capacityUnit = reader.getAttributeValue(0);
                            liftCapacity.setUnit(capacityUnit);
                            break;
                    }
                case XMLStreamConstants.CHARACTERS:
                    if (reader.hasText()) {
                        content = reader.getText().trim();
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
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
        }
        fileReader.close();
        return cargoService;
    }
}

package by.epam.home.main;

import by.epam.home.entity.CargoService;
import by.epam.home.entity.Customer;
import by.epam.home.entity.Driver;
import by.epam.home.factory.XMLParserFactory;
import by.epam.home.parser.XMLParser;

import java.util.List;

public class ConsoleWriter {
    private final XMLParserFactory factory;

    public ConsoleWriter(XMLParserFactory xmlParserFactory) {
        this.factory = xmlParserFactory;
    }

    public CargoService getCargoServiceFromXml(String pathToSourceFile, String typeOfParser) throws Exception {
        XMLParser xmlParser;
        CargoService service;
        xmlParser = factory.createXmlParser(typeOfParser);
        service = (CargoService) xmlParser.getCargoService(pathToSourceFile);
        return service;
    }

    public void printCargoServiceToConsole(CargoService cargoService) {
        List<Customer> customers = (List<Customer>) cargoService.getCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        List<Driver> drivers = (List<Driver>) cargoService.getDrivers();
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }
}

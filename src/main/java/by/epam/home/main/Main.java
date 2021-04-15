package by.epam.home.main;

import by.epam.home.entity.CargoService;
import by.epam.home.factory.XMLParserFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        String partToFile = "source.xml";
        String domParser = "domParser";
        String saxParser = "saxParser";
        String staxParser = "staxParser";
        XMLParserFactory factory = new XMLParserFactory();
        ConsoleWriter console = new ConsoleWriter(factory);
        CargoService cargoService = (CargoService) console.getCargoServiceFromXml(partToFile, staxParser);
        console.printCargoServiceToConsole(cargoService);

    }
}

package by.epam.home.parser.sax;

import by.epam.home.entity.CargoService;
import by.epam.home.parser.XMLParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXPars extends XMLParser {

    @Override
    public CargoService getCargoService(String pathToSourceFile) throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SAXHandler handler = new SAXHandler();
        parser.parse(pathToSourceFile, handler);
        return (CargoService) handler.getCargoService();
    }
}

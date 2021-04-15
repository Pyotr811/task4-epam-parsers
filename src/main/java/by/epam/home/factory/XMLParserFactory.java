package by.epam.home.factory;

import by.epam.home.parser.dom.DomPars;
import by.epam.home.parser.sax.SAXPars;
import by.epam.home.parser.stax.StAXPars;
import by.epam.home.parser.XMLParser;

public class XMLParserFactory {

    public XMLParser createXmlParser(String typeOfParser) {
        XMLParser xmlParser = null;
        switch (typeOfParser) {
            case "domParser":
                xmlParser = new DomPars();
                break;
            case "saxParser":
                xmlParser = new SAXPars();
                break;
            case "staxParser":
                xmlParser = new StAXPars();
                break;
        }
        return xmlParser;
    }

}

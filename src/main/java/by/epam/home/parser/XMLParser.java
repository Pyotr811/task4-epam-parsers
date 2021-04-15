package by.epam.home.parser;

import by.epam.home.entity.CargoService;

public abstract class XMLParser {
    public abstract CargoService getCargoService(String pathToSourceFile) throws Exception;

}

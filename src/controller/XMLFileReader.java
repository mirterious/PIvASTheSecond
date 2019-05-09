package controller;

import org.xml.sax.SAXException;
import model.Train;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLFileReader {

	private SAXParserFactory factory;

	private SAXParser parser;

	public XMLFileReader() {
		factory = SAXParserFactory.newInstance();
		try {
			parser = factory.newSAXParser();
		} catch (ParserConfigurationException configurationError) {
			System.out.println(configurationError.getMessage());
		} catch (SAXException SAXError) {
			System.out.println(SAXError.getMessage());
		}
	}

	public List<Train> read(File file) {
		List<Train> trains = null;
		try {
			XMLHandler handler = new XMLHandler();
			parser.parse(file, handler);
			trains = handler.getTrains();
		} catch (IOException IOError) {
			System.out.println(IOError.getMessage());
		} catch (SAXException SAXError) {
			System.out.println(SAXError.getMessage());
		}
		return trains;
	}
}

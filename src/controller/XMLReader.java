package controller;

import org.xml.sax.SAXException;
import model.Train;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLReader {

	private SAXParserFactory factory;

	private SAXParser parser;

	public XMLReader() {
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
		List<Train> students = null;
		try {
			XMLHandler handler = new XMLHandler();
			parser.parse(file, handler);
			students = handler.getTrains();
		} catch (IOException IOError) {
			System.out.println(IOError.getMessage());
		} catch (SAXException SAXError) {
			System.out.println(SAXError.getMessage());
		}
		return students;
	}
}

package controller;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.Station;
import model.Train;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

public class XMLFileWriter {

	private DocumentBuilderFactory builderFactory;

	private DocumentBuilder builder;

	public XMLFileWriter() {
		builderFactory = DocumentBuilderFactory.newInstance();
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}

	public void write(List<Train> trains, File file) {
		Document xmlDocument = builder.newDocument();
		Element xmlTrains = xmlDocument.createElement("trains");
		for (Train train : trains) {
			Element xmlTrain = xmlDocument.createElement("train");

			Element xmlNumber = convert(train.getNumber(), xmlDocument);
			xmlTrain.appendChild(xmlNumber);
			Element xmlDepStation = convert(train.getDeparture(), xmlDocument, "departure");
			xmlTrain.appendChild(xmlDepStation);
			Element xmlArrStation = convert(train.getArriving(), xmlDocument, "arriving");
			xmlTrain.appendChild(xmlArrStation);
			Element xmlDepDate = convert(train.getDepartureDate(), xmlDocument, "departureDate");
			xmlTrain.appendChild(xmlDepDate);
			Element xmlArrDate = convert(train.getArrivingDate(), xmlDocument, "arrivingDate");
			xmlTrain.appendChild(xmlArrDate);

			xmlTrains.appendChild(xmlTrain);
		}
		xmlDocument.appendChild(xmlTrains);
		writeInFile(xmlDocument, file);
	}

	private Element convert(String number, Document document) {
		Element xmlNumber = document.createElement("number");
		xmlNumber.setTextContent(number);
		return xmlNumber;
	}

	private Element convert(Station station, Document document, String element) {
		Element xmlStation = document.createElement(element);
		xmlStation.setTextContent(station.toString());
		return xmlStation;
	}

	private Element convert(LocalDateTime time, Document document, String element) {
		Element xmlTime = document.createElement(element);
		xmlTime.setTextContent(time.toString());
		return xmlTime;
	}

	private void writeInFile(Document document, File file) {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			StreamResult result = new StreamResult(file);
			transformer.transform(new DOMSource(document), result);
		} catch (TransformerException transformerError) {
			System.out.println(transformerError.getMessage());
		}
	}
}
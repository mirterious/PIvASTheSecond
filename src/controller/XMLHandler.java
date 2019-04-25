package controller;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import model.Station;
import model.Train;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {

	private DateAndTimeParser parser;
	
	private List<Train> trains;

	private String lastElement;

	private String number;

	private Station departure;

	private Station arriving;

	private LocalDateTime departureDate;

	private LocalDateTime arrivingDate;

	public XMLHandler() {
		trains = new LinkedList<>();
		parser = new DateAndTimeParser();
		departure = new Station();
		arriving = new Station();
	}

	public List<Train> getTrains() {
		return trains;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		lastElement = qName;
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		String information = new String(ch, start, length);
		information = information.replace("\n", "").trim();
		if (!information.isEmpty()) {
			if (lastElement.equals("number")) {
				number = information;
			}
			if (lastElement.equals("departure")) {
				departure = new Station(information);
			}
			if (lastElement.equals("arriving")) {
				arriving = new Station(information);
			}
			if (lastElement.equals("departureDate")) {
				departureDate = parser.convertToDateTime(information);
			}
			if (lastElement.equals("arrivingDate")) {
				arrivingDate = parser.convertToDateTime(information);
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		if (qName.equals("train")) {
			trains.add(new Train(number, departure, arriving, departureDate, arrivingDate));
		}
	}
}
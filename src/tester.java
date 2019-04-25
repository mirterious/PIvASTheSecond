import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import model.Train;
import controller.DateAndTimeParser;
import controller.XMLHandler;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;

public class tester {

	private static List<Train> trains = new ArrayList<>();
		
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
    	DateAndTimeParser pars = new DateAndTimeParser();
    	String date = "2019-04-22T20:30";
    	//LocalDate date1 = pars.convertToDate(date);
    	//int month = date1.getDayOfMonth();
    	//System.out.println(month);
    	SAXParserFactory factory = SAXParserFactory.newInstance();
    	SAXParser parser = factory.newSAXParser();
    	
    	XMLHandler handler = new XMLHandler();
    	parser.parse(new File("1.xml"), handler);
    	
    	trains = handler.getTrains();
    	
    	for (Train train : trains)
            System.out.println(train);   
    }
}
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import model.Schedule;
import model.Station;
import model.Train;
import model.TravelTime;
import view.ComponentCreator;
import controller.XMLHandler;
import controller.DateAndTimeParser;
import controller.XMLFileReader;
import controller.XMLFileWriter;
import javafx.stage.FileChooser;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;

public class tester {

	private static List<Train> trains = new ArrayList<>();
		
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
    	/*XMLFileReader reader = new XMLFileReader();
    	
    	File file = new File("1.xml");
    	File file1 = new File("2.xml");
    	trains = reader.read(file);
    	for (Train train : trains)
            System.out.println(train); 
    	trains.clear();
    	trains.add(new Train("1234", new Station("brest"), new Station("minsk"), time, time));
    	XMLFileWriter writer = new XMLFileWriter();
    	writer.write(trains, file1);
    	trains = reader.read(file1);
    	for (Train train : trains)
            System.out.println(train); */
    	/*XMLFileReader reader = new XMLFileReader();
    	File file = new File("1.xml");
    	trains = reader.read(file);
    	LocalDateTime time = LocalDateTime.of(2017, 5, 24, 13, 32);
    	LocalDateTime time2 = LocalDateTime.of(2019, 9, 27, 16, 34);
 
    	Duration period = Duration.between(time, time2);
    	int minutes = (int)period.toMinutes();
    	System.out.println(minutes);
    	int hours = (int)period.toHours();
    	minutes -= hours*60;
    	int days = (int)period.toDays();
    	hours -= days*24;
    	int month = days/30;
    	days -= month*30;
    	int years = month/12;
    	month -= years*12;
    	for (Train train: trains) {
    		System.out.println(train);
    	}
    	System.out.println(years + " " + month + " " + days + " " + hours + " " + minutes);*/
    	
    	LocalDate date = LocalDate.of(2019, 05, 9);
    	LocalDateTime date1 = LocalDateTime.of(2019, 05, 9, 14, 44);
    	LocalDateTime date2 = LocalDateTime.of(2019, 05, 9, 15, 55);
    	Train train = new Train("jopa", new Station("pizda"), new Station("anus"), date1, date2);
    	TravelTime time = train.getTravelTime();
    	String time1 = "0 0 0 2 11";
    	DateAndTimeParser parser = new DateAndTimeParser();
    	System.out.println(time);
    	System.out.println(parser.convertToTravelTime(time1));
    	System.out.println(time.toString().equals(parser.convertToTravelTime(time1).toString()));
    }
}
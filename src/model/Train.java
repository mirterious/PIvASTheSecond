package model;

import java.time.LocalDateTime;
import controller.DateAndTimeParser;

public class Train {
	
	private DateAndTimeParser parser;
	
	private String number;
	
	private Station departure;
	
	private Station arriving;
	
	private LocalDateTime departureDate;
	
	private LocalDateTime arrivingDate;
	
	private TravelTime travelTime;
	
	
	public Train(String number, Station departure, Station arriving, 
			LocalDateTime depDate, LocalDateTime arrDate) {
		parser = new DateAndTimeParser();
		this.number = number;
		this.departure = departure;
		this.arriving = arriving;
		this.departureDate = depDate;
		this.arrivingDate = arrDate;
		this.travelTime = parser.countTravelTime(departureDate, arrivingDate);
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setDepartureStation(Station station) {
		this.departure = station;
	}
	
	public Station getDepartureStation() {
		return departure;
	}
	
	public void setArrivingStation(Station station) {
		this.arriving = station;
	}
	
	public Station getArrivingStation() {
		return arriving;
	}
	
	public void setDepartureDate(LocalDateTime date) {
		this.departureDate = date;
	}
	
	public LocalDateTime getDepartureDate() {
		return departureDate;
	}
	
	public void setArrivingDate(LocalDateTime date) {
		this.arrivingDate = date;
	}
	
	public LocalDateTime getArrivingDate() {
		return arrivingDate;
	}
	
	public void setTravelTime(TravelTime time) {
		this.travelTime = time;
	}
	
	public TravelTime getTravelTime() {
		return travelTime;
	}
	
	@Override
	public String toString() {
		String train = number+" "+departure+" "+arriving+" "+departureDate+" "+arrivingDate+" "+parser.printTravelTime(travelTime);
		return train;
	}
}
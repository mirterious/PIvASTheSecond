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
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Station getDeparture() {
		return departure;
	}

	public void setDeparture(Station departure) {
		this.departure = departure;
	}

	public Station getArriving() {
		return arriving;
	}

	public void setArriving(Station arriving) {
		this.arriving = arriving;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArrivingDate() {
		return arrivingDate;
	}

	public void setArrivingDate(LocalDateTime arrivingDate) {
		this.arrivingDate = arrivingDate;
	}

	public TravelTime getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(TravelTime travelTime) {
		this.travelTime = travelTime;
	}
	
	@Override
	public String toString() {
		String train = number+" "+departure+" "+arriving+" "+departureDate+" "+arrivingDate+" "+travelTime;
		return train;
	}
}
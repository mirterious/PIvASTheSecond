package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Information {
	private String departureStation;
	
	private String arrivingStation;
	
	private Calendar departureDate;
	
	private Calendar arrivingDate;
	
	private Calendar departureTime;
	
	private Calendar arrivingTime;
	
	private Calendar travelTime;
	
	public Information() {
		this.departureDate = null;
		this.arrivingDate = null;
		this.departureStation = null;
		this.arrivingStation = null;
		this.departureTime = null;
		this.arrivingTime = null;
		this.travelTime = null;
	}
	
	public Information(String departureStation, String arrivingStation, 
			Calendar departureDate, Calendar arrivingDate, Calendar departureTime, Calendar arrivingTime) {
		this.departureDate = departureDate;
		this.arrivingDate = arrivingDate;
		this.departureStation = departureStation;
		this.arrivingStation = arrivingStation;
		this.departureTime = departureTime;
		this.arrivingTime = arrivingTime;
		this.travelTime = countTravelTime(departureTime, arrivingTime);
	}
	
	public Calendar countTravelTime(Calendar departure, Calendar arriving) {
		Calendar result = new GregorianCalendar();
		int hours = arriving.get(Calendar.HOUR) - departure.get(Calendar.HOUR);
		if (hours < 0) {
			hours += 24;
		}
		result.set(Calendar.HOUR, hours);
		int minutes = arriving.get(Calendar.MINUTE) - departure.get(Calendar.MINUTE);
		if (minutes < 0) {
			minutes += 60;
		}
		result.set(Calendar.MINUTE, minutes);
		return result;
	}
	
	public void setDepartureStation(String station) {
		this.departureStation = station;
	}
	
	public String getDepartureStation() {
		return departureStation;
	}
	
	public void setArrivingStation(String station) {
		this.arrivingStation = station;
	}
	
	public String getArrivingStation() {
		return arrivingStation;
	}
	
	public void setDepartureDate(Calendar date) {
		this.departureDate = date;
	}
	
	public Calendar getDepartureDate() {
		return departureDate;
	}
	
	public void setArrivingDate(Calendar date) {
		this.arrivingDate = date;
	}
	
	public Calendar getArrivingDate() {
		return arrivingDate;
	}
	
	public void setDepartureDTime(Calendar time) {
		this.departureTime = time;
	}
	
	public Calendar getDepartureTime() {
		return departureTime;
	}
	
	public void setArrivingTime(Calendar time) {
		this.arrivingTime = time;
	}
	
	public Calendar getArrivingTime() {
		return arrivingTime;
	}
	
	public void setTravelTime(Calendar time) {
		this.travelTime = time;
	}
	
	public Calendar getTravelTime() {
		return travelTime;
	}
}
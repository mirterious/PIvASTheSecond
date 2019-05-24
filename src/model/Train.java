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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arriving == null) ? 0 : arriving.hashCode());
		result = prime * result + ((arrivingDate == null) ? 0 : arrivingDate.hashCode());
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((parser == null) ? 0 : parser.hashCode());
		result = prime * result + ((travelTime == null) ? 0 : travelTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		if (arriving == null) {
			if (other.arriving != null)
				return false;
		} else if (!arriving.equals(other.arriving))
			return false;
		if (arrivingDate == null) {
			if (other.arrivingDate != null)
				return false;
		} else if (!arrivingDate.equals(other.arrivingDate))
			return false;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (parser == null) {
			if (other.parser != null)
				return false;
		} else if (!parser.equals(other.parser))
			return false;
		if (travelTime == null) {
			if (other.travelTime != null)
				return false;
		} else if (!travelTime.equals(other.travelTime))
			return false;
		return true;
	}
}
package model;

public class TravelTime {
	
	private int years;
	
	private int month;
	
	private int days;
	
	private int hours;
	
	private int minutes;
	
	public TravelTime(int years, int month, int days, int hours, int minutes) {
		this.years = years;
		this.month = month;
		this.days = days;
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public int getYears() {
		return years;
	}

	public int getMonth() {
		return month;
	}
	
	public int getDays() {
		return days;
	}
	
	public int getHours() {
		return hours;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	@Override
	public String toString() {
		String date = "";
		if (years != 0) {
			date = years + " y ";
		}
		if (month != 0) {
			date = date + month + " m ";
		}
		if (days != 0) {
			date = date + days + " d ";
		}
		date = date + hours + " h " + minutes + " min";
		return date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + days;
		result = prime * result + hours;
		result = prime * result + minutes;
		result = prime * result + month;
		result = prime * result + years;
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
		TravelTime other = (TravelTime) obj;
		if (days != other.days)
			return false;
		if (hours != other.hours)
			return false;
		if (minutes != other.minutes)
			return false;
		if (month != other.month)
			return false;
		if (years != other.years)
			return false;
		return true;
	}
	
	
}

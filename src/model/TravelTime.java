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
}

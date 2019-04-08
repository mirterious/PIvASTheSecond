/*package model;

public class Time {
	private int hours;
	
	private int minutes;
	
	public Time() {
		this.hours = 0;
		this.minutes = 0;
	}
	
	public Time(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public Integer getHours() {
		return hours;
	}
	
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	public Integer getMinutes() {
		return minutes;
	}
	
	public Time countDifference(Time departure, Time arrive) {
		this.hours = arrive.hours - departure.hours;
		if (this.hours < 0) {
			this.hours += 24;
		}
		this.minutes = arrive.minutes - departure.minutes;
		if (this.minutes < 0) {
			this.minutes +=60;
		}
		return this;
	}
}*/
package controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import model.TravelTime;

public class DateAndTimeParser {
	
	public DateAndTimeParser() {};
	
	public LocalDateTime convertToDateTime(String date) {
		String[] parsedFullDate = date.split("T");
		String[] parsedDate = parsedFullDate[0].split("\\-");
		String[] parsedTime = parsedFullDate[1].split("\\:");
		
		int day = Integer.parseInt(parsedDate[2]);
		int month = Integer.parseInt(parsedDate[1]);
		int year = Integer.parseInt(parsedDate[0]);
		int hours = Integer.parseInt(parsedTime[0]);
		int minutes = Integer.parseInt(parsedTime[1]);
		
		LocalDateTime newDate = LocalDateTime.of(year, month, day, hours, minutes);
		return newDate;
	}
	
	public LocalTime convertToTime(String time) {
		String[] parsedTime = time.split("\\:");
		
		int hours = Integer.parseInt(parsedTime[0]);
		int minutes = Integer.parseInt(parsedTime[1]);
		
		LocalTime newTime = LocalTime.of(hours, minutes);
		return newTime;
	}
	
	public LocalDate convertToDate(String date) {
		String[] parsedDate = date.split("\\-");
		
		int year = Integer.parseInt(parsedDate[0]);
		int month = Integer.parseInt(parsedDate[1]);
		int day = Integer.parseInt(parsedDate[2]);
		
		LocalDate newDate = LocalDate.of(year, month, day);
		return newDate;
	}
	
	public TravelTime convertToTravelTime(String time) {
		String[] parsedTime = time.split("\\s");
		
		int years = Integer.parseInt(parsedTime[0]);
		int months = Integer.parseInt(parsedTime[1]);
		int days = Integer.parseInt(parsedTime[2]);
		int hours = Integer.parseInt(parsedTime[3]);
		int minutes = Integer.parseInt(parsedTime[4]);
		
		TravelTime searchingTime = new TravelTime(years, months, days, hours, minutes);
		return searchingTime;
	}

	public TravelTime countTravelTime(LocalDateTime departure, LocalDateTime arriving) {
		
		LocalDateTime temp = LocalDateTime.from(departure);

		long years = temp.until( arriving, ChronoUnit.YEARS);
		temp = temp.plusYears( years );

		long months = temp.until( arriving, ChronoUnit.MONTHS);
		temp = temp.plusMonths( months );

		long days = temp.until( arriving, ChronoUnit.DAYS);
		temp = temp.plusDays( days );

		long hours = temp.until( arriving, ChronoUnit.HOURS);
		temp = temp.plusHours( hours );

		long minutes = temp.until( arriving, ChronoUnit.MINUTES);
		temp = temp.plusMinutes( minutes );

		TravelTime result = new TravelTime((int)years, (int)months, (int)days, (int)hours, (int)minutes);
		return result;
	}
}

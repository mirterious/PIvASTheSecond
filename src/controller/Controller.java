package controller;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Schedule;
import model.Train;
import model.TravelTime;

public class Controller {
	private Schedule model;

	public Controller(Schedule model) {
		this.model = model;
	}

	public void addAmountOfTrains(List<Train> trains) {
		model.getTrains().addAll(trains);
	}
	
	public void addTrain(Train train) {
		model.getTrains().add(train);
	}

	public void refresh() {
		model.getTrains().clear();
	}
	
	public List<Train> copy() {
		return model.copy();
	}

	public List<Train> getTrains() {
		return model.getTrains();
	}
	
	public void saveFile(File file) {
		new XMLFileWriter().write(model.getTrains(), file);
	}

	public List<Train> openFile(File file) {
		return new XMLFileReader().read(file);
	}
	
	public List<Train> searchByDepStation(String station) {
		List<Train> result = new ArrayList<>();
		List<Train> trains = model.copy();
		for(Train train:trains) {
			if (train.getDeparture().toString().equals(station)) {
				result.add(train);
			}
		}
		return result;
	}
	
	public List<Train> searchByArrStation(String station) {
		List<Train> result = new ArrayList<>();
		List<Train> trains = model.copy();
		for(Train train:trains) {
			if (train.getArriving().toString().equals(station)) {
				result.add(train);
			}
		}
		return result;
	}
	
	public List<Train> searchByNumber(String number) {
		List<Train> result = new ArrayList<>();
		List<Train> trains = model.copy();
		for(Train train:trains) {
			if (train.getNumber().equals(number)) {
				result.add(train);
			}
		}
		return result;
	}
	
	public List<Train> searchByDepDate(LocalDate date) {
		List<Train> result = new ArrayList<>();
		List<Train> trains = model.copy();
		for(Train train:trains) {
			if (train.getDepartureDate().toLocalDate().equals(date)); {
				result.add(train);
			}
		}
		return result;
	}
	
	public List<Train> searchByTravelTime(String time) {
		List<Train> result = new ArrayList<>();
		List<Train> trains = model.copy();
		for(Train train:trains) {
			if (train.getTravelTime().toString().equals(time)); {
				result.add(train);
			}
		}
		return result;
	}
	
	public List<Train> searchByDepTime(LocalTime top, LocalTime bottom) {
		List<Train> result = new ArrayList<>();
		List<Train> trains = model.copy();
		for (Train train:trains) {
			if(train.getDepartureDate().toLocalTime().isAfter(bottom) && train.getDepartureDate().toLocalTime().isBefore(top)) {
				result.add(train);
			}
		}
		return result;
	}
	
	public List<Train> searchByArrTime(LocalTime top, LocalTime bottom) {
		List<Train> result = new ArrayList<>();
		List<Train> trains = model.copy();
		for (Train train:trains) {
			if(train.getArrivingDate().toLocalTime().isAfter(bottom) && train.getArrivingDate().toLocalTime().isBefore(top)) {
				result.add(train);
			}
		}
		return result;
	}
}

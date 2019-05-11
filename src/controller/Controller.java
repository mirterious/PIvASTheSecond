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
	
	public List<Train> searchByDepDate(LocalDate date) {;
		List<Train> result = new ArrayList<>();
		List<Train> trains = model.copy();
		for(Train train:trains) {
			if (train.getDepartureDate().toLocalDate().isEqual(date)) {
				result.add(train);
			}
		}
		return result;
	}
	
	public List<Train> searchByTravelTime(TravelTime time) {
		List<Train> result = new ArrayList<>();
		List<Train> trains = model.copy();
		for(Train train:trains) {
			if (train.getTravelTime().equals(time)) {
				result.add(train);
			}
		}
		return result;
	}
	
	public List<Train> searchByDepTime(LocalTime top, LocalTime bottom) {
		List<Train> result = new ArrayList<>();
		List<Train> trains = model.copy();
		for (Train train:trains) {
			if(train.getDepartureDate().toLocalTime().isAfter(bottom) 
					&& train.getDepartureDate().toLocalTime().isBefore(top)) {
				result.add(train);
			}
		}
		return result;
	}
	
	public List<Train> searchByArrTime(LocalTime top, LocalTime bottom) {
		List<Train> result = new ArrayList<>();
		List<Train> trains = model.copy();
		for (Train train:trains) {
			if(train.getArrivingDate().toLocalTime().isAfter(bottom) 
					&& train.getArrivingDate().toLocalTime().isBefore(top)) {
				result.add(train);
			}
		}
		return result;
	}
	
	public void deleteByDepStation(String station) {
    	List<Integer> indexes = new ArrayList<>();
    	for (int i = 0; i < model.getTrains().size(); i++) {
    		if(model.getTrains().get(i).getDeparture().toString().equals(station)) {
    			indexes.add(i);
    		}
    	}
    	int[] ind = new int[indexes.size()];
    	for (int i = 0; i < indexes.size(); i++) {
    		ind[i] = indexes.get(i);
    	}
    	for (int i = 0; i < indexes.size(); i++) {
    		model.getTrains().remove(ind[i]);
    		for (int j = i+1; j < indexes.size(); j++) {
    			ind[j] -= 1;
    		}
    	}
	}
	
	public void deleteByArrStation(String station ) {
		List<Integer> indexes = new ArrayList<>();
    	for (int i = 0; i < model.getTrains().size(); i++) {
    		if(model.getTrains().get(i).getArriving().toString().equals(station)) {
    			indexes.add(i);
    		}
    	}
    	int[] ind = new int[indexes.size()];
    	for (int i = 0; i < indexes.size(); i++) {
    		ind[i] = indexes.get(i);
    	}
    	for (int i = 0; i < indexes.size(); i++) {
    		model.getTrains().remove(ind[i]);
    		for (int j = i+1; j < indexes.size(); j++) {
    			ind[j] -= 1;
    		}
    	}
	}
	
	public void deleteByDepTime(LocalTime top, LocalTime bottom) {
		List<Integer> indexes = new ArrayList<>();
    	for (int i = 0; i < model.getTrains().size(); i++) {
    		if(model.getTrains().get(i).getDepartureDate().toLocalTime().isAfter(bottom) 
    				&& model.getTrains().get(i).getDepartureDate().toLocalTime().isBefore(top)) {
    			indexes.add(i);
    		}
    	}
    	int[] ind = new int[indexes.size()];
    	for (int i = 0; i < indexes.size(); i++) {
    		ind[i] = indexes.get(i);
    	}
    	for (int i = 0; i < indexes.size(); i++) {
    		model.getTrains().remove(ind[i]);
    		for (int j = i+1; j < indexes.size(); j++) {
    			ind[j] -= 1;
    		}
    	}
	}
	
	public void deleteByArrTime(LocalTime top, LocalTime bottom) {
		List<Integer> indexes = new ArrayList<>();
    	for (int i = 0; i < model.getTrains().size(); i++) {
    		if(model.getTrains().get(i).getArrivingDate().toLocalTime().isAfter(bottom) 
    				&& model.getTrains().get(i).getArrivingDate().toLocalTime().isBefore(top)) {
    			indexes.add(i);
    		}
    	}
    	int[] ind = new int[indexes.size()];
    	for (int i = 0; i < indexes.size(); i++) {
    		ind[i] = indexes.get(i);
    	}
    	for (int i = 0; i < indexes.size(); i++) {
    		model.getTrains().remove(ind[i]);
    		for (int j = i+1; j < indexes.size(); j++) {
    			ind[j] -= 1;
    		}
    	}
	}
	
	public void deleteByNumber(String number) {
		List<Integer> indexes = new ArrayList<>();
    	for (int i = 0; i < model.getTrains().size(); i++) {
    		if(model.getTrains().get(i).getNumber().equals(number)) {
    			indexes.add(i);
    		}
    	}
    	int[] ind = new int[indexes.size()];
    	for (int i = 0; i < indexes.size(); i++) {
    		ind[i] = indexes.get(i);
    	}
    	for (int i = 0; i < indexes.size(); i++) {
    		model.getTrains().remove(ind[i]);
    		for (int j = i+1; j < indexes.size(); j++) {
    			ind[j] -= 1;
    		}
    	}
	}
	
	public void deleteByDepDate(LocalDate date) {
		List<Integer> indexes = new ArrayList<>();
    	for (int i = 0; i < model.getTrains().size(); i++) {
    		if(model.getTrains().get(i).getDepartureDate().toLocalDate().isEqual(date)) {
    			indexes.add(i);
    		}
    	}
    	int[] ind = new int[indexes.size()];
    	for (int i = 0; i < indexes.size(); i++) {
    		ind[i] = indexes.get(i);
    	}
    	for (int i = 0; i < indexes.size(); i++) {
    		model.getTrains().remove(ind[i]);
    		for (int j = i+1; j < indexes.size(); j++) {
    			ind[j] -= 1;
    		}
    	}
	}
	
	public void deleteByTravelTime(TravelTime time) {
		List<Integer> indexes = new ArrayList<>();
    	for (int i = 0; i < model.getTrains().size(); i++) {
    		if(model.getTrains().get(i).getTravelTime().equals(time)) {
    			indexes.add(i);
    		}
    	}
    	int[] ind = new int[indexes.size()];
    	for (int i = 0; i < indexes.size(); i++) {
    		ind[i] = indexes.get(i);
    	}
    	for (int i = 0; i < indexes.size(); i++) {
    		model.getTrains().remove(ind[i]);
    		for (int j = i+1; j < indexes.size(); j++) {
        		ind[j] -= 1;
        	}
    	}
	}
}
package model;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
	
	private List<Train> trains;
	
	public Schedule() {
		trains = new ArrayList<>();
	}
	
	public Schedule(List<Train> trains) {
		this.trains = trains;
	}
	
	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}
	
	public List<Train> getTrains() {
		return trains;
	}
	
	public List<Train> copy() {
		return new ArrayList<Train>(trains);
	}
}

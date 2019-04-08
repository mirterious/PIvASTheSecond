package model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private List<Train> trains;
	
	public Model() {
		trains = new ArrayList<>();
	}
	
	public Model(List<Train> trains) {
		this.trains = trains;
	}
	
	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}
	
	public List<Train> getTrains( ) {
		return trains;
	}
}

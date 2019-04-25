package model;

public class Station {
	
	private String name;
	
	public Station() {}
	
	public Station(String name) {
		this.name = name;
	}
	
	public Station getStation() {
		return new Station(this.name);
	}
	
	@Override
	public String toString() {
		String station = name;
		return station;
	}
	
	public void setStation(String name) {
		this.name = name;
	}
}

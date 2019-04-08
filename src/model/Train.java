package model;
public class Train {
	
	private String number;
	
	private Information info;
	
	public Train() {
		this.number = null;
		this.info = null;
	}
	
	public Train(String number, Information info) {
		this.number = number;
		this.info = info;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setInfo(Information info) {
		this.info = info;
	}
	
	public Information getInfo() {
		return info;
	}
}
package view;

import java.time.LocalDateTime;
import model.TravelTime;
import model.Station;
import model.Train;

public class ShowTable {
	
	private Train train;
	
	public ShowTable(Train train) {
		this.train = train;
	}

	public String getNumber() {
		return train.getNumber();
	}

	public Station getDeparture() {
		return train.getDeparture();
	}

	public Station getArriving() {
		return train.getArriving();
	}

	public LocalDateTime getDepartureDate() {
		return train.getDepartureDate();
	}

	public LocalDateTime getArrivingDate() {
		return train.getArrivingDate();
	}

	public TravelTime getTravelTime() {
		return train.getTravelTime();
	}
}

package view.dialogs.panes;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import view.ComponentCreator;

public class TravelTimePane {
	
	private TextField years;
	
	private TextField months;

	private TextField days;
	
	private TextField hours;

	private TextField minutes;

	private ComponentCreator creator;
	
	private GridPane mainPane;
	
	public TravelTimePane() {
		creator = new ComponentCreator();
		years = creator.getTextField();
		months = creator.getTextField();
		days = creator.getTextField();
		hours = creator.getTextField();
		minutes = creator.getTextField();
		mainPane = new GridPane();
		buildDialog();
	}
	
	private void buildDialog() {
		mainPane.add(years, 0, 0);
		mainPane.add(creator.getLabel("Кол-во лет"), 1, 0);		
		mainPane.add(months, 0, 1);		
		mainPane.add(creator.getLabel("Кол-во месяцев"), 1, 1);		
		mainPane.add(days, 0, 2);
		mainPane.add(creator.getLabel("Кол-во дней"), 1, 2);		
		mainPane.add(hours, 0, 3);		
		mainPane.add(creator.getLabel("Кол-во часов"), 1, 3);		
		mainPane.add(minutes, 0, 4);
		mainPane.add(creator.getLabel("Кол-во минут"), 1, 4);
	}
	
	public Pane getPane() {
		return mainPane;
	}
	
	public int getYears() {
		int result = 0;
		if (!years.getText().isEmpty()) {
			result = Integer.parseInt(years.getText());
			if (result < 0) {
				result = 0;
			}
		}
		return result;
	}
	
	public int getMonth() {
		int result = 0;
		if (!months.getText().isEmpty()) {
			result = Integer.parseInt(months.getText());
			if (result < 0) {
				result = 0;
			}
		}
		return result;
	}
	
	public int getDays() {
		int result = 0;
		if (!days.getText().isEmpty()) {
			result = Integer.parseInt(days.getText());
			if (result < 0) {
				result = 0;
			}
		}
		return result;
	}
	
	public int getHours() {
		int result = 0;
		if (!hours.getText().isEmpty()) {
			result = Integer.parseInt(hours.getText());
			if (result < 0) {
				result = 0;
			}
		}
		return result;
	}
	
	public int getMinutes() {
		int result = 0;
		if (!minutes.getText().isEmpty()) {
			result = Integer.parseInt(minutes.getText());
			if (result < 0) {
				result = 0;
			}
		}
		return result;
	}
}

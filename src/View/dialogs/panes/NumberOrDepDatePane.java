package view.dialogs.panes;

import java.time.LocalDate;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import view.ComponentCreator;

public class NumberOrDepDatePane {
	
	private TextField number;
	
	private DatePicker depDate;
	
	private ComponentCreator creator;
	
	private GridPane mainPane;
	
	public NumberOrDepDatePane() {
		creator = new ComponentCreator();
		number = creator.getTextField();
		depDate = creator.getDatePicker();
		mainPane = new GridPane();
		buildDialog();
	}
	
	private void buildDialog() {
		mainPane.add(creator.getLabel("Номер поезда"), 0, 0);
		
		mainPane.add(creator.getLabel("Дата отпр."), 0, 1);
		
		mainPane.add(number, 1, 0);
		
		mainPane.add(depDate, 1, 1);
	}
	
	public String getNumber() {
		String result = "";
		if (!number.getText().isEmpty()) {
			result = number.getText();
		}
		return result;
	}
	
	public LocalDate getDate() {
		return depDate.getValue();
	}
	
	public Pane getPane() {
		return mainPane;
	}
}

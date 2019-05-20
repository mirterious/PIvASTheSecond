package view;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class DialogCreator {
	
	private ComponentCreator creator;
	
	public DialogCreator() {
		creator = new ComponentCreator();
	};
	
	public Pane numberOrDepDateDialog() {
		GridPane pane = new GridPane();
		
		Label numberLabel = creator.getLabel("Номер");
		pane.add(numberLabel, 0, 0);
		
		Label depDateLabel = creator.getLabel("Дата отпр.");
		pane.add(depDateLabel, 0, 1);
		
		TextField numberText = creator.getTextField();
		pane.add(numberText, 1, 0);
		
		DatePicker depDateText = creator.getDatePicker();
		pane.add(depDateText, 1, 1);
		
		return pane;
	}
	
}

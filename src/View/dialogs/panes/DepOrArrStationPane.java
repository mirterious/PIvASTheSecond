package view.dialogs.panes;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import view.ComponentCreator;

public class DepOrArrStationPane {
	
	private TextField depStation;
	
	private TextField arrStation;
	
	private GridPane mainPane;
	
	private ComponentCreator creator;
	
	public DepOrArrStationPane() {
		creator = new ComponentCreator();
		depStation = creator.getTextField();
		arrStation = creator.getTextField();
		mainPane = new GridPane();
		buildPane();
	}
	
	private void buildPane() {
		mainPane.add(depStation, 0, 0);
		mainPane.add(creator.getLabel("Ст. оптр."), 1, 0);
		mainPane.add(arrStation, 0, 1);
		mainPane.add(creator.getLabel("Ст. приб."), 1, 1);
	}
	
	public String getDepStation() {
		String result = "";
		if (!depStation.getText().isEmpty()) {
			result = depStation.getText();
		}
		return result;
	}
	
	public String getArrStation() {
		String result = "";
		if (!arrStation.getText().isEmpty()) {
			result = arrStation.getText();
		}
		return result;
	}
	
	public Pane getPane() {
		return mainPane;
	}
}

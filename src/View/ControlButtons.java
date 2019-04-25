package view;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;
import view.dialogs.*;

public class ControlButtons {
	
	private ToolBar toolBar;
	
	private Pane pane;
	
	private ComponentCreator creator;
	
	public ControlButtons() {
		creator = new ComponentCreator();
		toolBar = new ToolBar();
		pane = new Pane();
		toolBar.setMinSize(600, 100);
		toolBar.setOrientation(Orientation.HORIZONTAL);
		pane.getChildren().add(toolBar);
		addAddButton();
		addDeleteButtons();
		addSearchButtons();
	}
	
	public Pane getPane() {
		return pane;
	}
	
	public void addAddButton() {
		Button addButton = creator.getButton("Add");
		toolBar.getItems().add(addButton);
		/*addButton.setOnAction(event -> {
			AddDialog dialog = new AddDialog();
			dialog.call();
			
		});*/
	}
	
	public void addSearchButtons() {
		Button SearchByNumberOrDepDate = creator.getButton("NumberOrDate");
		Button SearchByTravelTime = creator.getButton("TravelTime");
		Button SearchByDepTimeOrArrStation = creator.getButton("DepTimeOrArrStation");
		Button SearchByDepOrArrStation = creator.getButton("DepOrArrStation");
		toolBar.getItems().addAll(SearchByNumberOrDepDate, SearchByDepOrArrStation, SearchByTravelTime, SearchByDepTimeOrArrStation);
	}
	
	public void addDeleteButtons() {
		Button DeleteByNumberOrDepDate = creator.getButton("DNumberOrDate");
		Button DeleteByTravelTime = creator.getButton("DTravelTime");
		Button DeleteByDepTimeOrArrStation = creator.getButton("DDepTimeOrArrStation");
		Button DeleteByDepOrArrStation = creator.getButton("DDepOrArrStation");
		toolBar.getItems().addAll(DeleteByNumberOrDepDate, DeleteByDepOrArrStation, DeleteByTravelTime, DeleteByDepTimeOrArrStation);
	}
	
}

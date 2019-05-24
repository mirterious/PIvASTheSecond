package view;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import view.dialogs.AddTrainDialog;
import view.dialogs.DeleteByDepOrArrStation;
import view.dialogs.DeleteByDepTimeOrArrTime;
import view.dialogs.DeleteByNumberOrDepDate;
import view.dialogs.DeleteByTravelTime;
import view.dialogs.SearchByDepOrArrStation;
import view.dialogs.SearchByDepTimeOrArrTime;
import view.dialogs.SearchByNumberOrDepDate;
import view.dialogs.SearchByTravelTime;

public class SearchAndDeletePanel {
	
	private GridPane mainPane;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Table table;
	
	public SearchAndDeletePanel(Controller controller, Table table) {
		this.controller = controller;
		mainPane = new GridPane();
		creator = new ComponentCreator();
		this.table = table;
		addSearchButton();
		addDeleteButtons();
		addLabelsAndAddButton();
		correctPane();
	}
	
	private void addSearchButton() {
		Button searchByDepOrArrStation = creator.getButton();
		searchByDepOrArrStation.setOnAction(e -> {
			SearchByDepOrArrStation dialog = new SearchByDepOrArrStation(controller);
			dialog.call();
		});	
		mainPane.add(searchByDepOrArrStation, 1, 1);
		
		Button searchByNumberOrDepDate = creator.getButton();
		searchByNumberOrDepDate.setOnAction(e -> {
			SearchByNumberOrDepDate dialog = new SearchByNumberOrDepDate(controller);
			dialog.call();
		});
		mainPane.add(searchByNumberOrDepDate, 2, 1);
		
		Button searchByDepOrArrTime = creator.getButton();
		searchByDepOrArrTime.setOnAction(e -> {
			SearchByDepTimeOrArrTime dialog = new SearchByDepTimeOrArrTime(controller);
			dialog.call();
		});
		mainPane.add(searchByDepOrArrTime, 3, 1);
		
		Button searchByTravelTime = creator.getButton();
		searchByTravelTime.setOnAction(e -> {
			SearchByTravelTime dialog = new SearchByTravelTime(controller);
			dialog.call();
		});
		mainPane.add(searchByTravelTime, 4, 1);
		
		
	}
	
	private void addDeleteButtons() {
		Button deleteByDepOrArrStation = creator.getButton();
		deleteByDepOrArrStation.setOnAction(e -> {
			DeleteByDepOrArrStation dialog = new DeleteByDepOrArrStation(controller);
			dialog.call();
			table.update();
		});	
		mainPane.add(deleteByDepOrArrStation, 1, 2);
		
		Button deleteByNumberOrDepDate = creator.getButton();
		deleteByNumberOrDepDate.setOnAction(e -> {
			DeleteByNumberOrDepDate dialog = new DeleteByNumberOrDepDate(controller);
			dialog.call();
			table.update();
		});
		mainPane.add(deleteByNumberOrDepDate, 2, 2);
		
		Button deleteByDepOrArrTime = creator.getButton();
		deleteByDepOrArrTime.setOnAction(e -> {
			DeleteByDepTimeOrArrTime dialog = new DeleteByDepTimeOrArrTime(controller);
			dialog.call();
			table.update();
		});
		mainPane.add(deleteByDepOrArrTime, 3, 2);
		
		Button deleteByTravelTime = creator.getButton();
		deleteByTravelTime.setOnAction(e -> {
			DeleteByTravelTime dialog = new DeleteByTravelTime(controller);
			dialog.call();
			table.update();
		});
		mainPane.add(deleteByTravelTime, 4, 2);
	}
	
	private void addLabelsAndAddButton() {
		Button addButton = creator.getButton("Добавить");
		addButton.setOnAction(e -> {
			AddTrainDialog dialog = new AddTrainDialog(controller, table);
			dialog.call();
			table.update();
		});
		mainPane.add(addButton, 0, 0);
		
		Label depArrStationLabel = creator.getLabel("Ст. приб или отпр.");
		depArrStationLabel.setMinWidth(200);
		mainPane.add(depArrStationLabel, 1, 0);
		
		Label numberDepDateLabel = creator.getLabel("Дата отпр. или номер");
		numberDepDateLabel.setMinWidth(200);
		mainPane.add(numberDepDateLabel, 2, 0);
		
		Label depArrTimeLabel = creator.getLabel("Время приб. или отпр.");
		depArrTimeLabel.setMinWidth(200);
		mainPane.add(depArrTimeLabel, 3, 0);
		
		Label travelTimeLabel = creator.getLabel("Время в пути");
		travelTimeLabel.setMinWidth(200);
		mainPane.add(travelTimeLabel, 4, 0);
		
		Label searchLabel = creator.getLabel("Поиск");
		mainPane.add(searchLabel, 0, 1);
		
		Label deleteLabel = creator.getLabel("Удаление");
		mainPane.add(deleteLabel, 0, 2);
	}
	
	private void correctPane() {
		mainPane.setVgap(10);
		mainPane.setHgap(100);
	}
	
	public Pane getPane() {
		return mainPane;
	}
}

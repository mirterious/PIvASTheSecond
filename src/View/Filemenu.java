package view;

import java.io.File;
import java.util.List;
import model.Train;
import view.dialogs.AddTrainDialog;
import view.dialogs.DeleteByDepOrArrStation;
import view.dialogs.DeleteByDepTimeOrArrTime;
import view.dialogs.DeleteByNumberOrDepDate;
import view.dialogs.DeleteByTravelTime;
import view.dialogs.SearchByDepOrArrStation;
import view.dialogs.SearchByDepTimeOrArrTime;
import view.dialogs.SearchByNumberOrDepDate;
import view.dialogs.SearchByTravelTime;
import controller.Controller;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Filemenu {

	private Controller controller;

	private Stage stage;

	private Table table;

	private MenuBar fileBar;

	private Pane pane;

	public Filemenu(Controller controller, Table table, Stage stage) {
		this.controller = controller;
		this.stage = stage;
		this.table = table;
		fileBar = new MenuBar();
		pane = new Pane();
		addFileMenu();
		addTrainMenu();
		addSearchMenu();
		addDeleteMenu();
		pane.getChildren().add(fileBar);
	}

	public Pane getPane() {
		return pane;
	}

	private void addFileMenu() {
		fileBar.setMinWidth(1300);
		fileBar.setMaxWidth(1600);
		
		MenuItem newFile = new MenuItem("Новый файл");
		newFile.setOnAction((e) -> {
			controller.refresh();
			table.update();
		});

		MenuItem open = new MenuItem("Открыть");
		open.setOnAction((e) -> {
			ComponentCreator creator = new ComponentCreator();
			FileChooser chooser = creator.getFileChooser();
			File file = chooser.showOpenDialog(stage);
			if (file != null) {
				controller.refresh();
				List<Train> trains = controller.openFile(file);
				controller.addAmountOfTrains(trains);
				table.update();
			}
		});

		MenuItem save = new MenuItem("Сохранить");
		save.setOnAction((e) -> {
			ComponentCreator creator = new ComponentCreator();
			FileChooser chooser = creator.getFileChooser();
			File file = chooser.showSaveDialog(stage);
			if (file != null) {
				controller.saveFile(file);
			}
		});

		Menu menu = new Menu("Файл");
		menu.getItems().addAll(newFile, open, save);
		fileBar.getMenus().add(menu);
	}
	
	public void addTrainMenu() {
		MenuItem add = new MenuItem("Добавить поезд");
		add.setOnAction(e -> {
			AddTrainDialog dialog = new AddTrainDialog(controller, table);
			dialog.call();
			table.update();
		});
		Menu menu = new Menu("Добавить");
		menu.getItems().add(add);
		fileBar.getMenus().add(menu);
	}
	
	public void addSearchMenu() {
		MenuItem searchByDepOrArrStation = new MenuItem("Станция отпр. или приб.");
		searchByDepOrArrStation.setOnAction(e -> {
			SearchByDepOrArrStation dialog = new SearchByDepOrArrStation(controller);
			dialog.call();
		});
		
		MenuItem searchByNumberOrDepDate = new MenuItem("Номер или дата отпр.");
		searchByNumberOrDepDate.setOnAction(e -> {
			SearchByNumberOrDepDate dialog = new SearchByNumberOrDepDate(controller);
			dialog.call();
		});
		
		MenuItem searchByDepTimeOrArrTime = new MenuItem("Время отпр. или приб.");
		searchByDepTimeOrArrTime.setOnAction(e -> {
			SearchByDepTimeOrArrTime dialog = new SearchByDepTimeOrArrTime(controller);
			dialog.call();
		});
		
		MenuItem searchByTravelTime = new MenuItem("Время в пути");
		searchByTravelTime.setOnAction(e -> {
			SearchByTravelTime dialog = new SearchByTravelTime(controller);
			dialog.call();
		});
		
		Menu menu = new Menu("Поиск");
		menu.getItems().addAll(searchByDepOrArrStation, searchByNumberOrDepDate, searchByDepTimeOrArrTime, searchByTravelTime);
		fileBar.getMenus().add(menu);
	}
	
	public void addDeleteMenu() {
		MenuItem searchByDepOrArrStation = new MenuItem("Станция отпр. или приб.");
		searchByDepOrArrStation.setOnAction(e -> {
			DeleteByDepOrArrStation dialog = new DeleteByDepOrArrStation(controller);
			dialog.call();
			table.update();
		});
		
		MenuItem searchByNumberOrDepDate = new MenuItem("Номер или дата отпр.");
		searchByNumberOrDepDate.setOnAction(e -> {
			DeleteByNumberOrDepDate dialog = new DeleteByNumberOrDepDate(controller);
			dialog.call();
			table.update();
		});
		
		MenuItem searchByDepTimeOrArrTime = new MenuItem("Время отпр. или приб.");
		searchByDepTimeOrArrTime.setOnAction(e -> {
			DeleteByDepTimeOrArrTime dialog = new DeleteByDepTimeOrArrTime(controller);
			dialog.call();
			table.update();
		});
		
		MenuItem searchByTravelTime = new MenuItem("Время в пути");
		searchByTravelTime.setOnAction(e -> {
			DeleteByTravelTime dialog = new DeleteByTravelTime(controller);
			dialog.call();
			table.update();
		});
		
		Menu menu = new Menu("Удаление");
		menu.getItems().addAll(searchByDepOrArrStation, searchByNumberOrDepDate, searchByDepTimeOrArrTime, searchByTravelTime);
		fileBar.getMenus().add(menu);
	}
}
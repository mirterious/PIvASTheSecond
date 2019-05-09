package view;

import java.io.File;
import java.util.List;
import model.Train;
import view.dialogs.AddTrainDialog;
import view.dialogs.SearchByDepStationOrArrStation;
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
		configureFileMenu();
		addTrainMenu();
		addSearchMenu();
		addDeleteMenu();
		pane.getChildren().add(fileBar);
	}

	public Pane getPane() {
		return pane;
	}

	private void configureFileMenu() {
		fileBar.setMinWidth(1200);
		fileBar.setMaxWidth(1600);
		
		MenuItem newFile = new MenuItem("New file");
		newFile.setOnAction((e) -> {
			controller.refresh();
			table.update();
		});

		MenuItem open = new MenuItem("Open file");
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

		MenuItem save = new MenuItem("Save as");
		save.setOnAction((e) -> {
			ComponentCreator creator = new ComponentCreator();
			FileChooser chooser = creator.getFileChooser();
			File file = chooser.showSaveDialog(stage);
			if (file != null) {
				controller.saveFile(file);
			}
		});

		Menu menu = new Menu("File");
		menu.getItems().addAll(newFile, open, save);
		fileBar.getMenus().add(menu);
	}
	
	public void addTrainMenu() {
		MenuItem add = new MenuItem("Add Train");
		add.setOnAction(e -> {
			AddTrainDialog dialog = new AddTrainDialog(controller, table);
			dialog.call();
			table.update();
		});
		Menu menu = new Menu("Add");
		menu.getItems().add(add);
		fileBar.getMenus().add(menu);
	}
	
	public void addSearchMenu() {
		MenuItem searchByDepOrArrStation = new MenuItem("DepOrArrStation");
		searchByDepOrArrStation.setOnAction(e -> {
			SearchByDepStationOrArrStation dialog = new SearchByDepStationOrArrStation(controller);
			dialog.call();
		});
		
		MenuItem searchByNumberOrDepDate = new MenuItem("Number or Dep Date");
		searchByNumberOrDepDate.setOnAction(e -> {
			SearchByNumberOrDepDate dialog = new SearchByNumberOrDepDate(controller);
			dialog.call();
		});
		
		MenuItem searchByDepTimeOrArrTime = new MenuItem("Dep/Arr Time");
		searchByDepTimeOrArrTime.setOnAction(e -> {
			SearchByDepTimeOrArrTime dialog = new SearchByDepTimeOrArrTime(controller);
			dialog.call();
		});
		
		MenuItem searchByTravelTime = new MenuItem("Travel time");
		searchByTravelTime.setOnAction(e -> {
			SearchByTravelTime dialog = new SearchByTravelTime(controller);
			dialog.call();
		});
		
		Menu menu = new Menu("Search");
		menu.getItems().addAll(searchByDepOrArrStation, searchByNumberOrDepDate, searchByDepTimeOrArrTime, searchByTravelTime);
		fileBar.getMenus().add(menu);
	}
	
	public void addDeleteMenu() {
		MenuItem deleteByDepOrArrStation = new MenuItem("DepOrArrStation");
		deleteByDepOrArrStation.setOnAction(e -> {
			SearchByDepStationOrArrStation dialog = new SearchByDepStationOrArrStation(controller);
			dialog.call();
		});
		
		MenuItem deleteByNumberOrDepDate = new MenuItem("Number or Dep Date");
		deleteByNumberOrDepDate.setOnAction(e -> {
			SearchByNumberOrDepDate dialog = new SearchByNumberOrDepDate(controller);
			dialog.call();
		});
		
		MenuItem deleteByDepTimeOrArrTime = new MenuItem("Dep/Arr Time");
		deleteByDepTimeOrArrTime.setOnAction(e -> {
			SearchByNumberOrDepDate dialog = new SearchByNumberOrDepDate(controller);
			dialog.call();
		});
		
		MenuItem deleteByTravelTime = new MenuItem("Travel time");
		deleteByTravelTime.setOnAction(e -> {
			SearchByTravelTime dialog = new SearchByTravelTime(controller);
			dialog.call();
		});
		
		Menu menu = new Menu("Delete");
		menu.getItems().addAll(deleteByDepOrArrStation, deleteByNumberOrDepDate, deleteByDepTimeOrArrTime, deleteByTravelTime);
		fileBar.getMenus().add(menu);
	}
}
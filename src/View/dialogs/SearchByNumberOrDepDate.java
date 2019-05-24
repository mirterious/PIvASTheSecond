package view.dialogs;

import java.util.HashSet;
import java.util.Set;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Train;
import view.ComponentCreator;
import view.Table;
import view.dialogs.panes.NumberOrDepDatePane;

public class SearchByNumberOrDepDate {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	private NumberOrDepDatePane pane;
	
	public SearchByNumberOrDepDate(Controller controller) {
		this.controller = controller;
		table = new Table(controller.copy());
		pane = new NumberOrDepDatePane();
		stage = new Stage();
		mainPane = new VBox();
		creator = new ComponentCreator();
		table.update();
		buildDialog();
	}
	
	private void buildDialog() {
		
		Button search = creator.getButton("Найти");
		search.setOnAction(e -> {
			Set<Train> trains = new HashSet<>();
			trains.addAll(controller.searchByNumber(pane.getNumber()));
			trains.addAll(controller.searchByDepDate(pane.getDate()));
			table.recreate();
			table.addContent(trains);
			table.update();
		});
		mainPane.getChildren().addAll(pane.getPane(), search, table.getPane());	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Поиск по номеру или дате отправления");
		stage.setHeight(600);
		stage.setWidth(1200);
		stage.show();
	}
}

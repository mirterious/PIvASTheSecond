package view;

import model.Schedule;
import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {

	private Stage stage;

	private Pane mainPane;

	private Controller controller;

	private Table table;
	
	private Filemenu menu;

	public View(Stage stage) {
		this.stage = stage;
		Schedule model = new Schedule();
		mainPane = new VBox();
		controller = new Controller(model);
		table = new Table(model.getTrains());
		menu = new Filemenu(controller, table, stage);
		configure();
	}

	public void show() {
		stage.show();
	}

	private void configure() {
		Pane pane = new VBox();
		pane.getChildren().addAll(table.getPane());
		mainPane.getChildren().addAll(menu.getPane(), pane);
		stage.setScene(new Scene(mainPane));
		stage.setMinHeight(500);
		stage.setMinWidth(800);
	}
}
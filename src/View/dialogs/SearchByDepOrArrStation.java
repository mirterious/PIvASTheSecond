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
import view.dialogs.panes.DepOrArrStationPane;

public class SearchByDepOrArrStation {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	private DepOrArrStationPane pane;
	
	public SearchByDepOrArrStation(Controller controller) {
		this.controller = controller;
		table = new Table(controller.copy());
		pane = new DepOrArrStationPane();
		stage = new Stage();
		mainPane = new VBox();
		creator = new ComponentCreator();
		mainPane.getChildren().addAll(pane.getPane());
		table.update();
		buildDialog();
	}
	
	private void buildDialog() {
		Button search = creator.getButton("Найти");
		search.setOnAction(e -> {
			Set<Train> trains = new HashSet<>();
			trains.addAll(controller.searchByDepStation(pane.getDepStation()));
			trains.addAll(controller.searchByArrStation(pane.getArrStation()));
			table.recreate();
			table.addContent(trains);
			table.update();
		});
		mainPane.getChildren().addAll(search, table.getPane());
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Поиск по станции прибытия или отправления");
		stage.setHeight(600);
		stage.setWidth(1200);
		stage.show();
	}
}

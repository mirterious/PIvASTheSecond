package view.dialogs;

import java.util.ArrayList;
import java.util.List;
import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Train;
import view.ComponentCreator;
import view.Table;

public class SearchByDepStationOrArrStation {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	public SearchByDepStationOrArrStation(Controller controller) {
		this.controller = controller;
		table = new Table(controller.copy());
		table.update();
		stage = new Stage();
		mainPane = new VBox();
		creator = new ComponentCreator();
		buildDialog();
	}
	
	private void buildDialog() {
		
		GridPane pane = new GridPane();
		
		Label depStationLabel = creator.getLabel("Dep Station");
		pane.add(depStationLabel, 0, 0);
		
		Label arrStationLabel = creator.getLabel("Arr Station");
		pane.add(arrStationLabel, 0, 1);
		
		TextField departureStationText = creator.getTextField();
		pane.add(departureStationText, 1, 0);
		
		TextField arrivingStationText = creator.getTextField();
		pane.add(arrivingStationText, 1, 1);
		
		Button addTrain = creator.getButton("Search");
		addTrain.setOnAction(e -> {
			List<Train> trains = new ArrayList<>();
			trains.addAll(controller.searchByDepStation(departureStationText.getText()));
			trains.addAll(controller.searchByArrStation(arrivingStationText.getText()));
			table.recreate();
			table.addContent(trains);
			table.update();
		});
		pane.add(addTrain, 0, 4);
		pane.setHgap(10);
		pane.setVgap(10);
		mainPane.getChildren().addAll(pane, table.getPane());	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Searching");
		stage.setHeight(500);
		stage.setWidth(1200);
		stage.show();
	}
}
package view.dialogs;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.ComponentCreator;
import view.Table;

public class DeleteByDepOrArrStation {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	public DeleteByDepOrArrStation(Controller controller) {
		this.controller = controller;
		table = new Table(controller.getTrains());
		stage = new Stage();
		mainPane = new VBox();
		creator = new ComponentCreator();
		buildDialog();
		table.update();
	}
	
	private void buildDialog() {
		
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		
		Label depStationLabel = creator.getLabel("Dep Station");
		pane.add(depStationLabel, 0, 0);
		
		Label arrStationLabel = creator.getLabel("Arr Station");
		pane.add(arrStationLabel, 0, 1);
		
		TextField departureStationText = creator.getTextField();
		pane.add(departureStationText, 1, 0);
		
		TextField arrivingStationText = creator.getTextField();
		pane.add(arrivingStationText, 1, 1);
		
		Button delete = creator.getButton("Delete");
		delete.setOnAction(e -> {
			controller.deleteByDepStation(departureStationText.getText());
			controller.deleteByArrStation(arrivingStationText.getText());
			table.update();
		});
		pane.add(delete, 0, 4);

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

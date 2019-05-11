package view.dialogs;

import controller.Controller;
import controller.DateAndTimeParser;
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

public class DeleteByTravelTime {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	private DateAndTimeParser parser;
	
	public DeleteByTravelTime(Controller controller) {
		this.controller = controller;
		table = new Table(controller.getTrains());
		table.update();
		parser = new DateAndTimeParser();
		stage = new Stage();
		mainPane = new VBox();
		creator = new ComponentCreator();
		buildDialog();
	}
	
	private void buildDialog() {
		
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		
		Label travelTimeLabel = creator.getLabel("Travel Time");
		pane.add(travelTimeLabel, 0, 0);
		
		Label travelTimeExampleLabel = creator.getLabel("Y M D H M");
		pane.add(travelTimeExampleLabel, 0, 1);
		
		TextField travelTimeText = creator.getTextField();
		pane.add(travelTimeText, 1, 1);
		
		Button addTrain = creator.getButton("Delete");
		addTrain.setOnAction(e -> {
			controller.deleteByTravelTime(parser.convertToTravelTime(travelTimeText.getText()));
			table.update();
		});
		pane.add(addTrain, 0, 4);
		
		mainPane.getChildren().addAll(pane, table.getPane());	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Deleting");
		stage.setHeight(500);
		stage.setWidth(1200);
		stage.show();
	}
}

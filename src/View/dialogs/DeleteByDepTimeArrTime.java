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

public class DeleteByDepTimeArrTime {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	private DateAndTimeParser parser;
	
	public DeleteByDepTimeArrTime(Controller controller) {
		this.controller = controller;
		table = new Table(controller.getTrains());
		stage = new Stage();
		parser = new DateAndTimeParser();
		mainPane = new VBox();
		creator = new ComponentCreator();
		table.update();	
		buildDialog();
	}
	
	private void buildDialog() {
		
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		
		Label depStationLabel = creator.getLabel("Bottom border");
		pane.add(depStationLabel, 2, 0);
		
		Label arrStationLabel = creator.getLabel("Top border");
		pane.add(arrStationLabel, 2, 1);
		
		TextField depatureBottomText = creator.getTextField();
		pane.add(depatureBottomText, 0, 0);
		
		TextField departureTopText = creator.getTextField();
		pane.add(departureTopText, 0, 1);
		
		Label delTimeLabel = creator.getLabel("Dep time");
		pane.add(delTimeLabel, 0, 2);
		
		TextField arrivingBottomText = creator.getTextField();
		pane.add(arrivingBottomText, 1, 1);
		
		TextField arrivingTopText = creator.getTextField();
		pane.add(arrivingTopText, 1, 0);
		
		Label arrTimeLabel = creator.getLabel("Arr time");
		pane.add(arrTimeLabel, 1, 2);
		
		Button delete = creator.getButton("Delete");
		delete.setOnAction(e -> {
			controller.deleteByDepTime(parser.convertToTime(departureTopText.getText()), 
					parser.convertToTime(depatureBottomText.getText()));
			controller.deleteByArrTime(parser.convertToTime(arrivingTopText.getText()), 
					parser.convertToTime(arrivingBottomText.getText()));
			table.update();
		});
		pane.add(delete, 0, 4);

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

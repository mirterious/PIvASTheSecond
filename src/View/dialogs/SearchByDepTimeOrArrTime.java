package view.dialogs;

import java.util.ArrayList;
import java.util.List;
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
import model.Train;
import view.ComponentCreator;
import view.Table;

public class SearchByDepTimeOrArrTime {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	private DateAndTimeParser parser;
	
	public SearchByDepTimeOrArrTime(Controller controller) {
		this.controller = controller;
		table = new Table(controller.copy());
		table.update();
		stage = new Stage();
		parser = new DateAndTimeParser();
		mainPane = new VBox();
		creator = new ComponentCreator();
		buildDialog();
	}
	
	private void buildDialog() {
		
		GridPane pane = new GridPane();
		
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
		
		Button search = creator.getButton("Search");
		search.setOnAction(e -> {
			List<Train> trains = new ArrayList<>();
			if(!departureTopText.getText().isEmpty()) {
				trains.addAll(controller.searchByDepTime(parser.convertToTime(departureTopText.getText()),
						parser.convertToTime(depatureBottomText.getText())));
			}
			if(!arrivingTopText.getText().isEmpty()) {
				trains.addAll(controller.searchByArrTime(parser.convertToTime(arrivingTopText.getText()),
						parser.convertToTime(arrivingBottomText.getText())));
			}
			table.recreate();
			table.addContent(trains);
			table.update();
		});
		pane.add(search, 0, 4);
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

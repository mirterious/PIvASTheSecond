package view.dialogs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import controller.Controller;
import controller.DateAndTimeParser;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Station;
import model.Train;
import view.ComponentCreator;
import view.Table;

public class AddTrainDialog {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	private DateAndTimeParser parser;
	
	public AddTrainDialog(Controller controller, Table table) {
		this.controller = controller;
		this.table = table;
		stage = new Stage();
		mainPane = new HBox();
		creator = new ComponentCreator();
		parser = new DateAndTimeParser();
		buildDialog();
	}
	
	private void buildDialog() {
		
		GridPane pane = new GridPane();
		
		TextField numberText = creator.getTextField();
		pane.add(numberText, 0, 0);
		
		Label numberLabel = creator.getLabel("Number");
		pane.add(numberLabel, 0, 1);
		
		Label depStationLabel = creator.getLabel("Dep Station");
		pane.add(depStationLabel, 1, 0);
		
		Label arrStationLabel = creator.getLabel("Arr Station");
		pane.add(arrStationLabel, 1, 1);
		
		TextField departureStationText = creator.getTextField();
		pane.add(departureStationText, 2, 0);
		
		TextField arrivingStationText = creator.getTextField();
		pane.add(arrivingStationText, 2, 1);

		Label depDateLabel = creator.getLabel("Dep Date");
		pane.add(depDateLabel, 3, 0);
		
		Label arrDateLabel = creator.getLabel("Arr Date");
		pane.add(arrDateLabel, 3, 1);
		
		DatePicker departureDateText = creator.getDatePicker();
		pane.add(departureDateText, 4, 0);

		DatePicker arrivingDateText = creator.getDatePicker();
		pane.add(arrivingDateText, 4, 1);
		
		TextField departureTimeText = creator.getTextField();
		pane.add(departureTimeText, 5, 0);
		
		TextField arrivingTimeText = creator.getTextField();
		pane.add(arrivingTimeText, 5, 1);
		
		Label departureTimeLabel = creator.getLabel("Departure Time");
		pane.add(departureTimeLabel, 6, 0);
		
		Label arrivingTimeLabel = creator.getLabel("Arriving Time");
		pane.add(arrivingTimeLabel, 6, 1);
		
		Button addTrain = creator.getButton("Add");
		addTrain.setOnAction(e -> {
			String number = numberText.getText();
			Station departureStation = new Station(departureStationText.getText());
			Station arrivingStation = new Station(arrivingStationText.getText());
			LocalDate departureDate = departureDateText.getValue();
			LocalDate arrivingDate = arrivingDateText.getValue();
			LocalTime departureTime = parser.convertToTime(departureTimeText.getText());
			LocalTime arrivingTime = parser.convertToTime(arrivingTimeText.getText());
			LocalDateTime departureSchedule = LocalDateTime.of(departureDate, departureTime);
			LocalDateTime arrivingSchedule = LocalDateTime.of(arrivingDate, arrivingTime);
			Train train = new Train(number, departureStation, arrivingStation, departureSchedule, arrivingSchedule);
			controller.addTrain(train);
			table.update();
		});
		pane.add(addTrain, 3, 4);
		pane.setHgap(10);
		pane.setVgap(10);
		mainPane.getChildren().addAll(pane);	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Add new train");
		stage.setHeight(230);
		stage.setWidth(800);
		stage.show();
	}
}

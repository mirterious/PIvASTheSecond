package view.dialogs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import controller.Controller;
import controller.DateAndTimeParser;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
		
		Label numberLabel = creator.getLabel("Номер");
		pane.add(numberLabel, 0, 1);
		
		Label depStationLabel = creator.getLabel("Ст. отпр.");
		pane.add(depStationLabel, 1, 0);
		
		Label arrStationLabel = creator.getLabel("Ст. приб.");
		pane.add(arrStationLabel, 1, 1);
		
		TextField departureStationText = creator.getTextField();
		pane.add(departureStationText, 2, 0);
		
		TextField arrivingStationText = creator.getTextField();
		pane.add(arrivingStationText, 2, 1);

		Label depDateLabel = creator.getLabel("Дата отпр.");
		pane.add(depDateLabel, 3, 0);
		
		Label arrDateLabel = creator.getLabel("Дата приб.");
		pane.add(arrDateLabel, 3, 1);
		
		DatePicker departureDateText = creator.getDatePicker();
		pane.add(departureDateText, 4, 0);

		DatePicker arrivingDateText = creator.getDatePicker();
		pane.add(arrivingDateText, 4, 1);
		
		TextField departureTimeTextHours = creator.getTextField();
		pane.add(departureTimeTextHours, 5, 0);
		
		Label departureTimeHoursLabel = creator.getLabel("Часы");
		pane.add(departureTimeHoursLabel, 5, 2);
		
		TextField departureTimeTextMinutes = creator.getTextField();
		pane.add(departureTimeTextMinutes, 6, 0);
		
		Label departureTimeMinutesLabel = creator.getLabel("Минуты");
		pane.add(departureTimeMinutesLabel, 6, 2);
		
		TextField arrivingTimeTextHours = creator.getTextField();
		pane.add(arrivingTimeTextHours, 5, 1);
		
		TextField arrivingTimeTextMinutes = creator.getTextField();
		pane.add(arrivingTimeTextMinutes, 6, 1);
		
		Label departureTimeLabel = creator.getLabel("Время отправления");
		pane.add(departureTimeLabel, 8, 0);
		
		Label arrivingTimeLabel = creator.getLabel("Время прибытия");
		pane.add(arrivingTimeLabel, 8, 1);
		
		Button addTrain = creator.getButton("Add");
		addTrain.setOnAction(e -> {
			String number = numberText.getText();
			Station departureStation = new Station(departureStationText.getText());
			Station arrivingStation = new Station(arrivingStationText.getText());
			LocalDate departureDate = departureDateText.getValue();
			LocalDate arrivingDate = arrivingDateText.getValue();
			String depTime = new String();
			String arrTime = new String();
			if (!departureTimeTextHours.getText().isEmpty() && !departureTimeTextMinutes.getText().isEmpty()) {
				depTime = departureTimeTextHours.getText() + ":" + departureTimeTextMinutes.getText();
			}
			if (!arrivingTimeTextHours.getText().isEmpty() && !arrivingTimeTextMinutes.getText().isEmpty()) {
				arrTime = arrivingTimeTextHours.getText() + ":" + arrivingTimeTextMinutes.getText();
			}
			LocalTime departureTime = parser.convertToTime(depTime);
			LocalTime arrivingTime = parser.convertToTime(arrTime);
			LocalDateTime departureSchedule = LocalDateTime.of(departureDate, departureTime);
			LocalDateTime arrivingSchedule = LocalDateTime.of(arrivingDate, arrivingTime);
			Train train = new Train(number, departureStation, arrivingStation, departureSchedule, arrivingSchedule);
			if (departureSchedule.isAfter(arrivingSchedule)) {
				showAlert("Неверно введена дата");
				departureTimeTextHours.setText("");
				departureTimeTextMinutes.setText("");
				arrivingTimeTextHours.setText("");
				arrivingTimeTextMinutes.setText("");
				departureDateText.setValue(LocalDate.now());	
				arrivingDateText.setValue(LocalDate.now());
			} else {
				controller.addTrain(train);
				table.update();
			}
		});
		pane.add(addTrain, 4, 4);
		pane.setHgap(10);
		pane.setVgap(10);
		mainPane.getChildren().addAll(pane);	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Добавление поезда");
		stage.setHeight(230);
		stage.setWidth(950);
		stage.show();
	}
	
	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Ошибка");
		alert.setContentText(message);
		alert.showAndWait();
	}
}

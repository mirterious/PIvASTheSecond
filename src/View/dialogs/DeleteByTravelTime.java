package view.dialogs;

import controller.Controller;
import controller.DateAndTimeParser;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.ComponentCreator;

public class DeleteByTravelTime {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private DateAndTimeParser parser;
	
	public DeleteByTravelTime(Controller controller) {
		this.controller = controller;
		parser = new DateAndTimeParser();
		stage = new Stage();
		mainPane = new VBox();
		creator = new ComponentCreator();
		buildDialog();
	}
	
	private void buildDialog() {
		
		GridPane pane = new GridPane();
		
		
		TextField yearsText = creator.getTextField();
		pane.add(yearsText, 0, 0);
		
		Label yearsExampleLabel = creator.getLabel("Кол-во лет");
		pane.add(yearsExampleLabel, 1, 0);
		
		TextField monthsText = creator.getTextField();
		pane.add(monthsText, 0, 1);
		
		Label monthsExampleLabel = creator.getLabel("Кол-во месяцев");
		pane.add(monthsExampleLabel, 1, 1);
		
		TextField daysText = creator.getTextField();
		pane.add(daysText, 0, 2);
		
		Label daysExampleLabel = creator.getLabel("Кол-во дней");
		pane.add(daysExampleLabel, 1, 2);
		
		TextField hoursText = creator.getTextField();
		pane.add(hoursText, 0, 3);
		
		Label hoursExampleLabel = creator.getLabel("Кол-во часов");
		pane.add(hoursExampleLabel, 1, 3);
		
		TextField minutesText = creator.getTextField();
		pane.add(minutesText, 0, 4);
		
		Label minutesExampleLabel = creator.getLabel("Кол-во минут");
		pane.add(minutesExampleLabel, 1, 4);
		
		Button delete = creator.getButton("Удалить");
		delete.setOnAction(e -> {
			String travelTime = yearsText.getText() + " "
					+ monthsText.getText() + " " 
					+ daysText.getText() + " " 
					+ hoursText.getText() + " " 
					+ minutesText.getText();
			int recordsBeforeDeleting = controller.getTrains().size();
			controller.deleteByTravelTime(parser.convertToTravelTime(travelTime));
			int count = recordsBeforeDeleting - controller.getTrains().size();
			showAlert("Удалено " + count + " Записей");
		});
		pane.add(delete, 0, 5);
		pane.setHgap(8);
		pane.setVgap(10);
		mainPane.getChildren().addAll(pane);	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Удаление по времени в пути");
		stage.setHeight(340);
		stage.setWidth(220);
		stage.show();
	}
	
	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Успех");
		alert.setContentText(message);
		alert.showAndWait();
	}
}

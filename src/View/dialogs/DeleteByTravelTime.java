package view.dialogs;

import controller.Controller;
import controller.DateAndTimeParser;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.ComponentCreator;
import view.dialogs.panes.TravelTimePane;

public class DeleteByTravelTime {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private DateAndTimeParser parser;
	
	private TravelTimePane pane;
	
	public DeleteByTravelTime(Controller controller) {
		this.controller = controller;
		parser = new DateAndTimeParser();
		pane = new TravelTimePane();
		stage = new Stage();
		mainPane = new VBox();
		creator = new ComponentCreator();
		buildDialog();
	}
	
	private void buildDialog() {		
		Button delete = creator.getButton("Удалить");
		delete.setOnAction(e -> {
			String travelTime = pane.getYears() + " "
					+ pane.getMonth() + " " 
					+ pane.getDays() + " " 
					+ pane.getHours() + " " 
					+ pane.getMinutes();
			int recordsBeforeDeleting = controller.getTrains().size();
			controller.deleteByTravelTime(parser.convertToTravelTime(travelTime));
			int count = recordsBeforeDeleting - controller.getTrains().size();
			showAlert("Удалено " + count + " Записей");
		});
		mainPane.getChildren().addAll(pane.getPane(), delete);	
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

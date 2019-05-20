package view.dialogs;

import controller.Controller;
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

public class DeleteByDepOrArrStation {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	public DeleteByDepOrArrStation(Controller controller) {
		this.controller = controller;
		stage = new Stage();
		mainPane = new VBox();
		creator = new ComponentCreator();
		buildDialog();
	}
	
	private void buildDialog() {
		
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		
		Label depStationLabel = creator.getLabel("Ст. отправления");
		pane.add(depStationLabel, 1, 0);
		
		Label arrStationLabel = creator.getLabel("Ст. прибытия");
		pane.add(arrStationLabel, 1, 1);
		
		TextField departureStationText = creator.getTextField();
		pane.add(departureStationText, 0, 0);
		
		TextField arrivingStationText = creator.getTextField();
		pane.add(arrivingStationText, 0, 1);
		
		Button delete = creator.getButton("Удалить");
		delete.setOnAction(e -> {
			int recordsBeforeDeleting = controller.getTrains().size();
			controller.deleteByDepStation(departureStationText.getText());
			controller.deleteByArrStation(arrivingStationText.getText());
			int count = recordsBeforeDeleting - controller.getTrains().size();
			showAlert("Удалено " + count + " Записей");
		});
		pane.add(delete, 4, 0);

		mainPane.getChildren().addAll(pane);	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Удаление по станции прибытия или отправления");
		stage.setHeight(150);
		stage.setWidth(400);
		stage.show();
	}
	
	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Успех");
		alert.setContentText(message);
		alert.showAndWait();
	}
}

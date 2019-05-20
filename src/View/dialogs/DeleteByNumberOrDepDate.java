package view.dialogs;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.ComponentCreator;

public class DeleteByNumberOrDepDate {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	public DeleteByNumberOrDepDate(Controller controller) {
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
		
		Label numberLabel = creator.getLabel("Номер");
		pane.add(numberLabel, 0, 0);
		
		Label depDateLabel = creator.getLabel("Дата отпр.");
		pane.add(depDateLabel, 0, 1);
		
		TextField numberText = creator.getTextField();
		pane.add(numberText, 1, 0);
		
		DatePicker depDateText = creator.getDatePicker();
		pane.add(depDateText, 1, 1);
		
		Button delete = creator.getButton("Удалить");
		delete.setOnAction(e -> {
			int recordsBeforeDeleting = controller.getTrains().size();
			controller.deleteByNumber(numberText.getText());
			controller.deleteByDepDate(depDateText.getValue());
			int count = recordsBeforeDeleting - controller.getTrains().size();
			showAlert("Удалено " + count + " Записей");
		});
		pane.add(delete, 0, 4);

		mainPane.getChildren().addAll(pane);	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Удаление по номеру или дате отправления");
		stage.setHeight(200);
		stage.setWidth(250);
		stage.show();
	}
	
	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Успех");
		alert.setContentText(message);
		alert.showAndWait();
	}
}

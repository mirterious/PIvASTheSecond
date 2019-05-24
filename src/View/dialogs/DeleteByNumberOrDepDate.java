package view.dialogs;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.ComponentCreator;
import view.dialogs.panes.NumberOrDepDatePane;

public class DeleteByNumberOrDepDate {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private NumberOrDepDatePane pane;
	
	public DeleteByNumberOrDepDate(Controller controller) {
		this.controller = controller;
		pane = new NumberOrDepDatePane();
		stage = new Stage();
		mainPane = new VBox();
		creator = new ComponentCreator();
		buildDialog();
	}
	
	private void buildDialog() {
		Button delete = creator.getButton("Удалить");
		delete.setOnAction(e -> {
			int recordsBeforeDeleting = controller.getTrains().size();
			controller.deleteByNumber(pane.getNumber());
			controller.deleteByDepDate(pane.getDate());
			int count = recordsBeforeDeleting - controller.getTrains().size();
			showAlert("Удалено " + count + " Записей");
		});

		mainPane.getChildren().addAll(pane.getPane(), delete);	
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

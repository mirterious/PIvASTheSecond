package view.dialogs;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.ComponentCreator;
import view.dialogs.panes.DepOrArrStationPane;

public class DeleteByDepOrArrStation {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private DepOrArrStationPane pane;
	
	public DeleteByDepOrArrStation(Controller controller) {
		this.controller = controller;
		stage = new Stage();
		mainPane = new HBox();
		creator = new ComponentCreator();
		pane = new DepOrArrStationPane();
		mainPane.getChildren().add(pane.getPane());
		buildDialog();
	}
	
	private void buildDialog() {
		Button delete = creator.getButton("Удалить");
		delete.setOnAction(e -> {
			int recordsBeforeDeleting = controller.getTrains().size();
			controller.deleteByDepStation(pane.getDepStation());
			controller.deleteByArrStation(pane.getArrStation());
			int count = recordsBeforeDeleting - controller.getTrains().size();
			showAlert("Удалено " + count + " Записей");
		});
		mainPane.getChildren().add(delete);
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

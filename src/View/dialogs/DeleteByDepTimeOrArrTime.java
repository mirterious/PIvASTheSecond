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
import view.dialogs.panes.DepTimeOrArrTimePane;

public class DeleteByDepTimeOrArrTime {

	private Stage stage;

	private Controller controller;

	private ComponentCreator creator;

	private Pane mainPane;

	private DateAndTimeParser parser;
	
	private DepTimeOrArrTimePane pane;

	public DeleteByDepTimeOrArrTime(Controller controller) {
		this.controller = controller;
		stage = new Stage();
		parser = new DateAndTimeParser();
		mainPane = new VBox();
		creator = new ComponentCreator();
		pane = new DepTimeOrArrTimePane();
		mainPane.getChildren().add(pane.getPane());
		buildDialog();
	}

	private void buildDialog() {
		Button delete = creator.getButton("Удалить");
		delete.setOnAction(e -> {
			String depTimeBot = new String();
			String depTimeTop = new String();
			String arrTimeBot = new String();
			String arrTimeTop = new String();
			if (!pane.getDepBotHours().equals("") && !pane.getDepBotMinutes().equals("")) {
				depTimeBot = pane.getDepBotHours() + ":" + pane.getDepBotMinutes();
			}
			if (!pane.getDepTopHours().equals("") && !pane.getDepTopMinutes().equals("")) {
				depTimeTop = pane.getDepTopHours() + ":" + pane.getDepTopMinutes();
			}
			if (!pane.getArrBotHours().equals("") && !pane.getArrBotMinutes().equals("")) {
				arrTimeBot = pane.getArrBotHours() + ":" + pane.getArrBotMinutes();
			}
			if (!pane.getArrTopHours().equals("") && !pane.getArrTopMinutes().equals("")) {
				arrTimeTop = pane.getArrTopHours() + ":" + pane.getArrTopMinutes();
			}
			int recordsBeforeDeleting = controller.getTrains().size();
			if (!depTimeBot.isEmpty() && !depTimeTop.isEmpty()) {
				controller.deleteByDepTime(parser.convertToTime(depTimeTop), parser.convertToTime(depTimeBot));
			}
			if (!arrTimeBot.isEmpty() && !arrTimeTop.isEmpty()) {
				controller.deleteByArrTime(parser.convertToTime(arrTimeTop), parser.convertToTime(arrTimeBot));
			}
			int count = recordsBeforeDeleting - controller.getTrains().size();
			showAlert("Удалено " + count + " Записей");
		});
		mainPane.getChildren().add(delete);
	}

	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Удаления по времени отправления или прибытия");
		stage.setHeight(280);
		stage.setWidth(340);
		stage.show();
	}

	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Успех");
		alert.setContentText(message);
		alert.showAndWait();
	}
}

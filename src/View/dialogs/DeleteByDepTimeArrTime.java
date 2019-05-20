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

public class DeleteByDepTimeArrTime {

	private Stage stage;

	private Controller controller;

	private ComponentCreator creator;

	private Pane mainPane;

	private DateAndTimeParser parser;

	public DeleteByDepTimeArrTime(Controller controller) {
		this.controller = controller;
		stage = new Stage();
		parser = new DateAndTimeParser();
		mainPane = new VBox();
		creator = new ComponentCreator();
		buildDialog();
	}

	private void buildDialog() {

		GridPane pane = new GridPane();
		pane.setHgap(10);

		Label depatureBottomLabelHours = creator.getLabel("����");
		pane.add(depatureBottomLabelHours, 0, 0);

		Label depatureBottomLabelMinutes = creator.getLabel("������");
		pane.add(depatureBottomLabelMinutes, 1, 0);

		TextField depatureBottomTextHours = creator.getTextField();
		pane.add(depatureBottomTextHours, 0, 1);

		TextField depatureBottomTextMinutes = creator.getTextField();
		pane.add(depatureBottomTextMinutes, 1, 1);

		Label departureBottomLabel = creator.getLabel("������ ����.");
		pane.add(departureBottomLabel, 3, 1);

		TextField departureTopTextHours = creator.getTextField();
		pane.add(departureTopTextHours, 0, 2);

		TextField departureTopTextMinutes = creator.getTextField();
		pane.add(departureTopTextMinutes, 1, 2);

		Label departureTopLabel = creator.getLabel("������� ����.");
		pane.add(departureTopLabel, 3, 2);

		TextField arrivingBottomTextHours = creator.getTextField();
		pane.add(arrivingBottomTextHours, 0, 3);

		TextField arrivingBottomTextMinutes = creator.getTextField();
		pane.add(arrivingBottomTextMinutes, 1, 3);

		Label arrivingBottomLabel = creator.getLabel("������ ����.");
		pane.add(arrivingBottomLabel, 3, 3);

		TextField arrivingTopTextHours = creator.getTextField();
		pane.add(arrivingTopTextHours, 0, 4);

		TextField arrivingTopTextMinutes = creator.getTextField();
		pane.add(arrivingTopTextMinutes, 1, 4);

		Label arrivingTopLabel = creator.getLabel("������� ����.");
		pane.add(arrivingTopLabel, 3, 4);

		Button delete = creator.getButton("�������");
		delete.setOnAction(e -> {
			String depTimeBot = new String();
			String depTimeTop = new String();
			String arrTimeBot = new String();
			String arrTimeTop = new String();
			if (!depatureBottomTextHours.getText().isEmpty() && !depatureBottomTextMinutes.getText().isEmpty()) {
				depTimeBot = depatureBottomTextHours.getText() + ":" + depatureBottomTextMinutes.getText();
			}
			if (!departureTopTextHours.getText().isEmpty() && !departureTopTextMinutes.getText().isEmpty()) {
				depTimeTop = departureTopTextHours.getText() + ":" + departureTopTextMinutes.getText();
			}
			if (!arrivingBottomTextHours.getText().isEmpty() && !arrivingBottomTextMinutes.getText().isEmpty()) {
				arrTimeBot = arrivingBottomTextHours.getText() + ":" + arrivingBottomTextMinutes.getText();
			}
			if (!arrivingTopTextHours.getText().isEmpty() && !arrivingTopTextHours.getText().isEmpty()) {
				arrTimeTop = arrivingTopTextHours.getText() + ":" + arrivingTopTextMinutes.getText();
			}
			int recordsBeforeDeleting = controller.getTrains().size();
			if (!depTimeBot.isEmpty() && !depTimeTop.isEmpty()) {
				controller.deleteByDepTime(parser.convertToTime(depTimeTop), parser.convertToTime(depTimeBot));
			}
			if (!arrTimeBot.isEmpty() && !arrTimeTop.isEmpty()) {
				controller.deleteByArrTime(parser.convertToTime(arrTimeTop), parser.convertToTime(arrTimeBot));
			}
			int count = recordsBeforeDeleting - controller.getTrains().size();
			showAlert("������� " + count + " �������");
		});
		pane.add(delete, 0, 5);
		pane.setVgap(1);
		mainPane.getChildren().addAll(pane);
	}

	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("�������� �� ������� ����������� ��� ��������");
		stage.setHeight(280);
		stage.setWidth(340);
		stage.show();
	}

	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("�����");
		alert.setContentText(message);
		alert.showAndWait();
	}
}

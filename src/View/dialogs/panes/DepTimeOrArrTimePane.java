package view.dialogs.panes;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import view.ComponentCreator;

public class DepTimeOrArrTimePane {
	private ComponentCreator creator;
	
	private TextField depTimeTopHours;
	
	private TextField depTimeTopMinutes;
	
	private TextField depTimeBotHours;
	
	private TextField depTimeBotMinutes;
	
	private TextField arrTimeTopHours;
	
	private TextField arrTimeTopMinutes;
	
	private TextField arrTimeBotHours;
	
	private TextField arrTimeBotMinutes;
	
	private GridPane mainPane;
	
	public DepTimeOrArrTimePane() {
		creator = new ComponentCreator();
		mainPane = new GridPane();
		depTimeTopHours = creator.getTextField();
		depTimeTopMinutes = creator.getTextField();
		depTimeBotHours = creator.getTextField();
		depTimeBotMinutes = creator.getTextField();
		arrTimeTopHours = creator.getTextField();
		arrTimeTopMinutes = creator.getTextField();
		arrTimeBotHours = creator.getTextField();
		arrTimeBotMinutes = creator.getTextField();
		buildPane();
	}
	
	public void buildPane() {
		mainPane.add(creator.getLabel("Часы"), 0, 0);
		mainPane.add(creator.getLabel("Минуты"), 1, 0);
		mainPane.add(depTimeBotHours, 0, 1);
		mainPane.add(depTimeBotMinutes, 1, 1);
		mainPane.add(creator.getLabel("Нижняя отпр."), 3, 1);
		mainPane.add(depTimeTopHours, 0, 2);
		mainPane.add(depTimeTopMinutes, 1, 2);
		mainPane.add(creator.getLabel("Верхняя отпр."), 3, 2);
		mainPane.add(arrTimeBotHours, 0, 3);
		mainPane.add(arrTimeBotMinutes, 1, 3);
		mainPane.add(creator.getLabel("Нижняя приб."), 3, 3);
		mainPane.add(arrTimeTopHours, 0, 4);
		mainPane.add(arrTimeTopMinutes, 1, 4);
		mainPane.add(creator.getLabel("Верхняя приб."), 3, 4);
	}
	
	public String getDepTopHours() {
		String result = "";
		if (!depTimeTopHours.getText().isEmpty()) {
			result = depTimeTopHours.getText();
			if (Integer.parseInt(result) < 0 && Integer.parseInt(result) > 23) {
				showAlert("Введено неверное число");
				result = "";
			}
		}
		return result;
	}
	
	public String getDepTopMinutes() {
		String result = "";
		if (!depTimeTopMinutes.getText().isEmpty()) {
			result = depTimeTopMinutes.getText();
			if (Integer.parseInt(result) < 0 && Integer.parseInt(result) > 59) {
				showAlert("Введено неверное число");
				result = "";
			}
		}
		return result;
	}
	
	public String getDepBotHours() {
		String result = "";
		if (!depTimeBotHours.getText().isEmpty()) {
			result = depTimeBotHours.getText();
			if (Integer.parseInt(result) < 0 && Integer.parseInt(result) > 23) {
				showAlert("Введено неверное число");
				result = "";
			}
		}
		return result;
	}
	
	public String getDepBotMinutes() {
		String result = "";
		if (!depTimeBotMinutes.getText().isEmpty()) {
			result = depTimeBotMinutes.getText();
			if (Integer.parseInt(result) < 0 && Integer.parseInt(result) > 59) {
				showAlert("Введено неверное число");
				result = "";
			}
		}
		return result;
	}
	
	public String getArrTopHours() {
		String result = "";
		if (!arrTimeTopHours.getText().isEmpty()) {
			result = arrTimeTopHours.getText();
			if (Integer.parseInt(result) < 0 && Integer.parseInt(result) > 23) {
				showAlert("Введено неверное число");
				result = "";
			}
		}
		return result;
	}
	
	public String getArrTopMinutes() {
		String result = "";
		if (!arrTimeTopMinutes.getText().isEmpty()) {
			result = arrTimeTopMinutes.getText();
			if (Integer.parseInt(result) < 0 && Integer.parseInt(result) > 59) {
				showAlert("Введено неверное число");
				result = "";
			}
		}
		return result;
	}
	
	public String getArrBotHours() {
		String result = "";
		if (!arrTimeBotHours.getText().isEmpty()) {
			result = arrTimeBotHours.getText();
			if (Integer.parseInt(result) < 0 && Integer.parseInt(result) > 23) {
				showAlert("Введено неверное число");
				result = "";
			}
		}
		return result;
	}
	
	public String getArrBotMinutes() {
		String result = "";
		if (!arrTimeBotMinutes.getText().isEmpty()) {
			result = arrTimeBotMinutes.getText();
			if (Integer.parseInt(result) < 0 && Integer.parseInt(result) > 59) {
				showAlert("Введено неверное число");
				result = "";
			}
		}
		return result;
	}
	
	public Pane getPane() {
		return mainPane;
	}
	
	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Ошибка");
		alert.setContentText(message);
		alert.showAndWait();
	}
}

package view.dialogs;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.ComponentCreator;
import view.Table;

public class DeleteByNumberOrDepDate {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	public DeleteByNumberOrDepDate(Controller controller) {
		this.controller = controller;
		table = new Table(controller.getTrains());
		table.update();
		stage = new Stage();
		mainPane = new VBox();
		creator = new ComponentCreator();
		buildDialog();
	}
	
	private void buildDialog() {
		
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		
		Label numberLabel = creator.getLabel("Number");
		pane.add(numberLabel, 0, 0);
		
		Label depDateLabel = creator.getLabel("Dep Date");
		pane.add(depDateLabel, 0, 1);
		
		TextField numberText = creator.getTextField();
		pane.add(numberText, 1, 0);
		
		DatePicker depDateText = creator.getDatePicker();
		pane.add(depDateText, 1, 1);
		
		Button delete = creator.getButton("Delete");
		delete.setOnAction(e -> {
			controller.deleteByNumber(numberText.getText());
			controller.deleteByDepDate(depDateText.getValue());
			table.update();
		});
		pane.add(delete, 0, 4);

		mainPane.getChildren().addAll(pane, table.getPane());	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Deleting");
		stage.setHeight(500);
		stage.setWidth(1200);
		stage.show();
	}
}

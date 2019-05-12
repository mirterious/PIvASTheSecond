package view.dialogs;

import java.util.ArrayList;
import java.util.List;
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
import model.Train;
import view.ComponentCreator;
import view.Table;

public class SearchByNumberOrDepDate {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	public SearchByNumberOrDepDate(Controller controller) {
		this.controller = controller;
		table = new Table(controller.copy());
		table.update();
		stage = new Stage();
		mainPane = new VBox();
		creator = new ComponentCreator();
		buildDialog();
	}
	
	private void buildDialog() {
		
		GridPane pane = new GridPane();
		
		Label numberLabel = creator.getLabel("Number");
		pane.add(numberLabel, 0, 0);
		
		Label depDateLabel = creator.getLabel("Dep Date");
		pane.add(depDateLabel, 2, 0);
		
		TextField numberText = creator.getTextField();
		pane.add(numberText, 1, 0);
		
		DatePicker depDateText = creator.getDatePicker();
		pane.add(depDateText, 3, 0);
		
		Button search = creator.getButton("Search");
		search.setOnAction(e -> {
			List<Train> trains = new ArrayList<>();
			trains.addAll(controller.searchByNumber(numberText.getText()));
			trains.addAll(controller.searchByDepDate(depDateText.getValue()));
			table.recreate();
			table.addContent(trains);
			table.update();
		});
		pane.add(search, 4, 0);
		pane.setHgap(10);
		pane.setVgap(10);
		mainPane.getChildren().addAll(pane, table.getPane());	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Searching");
		stage.setHeight(500);
		stage.setWidth(1200);
		stage.show();
	}
}

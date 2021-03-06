package view.dialogs;

import java.util.ArrayList;
import java.util.List;
import controller.Controller;
import controller.DateAndTimeParser;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Train;
import view.ComponentCreator;
import view.Table;
import view.dialogs.panes.TravelTimePane;

public class SearchByTravelTime {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	private DateAndTimeParser parser;
	
	private TravelTimePane pane;
	
	public SearchByTravelTime(Controller controller) {
		this.controller = controller;
		table = new Table(controller.copy());
		pane = new TravelTimePane();
		parser = new DateAndTimeParser();
		stage = new Stage();
		mainPane = new VBox();
		creator = new ComponentCreator();
		table.update();
		buildDialog();
	}
	
	private void buildDialog() {		
		Button search = creator.getButton("�����");
		search.setOnAction(e -> {
			List<Train> trains = new ArrayList<>();
			String travelTime = pane.getYears() + " "
					+ pane.getMonth() + " " 
					+ pane.getDays() + " " 
					+ pane.getHours() + " " 
					+ pane.getMinutes();
			trains = controller.searchByTravelTime(parser.convertToTravelTime(travelTime));
			table.recreate();
			table.addContent(trains);
			table.update();
		});
		mainPane.getChildren().addAll(pane.getPane(), search, table.getPane());	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("����� �� ������� � ����");
		stage.setHeight(600);
		stage.setWidth(1200);
		stage.show();
	}
}

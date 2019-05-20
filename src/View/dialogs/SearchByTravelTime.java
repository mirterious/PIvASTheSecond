package view.dialogs;

import java.util.ArrayList;
import java.util.List;
import controller.Controller;
import controller.DateAndTimeParser;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Train;
import view.ComponentCreator;
import view.Table;

public class SearchByTravelTime {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	private DateAndTimeParser parser;
	
	public SearchByTravelTime(Controller controller) {
		this.controller = controller;
		table = new Table(controller.copy());
		table.update();
		parser = new DateAndTimeParser();
		stage = new Stage();
		mainPane = new VBox();
		creator = new ComponentCreator();
		buildDialog();
	}
	
	private void buildDialog() {
		
		GridPane pane = new GridPane();
		
		TextField yearsText = creator.getTextField();
		pane.add(yearsText, 0, 0);
		
		Label yearsExampleLabel = creator.getLabel("Кол-во лет");
		pane.add(yearsExampleLabel, 1, 0);
		
		TextField monthsText = creator.getTextField();
		pane.add(monthsText, 2, 0);
		
		Label monthsExampleLabel = creator.getLabel("Кол-во месяцев");
		pane.add(monthsExampleLabel, 3, 0);
		
		TextField daysText = creator.getTextField();
		pane.add(daysText, 4, 0);
		
		Label daysExampleLabel = creator.getLabel("Кол-во дней");
		pane.add(daysExampleLabel, 5, 0);
		
		TextField hoursText = creator.getTextField();
		pane.add(hoursText, 6, 0);
		
		Label hoursExampleLabel = creator.getLabel("Кол-во часов");
		pane.add(hoursExampleLabel, 7, 0);
		
		TextField minutesText = creator.getTextField();
		pane.add(minutesText, 8, 0);
		
		Label minutesExampleLabel = creator.getLabel("Кол-во минут");
		pane.add(minutesExampleLabel, 9, 0);
		
		Button search = creator.getButton("Найти");
		search.setOnAction(e -> {
			List<Train> trains = new ArrayList<>();
			String travelTime = yearsText.getText() + " "
					+ monthsText.getText() + " " 
						+ daysText.getText() + " " + 
							hoursText.getText() + " " + minutesText.getText();
			trains = controller.searchByTravelTime(parser.convertToTravelTime(travelTime));
			table.recreate();
			table.addContent(trains);
			table.update();
		});
		pane.add(search, 10, 0);
		pane.setHgap(8);
		pane.setVgap(10);
		mainPane.getChildren().addAll(pane, table.getPane());	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Поиск по времени в пути");
		stage.setHeight(600);
		stage.setWidth(1200);
		stage.show();
	}
}

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

public class SearchByDepTimeOrArrTime {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	private DateAndTimeParser parser;
	
	public SearchByDepTimeOrArrTime(Controller controller) {
		this.controller = controller;
		table = new Table(controller.copy());
		table.update();
		stage = new Stage();
		parser = new DateAndTimeParser();
		mainPane = new VBox();
		creator = new ComponentCreator();
		buildDialog();
	}
	
	private void buildDialog() {
		
		GridPane pane = new GridPane();
		
		Label depatureBottomLabelHours = creator.getLabel("Часы");
		pane.add(depatureBottomLabelHours, 0, 0);
		
		Label depatureBottomLabelMinutes = creator.getLabel("Минуты");
		pane.add(depatureBottomLabelMinutes, 1, 0);
		
		TextField depatureBottomTextHours = creator.getTextField();
		pane.add(depatureBottomTextHours, 0, 1);
		
		TextField depatureBottomTextMinutes = creator.getTextField();
		pane.add(depatureBottomTextMinutes, 1, 1);
		
		Label departureBottomLabel = creator.getLabel("Нижняя отпр.");
		pane.add(departureBottomLabel, 3, 1);
		
		TextField departureTopTextHours = creator.getTextField();
		pane.add(departureTopTextHours, 0, 2);
		
		TextField departureTopTextMinutes = creator.getTextField();
		pane.add(departureTopTextMinutes, 1, 2);
		
		Label departureTopLabel = creator.getLabel("Верхняя отпр.");
		pane.add(departureTopLabel, 3, 2);
		
		TextField arrivingBottomTextHours = creator.getTextField();
		pane.add(arrivingBottomTextHours, 0, 3);
		
		TextField arrivingBottomTextMinutes = creator.getTextField();
		pane.add(arrivingBottomTextMinutes, 1, 3);
		
		Label arrivingBottomLabel = creator.getLabel("Нижняя приб.");
		pane.add(arrivingBottomLabel, 3, 3);
		
		TextField arrivingTopTextHours = creator.getTextField();
		pane.add(arrivingTopTextHours, 0, 4);
		
		TextField arrivingTopTextMinutes = creator.getTextField();
		pane.add(arrivingTopTextMinutes, 1, 4);
		
		Label arrivingTopLabel = creator.getLabel("Верхняя приб.");
		pane.add(arrivingTopLabel, 3, 4);
		
		Button search = creator.getButton("Найти");
		search.setOnAction(e -> {
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
			List<Train> trains = new ArrayList<>();
			if(!depTimeBot.isEmpty() && !depTimeTop.isEmpty()) {
				trains.addAll(controller.searchByDepTime(parser.convertToTime(depTimeTop),
						parser.convertToTime(depTimeBot)));
			}
			if(!arrTimeBot.isEmpty() && !arrTimeTop.isEmpty()) {
				trains.addAll(controller.searchByArrTime(parser.convertToTime(arrTimeTop),
						parser.convertToTime(arrTimeBot)));
			}
			table.recreate();
			table.addContent(trains);
			table.update();
		});
		pane.add(search, 0, 5);
		pane.setHgap(5);
		mainPane.getChildren().addAll(pane, table.getPane());	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("Поиск по времени прибытия или отправления");
		stage.setHeight(600);
		stage.setWidth(1200);
		stage.show();
	}
}

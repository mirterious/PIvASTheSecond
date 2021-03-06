package view.dialogs;

import java.util.HashSet;
import java.util.Set;

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
import view.dialogs.panes.DepTimeOrArrTimePane;

public class SearchByDepTimeOrArrTime {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	private DateAndTimeParser parser;
	
	private DepTimeOrArrTimePane pane;
	
	public SearchByDepTimeOrArrTime(Controller controller) {
		this.controller = controller;
		table = new Table(controller.copy());
		pane = new DepTimeOrArrTimePane();
		table.update();
		stage = new Stage();
		parser = new DateAndTimeParser();
		mainPane = new VBox();
		mainPane.getChildren().add(pane.getPane());
		creator = new ComponentCreator();
		buildDialog();
	}
	
	private void buildDialog() {
		
		Button search = creator.getButton("�����");
		search.setOnAction(e -> {
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
			Set<Train> set = new HashSet<>();
			if(!depTimeBot.isEmpty() && !depTimeTop.isEmpty()) {
				set.addAll(controller.searchByDepTime(parser.convertToTime(depTimeTop),
						parser.convertToTime(depTimeBot)));
			}
			if(!arrTimeBot.isEmpty() && !arrTimeTop.isEmpty()) {
				set.addAll(controller.searchByArrTime(parser.convertToTime(arrTimeTop),
						parser.convertToTime(arrTimeBot)));
			}
			table.recreate();
			table.addContent(set);
			table.update();
		});
		mainPane.getChildren().addAll(search, table.getPane());	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("����� �� ������� �������� ��� �����������");
		stage.setHeight(600);
		stage.setWidth(1200);
		stage.show();
	}
}

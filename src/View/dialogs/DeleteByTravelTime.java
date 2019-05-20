package view.dialogs;

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
import view.ComponentCreator;
import view.Table;

public class DeleteByTravelTime {

	private Stage stage;
	
	private Controller controller;
	
	private ComponentCreator creator;
	
	private Pane mainPane;
	
	private Table table;
	
	private DateAndTimeParser parser;
	
	public DeleteByTravelTime(Controller controller) {
		this.controller = controller;
		table = new Table(controller.getTrains());
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
		
		Label yearsExampleLabel = creator.getLabel("���-�� ���");
		pane.add(yearsExampleLabel, 1, 0);
		
		TextField monthsText = creator.getTextField();
		pane.add(monthsText, 2, 0);
		
		Label monthsExampleLabel = creator.getLabel("���-�� �������");
		pane.add(monthsExampleLabel, 3, 0);
		
		TextField daysText = creator.getTextField();
		pane.add(daysText, 4, 0);
		
		Label daysExampleLabel = creator.getLabel("���-�� ����");
		pane.add(daysExampleLabel, 5, 0);
		
		TextField hoursText = creator.getTextField();
		pane.add(hoursText, 6, 0);
		
		Label hoursExampleLabel = creator.getLabel("���-�� �����");
		pane.add(hoursExampleLabel, 7, 0);
		
		TextField minutesText = creator.getTextField();
		pane.add(minutesText, 8, 0);
		
		Label minutesExampleLabel = creator.getLabel("���-�� �����");
		pane.add(minutesExampleLabel, 9, 0);
		
		Button delete = creator.getButton("�������");
		delete.setOnAction(e -> {
			String travelTime = yearsText.getText() + " "
					+ monthsText.getText() + " " 
						+ daysText.getText() + " " + 
							hoursText.getText() + " " + minutesText.getText();
			controller.deleteByTravelTime(parser.convertToTravelTime(travelTime));
			table.update();
		});
		pane.add(delete, 10, 0);
		pane.setHgap(8);
		pane.setVgap(10);
		mainPane.getChildren().addAll(pane, table.getPane());	
	}
	
	public void call() {
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setTitle("�������� �� ������� � ����");
		stage.setHeight(500);
		stage.setWidth(1200);
		stage.show();
	}
}

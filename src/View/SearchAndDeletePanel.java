package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class SearchAndDeletePanel {
	
	private GridPane web;
	
	private Pane pane;
	
	private ComponentCreator creator;
	
	public SearchAndDeletePanel() {
		creator = new ComponentCreator();
		pane = new Pane();
		web = new GridPane();
		pane.getChildren().add(web);
		addAddButton();
		addDeleteButtons();
		addSearchButtons();
		addLabels();
		fixweb();
	}
	
	public Pane getPane() {
		return pane;
	}
	
	public void addAddButton() {
		Button addButton = creator.getButton("Add");
		addButton.setOnAction(e -> {
			
		});
		web.add(addButton, 0, 0);
		
	}
	
	public void addLabels() {
		Label search = creator.getLabel("Search");
		Label delete = creator.getLabel("Delete");
		Label numberOrDepDate = creator.getLabel("Number/Dep Date");
		Label travelTime = creator.getLabel("Travel time");
		Label depTimeOrArrStation = creator.getLabel("Dep time / Arr station");
		Label depOrArrStation = creator.getLabel("Dep / Arr station");
		web.add(numberOrDepDate, 1, 0);
		web.add(travelTime, 2, 0);
		web.add(depTimeOrArrStation, 3, 0);
		web.add(depOrArrStation, 4, 0);
		web.add(search, 0, 1);
		web.add(delete, 0, 2);
	}
	
	public void addSearchButtons() {
		Button searchByNumberOrDepDate = creator.getButton();
		Button searchByTravelTime = creator.getButton();
		Button searchByDepTimeOrArrStation = creator.getButton();
		Button searchByDepOrArrStation = creator.getButton();
		web.add(searchByNumberOrDepDate, 1, 1);
		web.add(searchByTravelTime, 2, 1);
		web.add(searchByDepTimeOrArrStation, 3, 1);
		web.add(searchByDepOrArrStation, 4, 1);
	}
	
	public void addDeleteButtons() {
		Button deleteByNumberOrDepDate = creator.getButton();
		Button deleteByTravelTime = creator.getButton();
		Button deleteByDepTimeOrArrStation = creator.getButton();
		Button deleteByDepOrArrStation = creator.getButton();
		web.add(deleteByNumberOrDepDate, 1, 2);
		web.add(deleteByTravelTime, 2, 2);
		web.add(deleteByDepTimeOrArrStation, 3, 2);
		web.add(deleteByDepOrArrStation, 4, 2);
	}
	
	private void fixweb() {
		web.setVgap(10);
		web.setHgap(120);
		web.setPadding(new Insets(20));
	}
	
}

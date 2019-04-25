package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Train;

public class Table {
	
	private Pane mainPane;
	
	private List<Train> trains;
	
	private TableView<ShowTable> table;
	
	private Pagination paginationBar;
	
	public Table() {
		this(new ArrayList<>());
	}
	
	public Table(List<Train> trains) {
		this.trains = trains;
		mainPane = new VBox();
		table = new TableView<>();
		//paginationBar = new Pagination(this);
		correctTable();
		createColumns();
	}
	
	private void correctTable() {
		table.setMinWidth(800);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		mainPane.getChildren().addAll(table);
	}
	
	
    private void createColumns() {
	final Map<String, String> COLUMNS_PROPERTIES = new LinkedHashMap<>();
	COLUMNS_PROPERTIES.put("Number", "number");
	COLUMNS_PROPERTIES.put("Departure station", "departure");
	COLUMNS_PROPERTIES.put("Arriving station", "arriving");
	COLUMNS_PROPERTIES.put("Departure date", "departureDate");
	COLUMNS_PROPERTIES.put("Arriving date", "arrivingDate");
	COLUMNS_PROPERTIES.put("Travel time", "travelTime");

	Iterator<String> keys = COLUMNS_PROPERTIES.keySet().iterator();
	while (keys.hasNext()) {
	    String name = keys.next();
	    String property = COLUMNS_PROPERTIES.get(name);
	    TableColumn<ShowTable, String> column = new TableColumn<>(name);
	    column.setCellValueFactory(new PropertyValueFactory<>(property));
	    table.getColumns().add(column);
	}
    }
	
}

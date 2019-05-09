package view;

import java.util.ArrayList;
import java.util.List;
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
		paginationBar = new Pagination(this);
		correctTable();
		createColumns();
	}

	private void correctTable() {
		table.setMinWidth(800);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		mainPane.getChildren().addAll(table, paginationBar.getPane());
	}

	@SuppressWarnings("unchecked")
	private void createColumns() {
		TableColumn<ShowTable, String> column1 = new TableColumn<>("Number");
		column1.setCellValueFactory(new PropertyValueFactory<>("number"));
		
		TableColumn<ShowTable, String> column2 = new TableColumn<>("Dep Station");
		column2.setCellValueFactory(new PropertyValueFactory<>("departure"));
		
		TableColumn<ShowTable, String> column3 = new TableColumn<>("Arr Station");
		column3.setCellValueFactory(new PropertyValueFactory<>("arriving"));
		
		TableColumn<ShowTable, String> column4 = new TableColumn<>("Dep Date");
		column4.setCellValueFactory(new PropertyValueFactory<>("departureDate"));

		TableColumn<ShowTable, String> column5 = new TableColumn<>("Arr Date");
		column5.setCellValueFactory(new PropertyValueFactory<>("arrivingDate"));
		
		TableColumn<ShowTable, String> column6 = new TableColumn<>("Travel time");
		column6.setCellValueFactory(new PropertyValueFactory<>("travelTime"));
		
		table.getColumns().addAll(column1, column2, column3, column4, column5, column6);
	}

	public List<Train> getTrains() {
		return trains;
	}

	public Pane getPane() {
		return mainPane;
	}

	public void clear() {
		table.getItems().clear();
	}

	public void recreate() {
		trains.clear();
	}

	public void setContent(List<ShowTable> records) {
		table.getItems().clear();
		table.getItems().addAll(records);
	}
	
	public void addContent(List<Train> trains) {
		this.trains.addAll(trains);
		paginationBar.update();
		paginationBar.setLastPage();
	}
	
	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}
	
	public void update() {
		paginationBar.update();
		paginationBar.setLastPage();
	}

	public void setRowHeight(int totalRecords) {
		final double heightOfCell = 30;
		table.setFixedCellSize(heightOfCell);
		double heightOfTable = (totalRecords + 1) * heightOfCell;
		table.setMaxHeight(heightOfTable);
	}
}
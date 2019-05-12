package view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Train;

public class Table {

	private Pane mainPane;

	private List<Train> trains;

	private TableView<ShowTable> table;
	
	private ComponentCreator creator;
	
	private Label totalPagesLabel;
	
	private Label totalRecordsLabel;
	
	private Label recordsPerPageLabel;
	
	private Label currentPageLabel;
	
	private int defaultPageRecords = 10;

	private int totalRecords;

	private int currentPage;

	private int totalPages;

	private int recordsPerPage;

	public Table() {
		this(new ArrayList<>());
	}

	public Table(List<Train> trains) {
		this.trains = trains;
		mainPane = new VBox();
		table = new TableView<>();
		creator = new ComponentCreator();
		totalRecords = trains.size();
		recordsPerPage = defaultPageRecords;
		currentPage = 1;
		correctTable();
		createColumns();
		addComponents();
		update();
	}

	public List<Train> getTrains() {
		return trains;
	}

	public Pane getPane() {
		return mainPane;
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
		update();
	}
	
	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}
	
	public void setPage(int page) {
		int from = page * recordsPerPage;
		int to = from + recordsPerPage;
		if (to > totalRecords) {
			to = totalRecords;
		}
		if (from <= totalRecords) {
			currentPage = page;
			List<ShowTable> records = getAmountOfTrains(trains.subList(from, to));
			setContent(records);
			updateVariables();
		}
	}
		
	public void setFirstPage() {
		setPage(0);
	}
	
	public void setLastPage() {
		int lastPage = totalPages - 1;
		setPage(lastPage);
	}
	
	public void nextPage() {
		int page = currentPage + 1;
		if (page < totalPages) {
			setPage(page);
		}
	}
	
	public void previousPage() {
		int page = currentPage - 1;
		if (page >= 0) {
			setPage(page);
		}
	}
		
	public void update() {
		updateVariables();
		setLastPage();
	}

	public void updateVariables() {
		totalRecords = trains.size();
		totalPages = (totalRecords - 1)/ recordsPerPage + 1;
		updateLabels();
		setRowHeight(totalRecords);
	}
	
	private void correctTable() {
		table.setMinWidth(800);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		mainPane.getChildren().addAll(table/*, paginationBar.getPane()*/);
	}
	
	private void setAmountOfRecordsPerPage(int number) {
		if (number > 0) {
			recordsPerPage = number;
		} else {
			showAlert("Неверное количество");
		}
	}
	
	public void setRowHeight(int totalRecords) {
		final double heightOfCell = 30;
		table.setFixedCellSize(heightOfCell);
		double heightOfTable = (totalRecords + 1) * heightOfCell;
		table.setMaxHeight(heightOfTable);
	}
	
	private List<ShowTable> getAmountOfTrains(List<Train> trains) {
		List<ShowTable> records = new ArrayList<>(trains.size());
		for (Train train:trains) {
			ShowTable record = new ShowTable(train);
			records.add(record);	
		}
		return records;
	}
	
	private void updateLabels() {
		recordsPerPageLabel.setText("Records p/p "+recordsPerPage);
		totalPagesLabel.setText("Total pages "+totalPages);
		totalRecordsLabel.setText("Total records "+totalRecords);
		currentPageLabel.setText("Current page "+(currentPage+1));
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

	private void addComponents() {
		GridPane pane = new GridPane();
		pane.setHgap(20);
		
		TextField text = creator.getTextField();
		text.setMaxWidth(50);
		pane.add(text, 0, 0);
		
		recordsPerPageLabel = creator.getLabel(""+recordsPerPage);
		pane.add(recordsPerPageLabel, 5, 0);
		
		totalRecordsLabel = creator.getLabel(""+totalRecords);
		pane.add(totalRecordsLabel, 2, 0);
		
		currentPageLabel = creator.getLabel(""+currentPage);
		pane.add(currentPageLabel, 3, 0);
		
		totalPagesLabel = creator.getLabel(""+totalPages);
		pane.add(totalPagesLabel, 4, 0);
		
		Button setRecordsPerPage = creator.getButton("Записи");
		setRecordsPerPage.setOnAction(e -> {
			try {
				int value = Integer.parseInt(text.getText());
				if (value > 0) {
					setAmountOfRecordsPerPage(value);
					setPage(currentPage);
				} else {
					throw new IllegalArgumentException();
				}
			}
			catch (RuntimeException ex) {
				showAlert("wrong");
			}
		});
		pane.add(setRecordsPerPage, 1, 0);
		
		Button onFirstPage = creator.getButton("1-ая стр.");
		onFirstPage.setOnAction((e) -> {
			setFirstPage();
		});
		pane.add(onFirstPage, 6, 0);

		Button onPrevPage = creator.getButton("Пред. стр.");
		onPrevPage.setOnAction((e) -> {
			previousPage();
		});
		pane.add(onPrevPage, 7, 0);

		Button onNextPage = creator.getButton("След. стр.");
		onNextPage.setOnAction((e) -> {
			nextPage();
		});
		pane.add(onNextPage, 8, 0);

		Button onLastPage = creator.getButton("Посл. стр.");
		onLastPage.setOnAction((e) -> {
			setLastPage();
		});
		pane.add(onLastPage, 9, 0);

		mainPane.getChildren().add(pane);
	}
	
	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setContentText(message);
		alert.showAndWait();
	}
}
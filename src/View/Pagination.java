package view;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Train;

public class Pagination {

	private int defaultPageRecords = 10;

	private int totalRecords;

	private int currentPage;

	private int totalPages;

	private int recordsPerPage;
	
	private List<Train> trains;

	private ComponentCreator creator;

	private Table table;

	private Pane mainPane;
	
	private Label totalPagesLabel;
	
	private Label totalRecordsLabel;
	
	private Label recordsPerPageLabel;
	
	private Label currentPageLabel;

	public Pagination(Table table) {
		this.table = table;
		creator = new ComponentCreator();
		mainPane = new HBox();
		trains = table.getTrains();
		totalRecords = trains.size();
		recordsPerPage = defaultPageRecords;
		currentPage = 1;
		addComponents();
		update();
	}
	
	public void update() {
		totalRecords = trains.size();
		totalPages = (totalRecords - 1)/ recordsPerPage + 1;
		updateLabels();
		table.setRowHeight(totalRecords);
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
			table.setContent(records);
			update();
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
	
	private void setAmountOfRecordsPerPage(int number) {
		if (number > 0) {
			recordsPerPage = number;
		} else {
			showAlert("Неверное количество");
		}
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
	
	private void addComponents() {
		GridPane pane = new GridPane();
		pane.setHgap(20);
		
		TextField text = creator.getTextField("Цифра");
		text.setMaxWidth(50);
		pane.add(text, 0, 0);
		
		recordsPerPageLabel = creator.getLabel(""+recordsPerPage);
		pane.add(recordsPerPageLabel, 1, 0);
		
		totalRecordsLabel = creator.getLabel(""+totalRecords);
		pane.add(totalRecordsLabel, 2, 0);
		
		currentPageLabel = creator.getLabel(""+currentPage);
		pane.add(currentPageLabel, 3, 0);
		
		totalPagesLabel = creator.getLabel(""+totalPages);
		pane.add(totalPagesLabel, 4, 0);
		
		Button setRecordsPerPage = creator.getButton("Кол-во записей");
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
		pane.add(setRecordsPerPage, 5, 0);
		
		Button onFirstPage = creator.getButton("Первая страница");
		onFirstPage.setOnAction((e) -> {
			setFirstPage();
		});
		pane.add(onFirstPage, 6, 0);

		Button onPrevPage = creator.getButton("Предыдущая страница");
		onPrevPage.setOnAction((e) -> {
			previousPage();
		});
		pane.add(onPrevPage, 7, 0);

		Button onNextPage = creator.getButton("Следующая страница");
		onNextPage.setOnAction((e) -> {
			nextPage();
		});
		pane.add(onNextPage, 8, 0);

		Button onLastPage = creator.getButton("Последняя страница");
		onLastPage.setOnAction((e) -> {
			setLastPage();
		});
		pane.add(onLastPage, 9, 0);

		mainPane.getChildren().add(pane);
	}
	
	public Pane getPane() {
		return mainPane;
	}

	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR");
		alert.setContentText(message);
		alert.showAndWait();
	}
}
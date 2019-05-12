package view;

import java.io.File;
import java.time.LocalDate;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class ComponentCreator {
	
	public ComponentCreator() {};
	
	public Button getButton(String name) {
		Button button = new Button(name);
		button.setMaxSize(100, 30);
		button.setMinSize(100, 30);
		button.setStyle("");
		return button;
	}
	
	public Button getButton() {
		Button button = new Button();
		button.setMaxSize(100, 30);
		button.setMinSize(100, 30);
		return button;
	}
	
	public ComboBox<String> getComboBox(String ...values) {
		ComboBox<String> comboBox = new ComboBox<>();
		comboBox.setMaxSize(100, 40);
		comboBox.setMinSize(150, 50);
		comboBox.getItems().addAll(values);
		return comboBox;
	}
	
	public Label getLabel(String name) {
		Label label = new Label(name);
		label.setStyle("text-align: center; -fx-font-size:12px;");
		label.setMaxSize(100, 40);
		label.setMinSize(100, 40);
		return label;
	}
	
	public TextField getTextField() {
		TextField textField = new TextField();
		textField.setMaxWidth(100);
		textField.setMinWidth(100);
		return textField;
	}

	public DatePicker getDatePicker() {
		DatePicker datePicker = new DatePicker();
		datePicker.setMaxWidth(100);
		datePicker.setValue(LocalDate.now());
		datePicker.setShowWeekNumbers(true);
		return datePicker;
	}
	
    public FileChooser getFileChooser() {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Chooser");
    	fileChooser.setInitialFileName("filename.xml");
    	fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
    	ExtensionFilter filter = new ExtensionFilter("XML", "*.xml");
    	fileChooser.getExtensionFilters().add(filter);
    	return fileChooser;
    }
}
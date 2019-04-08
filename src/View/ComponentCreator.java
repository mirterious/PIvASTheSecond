package View;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class ComponentCreator {
	
	public ComponentCreator() {};
	
	public Button getButton(String buttonName) {
		Button simpleButton = new Button(buttonName);
		simpleButton.setMaxSize(100, 45);
		simpleButton.setMinSize(100, 45);
		return simpleButton;
	}
	
	public ComboBox<String> getComboBox(String ...values) {
		ComboBox<String> simpleComboBox = new ComboBox<>();
		simpleComboBox.setMaxSize(100, 40);
		simpleComboBox.setMinSize(150, 50);
		simpleComboBox.getItems().addAll(values);
		return simpleComboBox;
	}
	
	public Label getLabel(String name) {
		Label simpleLabel = new Label(name);
		simpleLabel.setMaxSize(100, 40);
		simpleLabel.setMinSize(100, 40);
		return simpleLabel;
	}
	
	public TextField getTextField() {
		TextField simpleTextField = new TextField();
		simpleTextField.setMaxWidth(100);
		simpleTextField.setMinWidth(100);
		return simpleTextField;
	}
	
    public FileChooser getFileChooser() {
    	FileChooser defaultFileChooser = new FileChooser();
    	defaultFileChooser.setTitle("Chooser");
    	defaultFileChooser.setInitialFileName("filename.xml");
    	ExtensionFilter filter = new ExtensionFilter("XML", "*.xml");
    	defaultFileChooser.getExtensionFilters().add(filter);
    	return defaultFileChooser;
    }
}
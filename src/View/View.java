package view;
//import controller.Controller;
import model.Model;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {

    private Stage stage;

    private Pane mainPane;

    //private Controller controller;

    //private Table table;

    private ControlButtons tools;

   // private MenuPanel menu;

    public View(Stage stage) {
	this.stage = stage;
	//Model model = new Model();
	mainPane = new VBox();
	//controller = new Controller(model);
	//table = new Table(model.getStudents());
	//menu = new MenuPanel(controller, table, stage);
	tools = new ControlButtons();
	configure();
	configureStage();
    }
    
    public void show() {
    	stage.show();
    }

    private void configure() {
    	Pane contentPane = new HBox();
    	contentPane.getChildren().add(tools.getPane());
		mainPane.getChildren().add(contentPane);
    }

    private void configureStage() {
    	stage.setScene(new Scene(mainPane));
    	stage.setMinHeight(650);
    	stage.setMinWidth(800);
    }
}
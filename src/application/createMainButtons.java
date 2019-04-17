package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class createMainButtons {
	Stage window;
	
	public Button next() {
		Button next = new Button("Next");
		return next;
	}
	
	public Button prev() {
		Button previous = new Button("Previous");
		return previous;
	}
	
	public Button goToMenu() {
		Button menu = new Button("Go to Menu");
		return menu;
	}
	
	public Button submit() {
		Button submit = new Button("Submit");
		return submit;
	}
	
	public Label response() {
		Label response = new Label();
		return response;
	}
	
	public Label content(String input) {
		Label content = new Label(input);
		content.setWrapText(true);
		return content;
	}
	
	public Label question(String input) {
		Label question = new Label(input);
		return question;
	}
	
	public TextField shortAnswer() {
		TextField shortAnswer = new TextField();
		shortAnswer.setPromptText("Write Here...");
		return shortAnswer;
	}
	
	public GridPane setGrid() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20,20,20,20));
		grid.setVgap(8);
		grid.setHgap(10);
		return grid;
	}
	
}

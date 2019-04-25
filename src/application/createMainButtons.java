package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class createMainButtons {
	Stage window;
	
	public Button button(String buttonName) {
		Button button = new Button(buttonName);
		return button;
	}
	
	public Button menuButton(String buttonName) {
		Button button = new Button(buttonName);
		button.setWrapText(true);
		double r=35;
		button.setShape(new Circle(r));
		button.setMinSize(2*r, 2*r);
		button.setMaxSize(2*r, 2*r);
		button.setAlignment(Pos.CENTER);
		return button;
	}
	
	public Label label(String labelName) {
		Label label = new Label(labelName);
		label.setWrapText(true);
		return label;
	}
	
	public Label content(String input) {
		Label content = new Label(input);
		content.setWrapText(true);
		return content;
	}
	
	public TextField shortAnswer() {
		TextField shortAnswer = new TextField();
		shortAnswer.setPromptText("Write Here...");
		return shortAnswer;
	}
	
	public GridPane setGrid() {
		GridPane grid = new GridPane();
		grid.getStylesheets().add("Style.css");
		grid.setPadding(new Insets(20,20,20,20));
		grid.setVgap(8);
		grid.setHgap(10);
		return grid;
	}
	
}

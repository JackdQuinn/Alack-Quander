package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class CreateMainButtons {
	String ButtonStyle = "ButtonStyle.css";
	String LabelStyle = "LabelStyle.css";
	
	public Button next() {
		Button next = new Button("Next");
		next.getStylesheets().add(ButtonStyle);
		return next;
	}
	
	public Button prev() {
		Button previous = new Button("Previous");
		previous.getStylesheets().add(ButtonStyle);
		return previous;
	}
	
	public Button submit() {
		Button submit = new Button("Submit");
		submit.getStylesheets().add(ButtonStyle);
		return submit;
	}

	public Label response() {
		Label response = new Label();
		response.setWrapText(true);
		response.getStylesheets().add(LabelStyle);
		return response;
	}
	
	public Label content(String input) {
		Label content = new Label(input);
		content.setWrapText(true);
		content.getStylesheets().add(LabelStyle);
		return content;
	}
	
	public Label question(String input) {
		Label question = new Label(input);
		question.setWrapText(true);
		question.getStylesheets().add(LabelStyle);
		return question;
	}
	
	public TextField shortAnswer() {
		TextField shortAnswer = new TextField();
		shortAnswer.setPromptText("Write Here...");
		shortAnswer.getStylesheets().add(LabelStyle);
		return shortAnswer;
	}
	
	public Button topicButton(String buttonName) {
		Button button = new Button(buttonName);
		button.setWrapText(true);
		double r=40;
		button.setShape(new Circle(r));
		button.setMinSize(2*r, 2*r);
		button.setMaxSize(2*r, 2*r);
		button.setAlignment(Pos.CENTER);
		button.getStylesheets().add(ButtonStyle);
		return button;
	}
}
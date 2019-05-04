package application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class CreateMainButtons {
	
	public Button next() {
		Button next = new Button("Next");
		return next;
	}
	
	public Button prev() {
		Button previous = new Button("Previous");
		return previous;
	}
	
	public Button submit() {
		Button submit = new Button("Submit");
		return submit;
	}

	public Label response() {
		Label response = new Label();
		response.setWrapText(true);
		return response;
	}
	
	public Label content(String input) {
		Label content = new Label(input);
		content.setWrapText(true);
		return content;
	}
	
	public Label question(String input) {
		Label question = new Label(input);
		question.setWrapText(true);
		return question;
	}
	
//	public TextField shortAnswer() {
//		TextField shortAnswer = new TextField();
//		shortAnswer.setPromptText("Write Here...");
//		return shortAnswer;
//	}
	
	public Button topicButton(String buttonName) {
		Button button = new Button(buttonName);
		button.setWrapText(true);
		double r=40;
		button.setShape(new Circle(r));
		button.setMinSize(2*r, 2*r);
		button.setMaxSize(2*r, 2*r);
		button.setAlignment(Pos.CENTER);
		return button;
	}
}
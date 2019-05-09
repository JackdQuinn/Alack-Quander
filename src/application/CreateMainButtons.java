package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class CreateMainButtons {
	
	public Button next() {
		Button next = new Button();
		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream("RightArrow.png");
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		} 
		Image image = new Image(inputstream); 
		ImageView imageView = new ImageView(image);
		imageView.setPreserveRatio(true);
		next.setGraphic(imageView);
		imageView.setFitHeight(50); 
		imageView.setFitWidth(50);
		return next;
	}
	
	public Button prev() {
		Button previous = new Button();
		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream("LeftArrow.png");
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		} 
		Image image = new Image(inputstream); 
		ImageView imageView = new ImageView(image);
		imageView.setPreserveRatio(true);
		previous.setGraphic(imageView);
		imageView.setFitHeight(50); 
		imageView.setFitWidth(50);
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
		content.setAlignment(Pos.CENTER);
		content.setMaxWidth(500);
		return content;
	}
	
	public Label title(String input) {
		Label content = new Label(input);
		content.setWrapText(true);
		content.setAlignment(Pos.CENTER);
		content.setMaxWidth(500);
		return content;
	}
	
	public Label question(String input) {
		Label question = new Label(input);
		question.setWrapText(true);
		question.setMaxWidth(500);
		return question;
	}
	
	public Button topicButton(String buttonName) {
		Button button = new Button(buttonName);
		button.setWrapText(true);
		double r=53;
		button.setShape(new Circle(r));
		button.setMinSize(2*r, 2*r);
		button.setMaxSize(2*r, 2*r);
		button.setAlignment(Pos.CENTER);
		return button;
	}
	public TextField shortAnswer() {
		TextField content = new TextField("");
		content.setAlignment(Pos.CENTER);
		content.setMaxWidth(500);
		return content;
	}
}
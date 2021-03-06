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
import javafx.scene.text.TextAlignment;

/*
 * This class is used to create all buttons and labels
 */
public class CreateMainButtons {
	
	//next button uses right arrow graphic
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
	
	//previous button uses left arrow graphic
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
	
	//submit button used on question pages
	public Button submit() {
		Button submit = new Button("Submit");
		return submit;
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
		content.setMaxWidth(500);
		return content;
	}
	
	public Label question(String input) {
		Label question = new Label(input);
		question.setWrapText(true);
		question.setMaxWidth(500);
		return question;
	}
	
	//circular buttons used for topics
	public Button topicButton(String buttonName) {
		Button button = new Button(buttonName);
		button.setWrapText(true);
		double r=53;
		button.setShape(new Circle(r));
		button.setMinSize(2*r, 2*r);
		button.setMaxSize(2*r, 2*r);
		button.setTextAlignment(TextAlignment.CENTER);
		return button;
	}
	
	//short answer textFields have prompt text in light grey
	public TextField shortAnswer() {
		TextField content = new TextField("");
		content.setPromptText("Write here...");
		content.setAlignment(Pos.CENTER);
		content.setMaxWidth(500);
		return content;
	}
}
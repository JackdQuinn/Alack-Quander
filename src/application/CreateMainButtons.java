package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class CreateMainButtons {
	String windowStyle = "Style.css";
	
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
		grid.getStylesheets().add(windowStyle);
		return grid;
	}
	
	public VBox setVbox() {
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(20,20,20,20));
		vbox.setAlignment(Pos.CENTER);
		vbox.getStylesheets().add(windowStyle);
		return vbox;
	}
	
	public Button topicButton(String buttonName) {
		Button button = new Button(buttonName);
		button.setWrapText(true);
		double r=28;
		button.setShape(new Circle(r));
		button.setMinSize(2*r, 2*r);
		button.setMaxSize(2*r, 2*r);
		button.setAlignment(Pos.CENTER);
		return button;
	}
	
	public BorderPane setMenu(String title, GridPane g) {
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(20,20,20,20));

		//center
		GridPane centerMenu = new GridPane();
		centerMenu.getChildren().add(g);
		
		//left
		VBox leftMenu = new VBox();

			FileInputStream inputstream = null;
			try {
				inputstream = new FileInputStream("penn3.png");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			Image image = new Image(inputstream); 
			ImageView imageView = new ImageView(image);
		    imageView.setFitHeight(150); 
		    imageView.setPreserveRatio(true);
		
	    leftMenu.getChildren().add(imageView);
		leftMenu.setAlignment(Pos.BOTTOM_LEFT);
		
		//top
		HBox topMenu = new HBox();
		Label t = new Label(title);
		topMenu.setAlignment(Pos.TOP_LEFT);
		topMenu.getChildren().addAll(t);
		topMenu.getStyleClass().add("menuPane");
		
		//right
		VBox rightMenu = new VBox();
		rightMenu.setAlignment(Pos.TOP_RIGHT);
		
		//add to borderPane
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);
		borderPane.setRight(rightMenu);
		borderPane.setCenter(centerMenu);
		borderPane.getStylesheets().add(windowStyle);
		return borderPane;
	}
}
package application;

import java.util.ArrayList;
import java.util.Collections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Layout {
	
	createMainButtons create = new createMainButtons();
	GridPane grid;
	VBox vbox;
	HBox hbox;
	Button button;
	ComboBox combobox;

	public GridPane menuLayout(String lesson1, String lesson2, String lesson3, String lesson4, String lesson5, String lesson6, String title) {
		grid = new GridPane();
		Label t = create.label(title);
		Button lessonOne = create.menuButton(lesson1);
		Button lessonTwo = create.menuButton(lesson2);
		Button lessonThree = create.menuButton(lesson3);
		Button lessonFour = create.menuButton(lesson4);
		Button lessonFive = create.menuButton(lesson5);
		Button lessonSix = create.menuButton(lesson6);
		
		GridPane.setConstraints(t,1,1);
		GridPane.setConstraints(lessonOne,4,4);
		GridPane.setConstraints(lessonTwo,3,5);
		GridPane.setConstraints(lessonThree,3,6);
		GridPane.setConstraints(lessonFour,4,7);
		GridPane.setConstraints(lessonFive,5,5);
		GridPane.setConstraints(lessonSix,5,6);

		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);;
		grid.setHgap(10);
		grid.getStylesheets().add("Style.css");
		grid.getChildren().addAll(t, lessonOne, lessonTwo, lessonThree, lessonFour, lessonFive, lessonSix);
		grid.setAlignment(Pos.TOP_CENTER);
		return grid;
	}
	
	public GridPane multipleChoiceLayout(String question, String correctMC1, String incorrectMC2, 
			String incorrectMC3, String incorrectMC4) {
		
		Label questionTitle = create.label(question);
		Button submit = create.button("Submit");
		Label response = create.label("");
	
		//create radio buttons
		RadioButton radio1, radio2, radio3, radio4;
		radio1=new RadioButton(correctMC1);
		radio2=new RadioButton(incorrectMC2);
		radio3=new RadioButton(incorrectMC3);
		radio4=new RadioButton(incorrectMC4);
		ToggleGroup q= new ToggleGroup();
		radio1.setToggleGroup(q);
		radio2.setToggleGroup(q);
		radio3.setToggleGroup(q);
		radio4.setToggleGroup(q);
		submit.setDisable(true);
		radio1.setOnAction(e -> submit.setDisable(false) );
		radio2.setOnAction(e -> submit.setDisable(false) );
		radio3.setOnAction(e -> submit.setDisable(false) );
		radio4.setOnAction(e -> submit.setDisable(false) );
		submit.setOnAction(e -> {
		if (radio1.isSelected()) {
			response.setText("Correct answer");
			submit.setDisable(true);
		}
		else {
			response.setText("Wrong answer");
			submit.setDisable(true);
		}           
		});
		
		//arrange radioButtons in random order to place in grid
		ArrayList<RadioButton> answerRadio = new ArrayList<RadioButton>();
		answerRadio.add(radio1);
		answerRadio.add(radio2);
		answerRadio.add(radio3);
		answerRadio.add(radio4);
		Collections.shuffle(answerRadio);
		
		//create grid and place all objects in it
		GridPane grid = new GridPane();
		GridPane.setConstraints(questionTitle,0,0);
		GridPane.setConstraints(submit,0,6);
		GridPane.setConstraints(response,0,7);
		GridPane.setConstraints(answerRadio.get(0),0,2);
		GridPane.setConstraints(answerRadio.get(1),0,3);
		GridPane.setConstraints(answerRadio.get(2),0,4);
		GridPane.setConstraints(answerRadio.get(3),0,5);
		
		//grid settings
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);;
		grid.setHgap(10);
		grid.getStylesheets().add("Style.css");
		grid.getChildren().addAll(questionTitle, radio1, radio2, radio3, radio4, submit, response);
		grid.setAlignment(Pos.CENTER);
		
		return grid;
	}
	
	public VBox contentPageLayout() {
		vbox = new VBox(20);
		vbox.setPadding(new Insets(20,20,20,20));
		vbox.setAlignment(Pos.CENTER);
		return vbox;
	}
	
	public GridPane FIBLayout(String question, int numberOfBlanks) {
		GridPane grid = new GridPane();
		
		Label FIB1 = create.label("Fill in the Blank 1:");
		Label FIB2 = create.label("Fill in the Blank 2:");
		Label title = create.label("Question:");
		Label q = create.label(question);
		TextField text1 = create.shortAnswer();
		TextField text2 = create.shortAnswer();
		Button submit = create.button("Submit");
		Label prompt = create.label("Answer:");
		
		if (numberOfBlanks==2) {
			GridPane.setConstraints(title,0,0);
			GridPane.setConstraints(q,0,1);
			GridPane.setConstraints(prompt,0,3);
			GridPane.setConstraints(FIB1,0,5);
			GridPane.setConstraints(text1,0,6);
			GridPane.setConstraints(FIB2,0,7);
			GridPane.setConstraints(text2,0,8);
			GridPane.setConstraints(submit,0,10);
			grid.getChildren().addAll(q, prompt, text1, text2, submit, title, FIB1, FIB2);
		}
		if (numberOfBlanks==1) {
			GridPane.setConstraints(title,0,0);
			GridPane.setConstraints(q,0,1);
			GridPane.setConstraints(prompt,0,3);
			GridPane.setConstraints(text1,0,4);
			GridPane.setConstraints(submit,0,6);
			grid.getChildren().addAll(q, prompt, text1, submit, title);
			grid.setPadding(new Insets(20, 20, 20, 20));
		}
		
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);;
		grid.setHgap(10);
		grid.getStylesheets().add("Style.css");
		
		return grid;
	}
	
	public ComboBox dropDownChoice() {
		ComboBox combobox = new ComboBox();
		return combobox;
	}

}

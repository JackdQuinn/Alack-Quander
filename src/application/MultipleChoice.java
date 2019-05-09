package application;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class MultipleChoice {
	
	CreateMainButtons createButton;
	CreateMainLayout createLayout;
	
	public GridPane getMC(String question, String correctMC1, String incorrectMC2, String incorrectMC3, String incorrectMC4) {
	
		Button submit = createButton.submit();
		Label response = createButton.content("");
		Label qLabel = createButton.question(question);
		qLabel.setWrapText(true);
		
		/*
		 * Create radio buttons for answer choices.
		 * Correct answer is placed in radio1.
		 * AlertBox will tell the user if answer chosen is correct or incorrect
		 */
		RadioButton radio1, radio2, radio3, radio4;
		radio1=new RadioButton(correctMC1);
		radio2=new RadioButton(incorrectMC2);
		radio3=new RadioButton(incorrectMC3);
		radio4=new RadioButton(incorrectMC4);
		//for longer answer choices, wrap text to appear in multiple lines
		radio1.setWrapText(true); 
		radio2.setWrapText(true); 
		radio3.setWrapText(true); 
		radio4.setWrapText(true); 
		//Prevent automatic highlighting of radio button
		radio1.setFocusTraversable(false); 
		radio2.setFocusTraversable(false); 
		radio3.setFocusTraversable(false); 
		radio4.setFocusTraversable(false); 
		submit.setDisable(true);
		ToggleGroup q= new ToggleGroup();
		radio1.setToggleGroup(q);
		radio2.setToggleGroup(q);
		radio3.setToggleGroup(q);
		radio4.setToggleGroup(q);
		//Cannot press submit until an answer choice is selected
		radio1.setOnAction(e -> submit.setDisable(false) );
		radio2.setOnAction(e -> submit.setDisable(false) );
		radio3.setOnAction(e -> submit.setDisable(false) );
		radio4.setOnAction(e -> submit.setDisable(false) );
		submit.setOnAction(e -> {
		//This if statement determines parameter for display method in AlertBox
		//(correct if radio1 is chosen, otherwise incorrect)
		if (radio1.isSelected()) {	
			AlertBox.display("Correct, good job!"); 
		}
		else {
			AlertBox.display("Incorrect, please try again.");
		}           
		});
		//To avoid correct answer always appearing as the first answer choice, put answer choices in ArrayList and then shuffle.
		//This arranges radioButtons in random order before placing on center panel.
		ArrayList<RadioButton> answerRadio = new ArrayList<RadioButton>();
		answerRadio.add(radio1);
		answerRadio.add(radio2);
		answerRadio.add(radio3);
		answerRadio.add(radio4);
		Collections.shuffle(answerRadio);
		//Place answer choices in center panel
		
		GridPane center = new GridPane();
		GridPane.setConstraints(qLabel,2,2);
		GridPane.setConstraints(answerRadio.get(0),2,4);
		GridPane.setConstraints(answerRadio.get(1),2,5);
		GridPane.setConstraints(answerRadio.get(2),2,6);
		GridPane.setConstraints(answerRadio.get(3),2,7);
		GridPane.setConstraints(submit,2,9);
		GridPane.setConstraints(response,2,10);
	
		center.getChildren().addAll(qLabel, radio1, radio2, radio3, radio4, response, submit);
		return center;
		
	}
}

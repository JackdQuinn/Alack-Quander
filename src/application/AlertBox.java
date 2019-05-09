package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

/*
 * Purpose is to display an alert box telling the user if his/her answer was correct/incorrect
 * @param message comes from if statement in questionPage method (correct if radio1 is chosen, otherwise incorrect)
 */
public class AlertBox {
	
	public static void display(String message) {
		Stage window = new Stage();
		
		int xp = 0;
		if(message.equals("Correct, good job!")) {
			xp++;
		}
		//String xpS = Integer.toString(xp);
		//Label xpLabel = new Label("You have " + xpS + " XP!");
		
		//Blocks any user interaction in main window until user presses continue (or closes alert box)
		window.initModality(Modality.APPLICATION_MODAL); 
		
		Button closeButton = new Button("Continue");
		closeButton.setOnAction(e -> window.close());

		//Set style and width/height
		String windowStyle = "Style.css";
		window.setMinWidth(200);;
		window.setMinHeight(200);
		
		//Create label of message in method parameter
		Label label = new Label();
		label.setText(message);
		label.setId("big-label");
		
		//Set up layout for the pop up window
		VBox layout = new VBox(20);
		layout.setPadding(new Insets(10,10,10,10));
		layout.getChildren().addAll(label, closeButton);
		//layout.getChildren().addAll(xpLabel);
		layout.setAlignment(Pos.CENTER);
		layout.getStylesheets().add(windowStyle);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		
		//Instead of "show", we use "showAndWait" to display this window because it needs to be closed before you can go back to main window
		window.showAndWait();
		
	}
	
}



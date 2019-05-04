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
 * Blocks any user interaction until the alert box is closed
 */
public class AlertBox {
	
	public static void display(String message) {

		Stage window = new Stage();
		String windowStyle = "Style.css";
		
		/*
		 * Block input for other user events until this one is taken care of
		 */
		window.initModality(Modality.APPLICATION_MODAL); 
		
		window.setMinWidth(400);;
		
		Label label = new Label();
		label.setText(message);
		
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> window.close());
		
		/*
		 * Set up layout for the pop up window
		 */
		VBox layout = new VBox(20);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		layout.getStylesheets().add(windowStyle);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		
		/*
		 * Instead of "show", we use "showAnd Wait" to display this window because it needs to be closed before  you can go back
		 */
		window.showAndWait();
		
	}
	
}



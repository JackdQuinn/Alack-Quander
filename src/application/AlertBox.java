package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

//block any user interaction until alert box is closed
public class AlertBox {
	
	public static void display(String message) {
		//need new window
		Stage window = new Stage();
		String windowStyle = "Style.css";
		
		window.initModality(Modality.APPLICATION_MODAL); //we are going to block input for other user events until this one is taken care of
		
		window.setMinWidth(400);;
		
		Label label = new Label();
		label.setText(message);
		
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> window.close());
		
		//always need a layout
		VBox layout = new VBox(20);
		layout.setPadding(new Insets(20,20,20,20));
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		layout.getStylesheets().add(windowStyle);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		
		//instead of regular show...
		//display this window and before you go back, it needs to be closed
		window.showAndWait();
		
	}
	
}



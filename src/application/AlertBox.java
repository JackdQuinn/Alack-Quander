package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

//block any user interaction until alert box is closed
public class AlertBox {
	
	public static void display(String title, String message) {
		//need new window
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL); //we are going to block input for other user events until this one is taken care of
		window.setTitle(title);
		window.setMinWidth(250);;
		
		Label label = new Label();
		label.setText(message);
		
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> window.close());
		
		//always need a layout
		VBox layout = new VBox(5);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		
		//instead of regular show...
		//display this window and before you go back, it needs to be closed
		window.showAndWait();
		
	}
	
}



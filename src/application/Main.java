package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	Stage window;
	Screens screen = new Screens();
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		screen.goToTopics(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

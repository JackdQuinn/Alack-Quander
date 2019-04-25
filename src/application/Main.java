package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {

Stage window;
Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7;

public static void main(String[] args) {
	launch(args);
}

@Override
public void start(Stage primaryStage) throws Exception{
	window = primaryStage;
	createMainButtons create = new createMainButtons();
	Layout l = new Layout();
	
//page 1
	String title = "Welcome!";
	String lesson1 = "Basics";
	String lesson2 = "Loops";
	String lesson3 = "Arrays";
	String lesson4 = "Reading a File";
	String lesson5 = "RegEx";
	String lesson6 = "Hashmap";
	GridPane grid1 = l.menuLayout(lesson1, lesson2, lesson3, lesson4, lesson5, lesson6,  title);
	
	Button next1 = create.button("Let's get started!");
	grid1.add(next1, 10,0);
	next1.setOnAction(e -> window.setScene(scene2)); //need to figure out how to use setOnAction in different method

	scene1 = new Scene(grid1, 600, 500);
	scene1.getStylesheets().add("Style.css");
	
//page 2
	VBox vbox1 = l.contentPageLayout();
	
	Button next2 = create.button("Next");
	Button prev2 = create.button("Prev");
	Label content2 = create.content("Java is a general-purpose computer-programming language originally developed by  James Gosling at Sun Microsystems and released in 1995.");
	next2.setOnAction(e -> window.setScene(scene3)); 
	prev2.setOnAction(e -> window.setScene(scene1)); 
	
	vbox1.getChildren().addAll(content2, next2, prev2);
	scene2 = new Scene(vbox1, 600, 500);
	scene2.getStylesheets().add("Style.css");
	
//page 3
	VBox vbox3 = l.contentPageLayout();
	
	Button next3 = create.button("Next");
	Button prev3 = create.button("Prev");
	Label content3_1 = create.content("Java gained widespread popularity for being Platform Independent, which means that you only need to write the program once to be able to run it on a number of different platforms!");
	Label content3_2 = create.content("Today java is one of the most popular languages in the world with over 9 million developers.");
	Label content3_3 = create.content("Java intends to let application developers \"write once, run anywhere\"");
	next3.setOnAction(e -> window.setScene(scene4)); 
	prev3.setOnAction(e -> window.setScene(scene2)); 

	vbox3.getChildren().addAll(content3_1, content3_2, content3_3, next3, prev3);
	scene3 = new Scene(vbox3, 600, 500);
	scene3.getStylesheets().add("Style.css");
	
//page 4
	GridPane grid4 = l.multipleChoiceLayout("To distribute your application to different platforms, how many java versions do you need to create?", 
			"Just one version", "Two Versions", "One for each platform", "BLAH!");
	
	Button next4 = create.button("Next");
	Button prev4 = create.button("Prev");
	next4.setOnAction(e -> window.setScene(scene5)); 
	prev4.setOnAction(e -> window.setScene(scene3));
	GridPane.setConstraints(next4,0,9);
	GridPane.setConstraints(prev4,0,10);
	
	grid4.getChildren().addAll(next4, prev4);
	scene4 = new Scene(grid4, 600, 500);
	scene4.getStylesheets().add("Style.css");
	
//page 5
	VBox vbox5 = l.contentPageLayout();
	
	Button next5 = create.button("Next");
	Button prev5 = create.button("Prev");
	Label content5_1 = create.content("Java runs on more than 3 billion devices. ");
	Label content5_2 = create.content("Java is used to develop apps for Google's Android OS, various Desktop Applications, Web Applications, Enterprise Applications (i.e. trading, inventory), and many more!\r\n");
	Label content5_3 = create.content("Learn, practice, and then join the huge community of developers around the world creating the content of the future!");
	next5.setOnAction(e -> window.setScene(scene6)); 
	prev5.setOnAction(e -> window.setScene(scene4)); 
	
	vbox5.getChildren().addAll(content5_1, content5_2, content5_3, next5, prev5);
	scene5 = new Scene(vbox5, 600, 500);
	scene5.getStylesheets().add("Style.css");
	
//page 6
	GridPane grid6 = l.multipleChoiceLayout("Which one of the following statements is true?", "Java has a huge developer community.", 
			"Java is used only in web and mobile applications.", "Java is used only in NASA's space related applications.", "BLAH!");
	
	Button prev6 = create.button("Prev");
	Button next6 = create.button("Next");
	prev6.setOnAction(e -> window.setScene(scene5)); 
	next6.setOnAction(e -> window.setScene(scene7));
	GridPane.setConstraints(prev6,0,10);
	GridPane.setConstraints(next6,0,9);
	
	grid6.getChildren().addAll(prev6, next6);
	scene6 = new Scene(grid6, 600, 500);
	scene6.getStylesheets().add("Style.css");
	
	
//page 7
	String question7 = "Example blah blah blac _______ blah blah blah. ";
	GridPane gridpane7 = l.FIBLayout(question7, 2);
	
	Button prev7 = create.button("Prev");
	Button menu7 = create.button("Go To Menu");
	prev7.setOnAction(e -> window.setScene(scene6)); 
	menu7.setOnAction(e -> window.setScene(scene1));
	GridPane.setConstraints(prev7,0,12);
	GridPane.setConstraints(menu7,0,13);
	
	gridpane7.getChildren().addAll(prev7, menu7);
	scene7 = new Scene(gridpane7, 600, 500);
	scene7.getStylesheets().add("Style.css");
	
	window.setScene(scene1);
	window.setTitle("591 Study Buddy");
	window.getStyle();
	window.show();	
	
}




}
<<<<<<< HEAD
=======






<<<<<<< HEAD
>>>>>>> bf6450e1361b0b4308c3583c8b8867bebfe13ae7
=======



>>>>>>> bf6450e1361b0b4308c3583c8b8867bebfe13ae7

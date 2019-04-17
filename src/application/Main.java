package application;
	
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
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {

Stage window;
Scene scene1, scene2, scene3, scene4, scene5, scene6;

public static void main(String[] args) {
	launch(args);
}

@Override
public void start(Stage primaryStage) throws Exception{
	window = primaryStage;
	createMainButtons create = new createMainButtons();
	
	
//page 1
	GridPane grid1 = create.setGrid();
	Label title = new Label("Welcome to Java!");
	Label menu = new Label("Menu:");
	Button goToLesson1 = new Button("Go to Lesson 1");
	goToLesson1.setOnAction(e -> window.setScene(scene2)); //brings you to new page
	GridPane.setConstraints(title,0,0);
	GridPane.setConstraints(menu,3,5);
	GridPane.setConstraints(goToLesson1, 3,6);
	grid1.getChildren().addAll(title, menu, goToLesson1);
	scene1 = new Scene(grid1, 500, 300);
	
	
//page 2
	Button next2 = create.next();
	Button prev2 = create.prev();
	Label content2 = create.content("Java is a general-purpose computer-programming language originally developed by  James Gosling at Sun Microsystems and released in 1995.");
	next2.setOnAction(e -> window.setScene(scene3)); 
	prev2.setOnAction(e -> window.setScene(scene1)); 
	VBox layout2 = new VBox(20);
	layout2.setPadding(new Insets(20,20,20,20));
	layout2.getChildren().addAll(content2, next2, prev2);
	layout2.setAlignment(Pos.CENTER);
	scene2 = new Scene(layout2, 500, 300);
	
	
//page 3
	Button next3 = create.next();
	Button prev3 = create.prev();
	Label content3_1 = create.content("Java gained widespread popularity for being Platform Independent, which means that you only need to write the program once to be able to run it on a number of different platforms!");
	Label content3_2 = create.content("Today java is one of the most popular languages in the world with over 9 million developers.");
	Label content3_3 = create.content("Java intends to let application developers \"write once, run anywhere\"");
	next3.setOnAction(e -> window.setScene(scene4)); 
	prev3.setOnAction(e -> window.setScene(scene2)); 
	VBox layout3 = new VBox(20);
	layout3.setPadding(new Insets(20,20,20,20));
	layout3.getChildren().addAll(content3_1, content3_2, content3_3, next3, prev3);
	layout3.setAlignment(Pos.CENTER);
	scene3 = new Scene(layout3, 500, 300);

	
//page 4
	GridPane grid4 = create.setGrid();
	Button next4 = create.next();
	Button prev4 = create.prev();
	Button submit4 = create.submit();
	Label response4 = create.response();
	Label questionTitle4 = create.question("To distribute your application to different platforms, how many Java versions do you need to create?");
	questionTitle4.setWrapText(true);
	next4.setOnAction(e -> window.setScene(scene5)); 
	prev4.setOnAction(e -> window.setScene(scene3)); 
	RadioButton radio1, radio2, radio3;
	radio1=new RadioButton("Two versions");
	radio2= new RadioButton("One for each platform");
	radio3= new RadioButton("Just one version");
	ToggleGroup question4= new ToggleGroup();
	radio1.setToggleGroup(question4);
	radio2.setToggleGroup(question4);
	radio3.setToggleGroup(question4);
	submit4.setDisable(true);
	radio1.setOnAction(e -> submit4.setDisable(false) );
	radio2.setOnAction(e -> submit4.setDisable(false) );
	radio3.setOnAction(e -> submit4.setDisable(false) );
	submit4.setOnAction(e -> {
		if (radio3.isSelected()) {
			response4.setText("Correct answer");
			submit4.setDisable(true);
		}
		else {
			response4.setText("Wrong answer");
			submit4.setDisable(true);
		}           
	});
	GridPane.setConstraints(next4,0,8);
	GridPane.setConstraints(prev4,0,9);
	GridPane.setConstraints(questionTitle4,0,0);
	GridPane.setConstraints(submit4,0,5);
	GridPane.setConstraints(response4,0,6);
	GridPane.setConstraints(radio1,0,2);
	GridPane.setConstraints(radio2,0,3);
	GridPane.setConstraints(radio3,0,4);
	grid4.setPadding(new Insets(20,20,20,20));;
	grid4.getChildren().addAll(questionTitle4, radio1, radio2, radio3, submit4, response4, next4, prev4);
	grid4.setAlignment(Pos.CENTER);
	scene4 = new Scene(grid4, 500, 300);
	
	
//page 5
	Button next5 = create.next();
	Button prev5 = create.prev();
	Label content5_1 = create.content("Java runs on more than 3 billion devices. ");
	Label content5_2 = create.content("Java is used to develop apps for Google's Android OS, various Desktop Applications,, Web Applications, Enterprise Applications (i.e. trading, inventory), and many more!\r\n");
	Label content5_3 = create.content("Learn, practice, and then join the huge community of developers around the world creating the content of the future!");
	next5.setOnAction(e -> window.setScene(scene6)); 
	prev5.setOnAction(e -> window.setScene(scene4)); 
	VBox layout5 = new VBox(20);
	layout5.setPadding(new Insets(20,20,20,20));
	layout5.getChildren().addAll(content5_1, content5_2, content5_3, next5, prev5);
	layout5.setAlignment(Pos.CENTER);
	scene5 = new Scene(layout5, 500, 300);
	
	
//page 6
	GridPane grid6 = create.setGrid();
	Button main6 = create.goToMenu();
	Button prev6 = create.prev();
	Button submit6 = create.submit();
	Label response6 = create.response();
	Label questionTitle6 = create.question("Which one of the following statements is true?");
	questionTitle6.setWrapText(true);
	main6.setOnAction(e -> window.setScene(scene1)); 
	prev6.setOnAction(e -> window.setScene(scene3)); 
	RadioButton radio6_1, radio6_2, radio6_3;
	radio6_1=new RadioButton("Java has a huge developer community.");
	radio6_2= new RadioButton("Java is used only in web and mobile applications.");
	radio6_3= new RadioButton("Java is used only in NASA's space related applications.");
	ToggleGroup question6= new ToggleGroup();
	radio6_1.setToggleGroup(question6);
	radio6_2.setToggleGroup(question6);
	radio6_3.setToggleGroup(question6);
	submit6.setDisable(true);
	radio6_1.setOnAction(e -> submit6.setDisable(false) );
	radio6_2.setOnAction(e -> submit6.setDisable(false) );
	radio6_3.setOnAction(e -> submit6.setDisable(false) );
	submit6.setOnAction(e -> {
		if (radio6_1.isSelected()) {
			response6.setText("Correct answer");
			submit6.setDisable(true);
		}
		else {
			response6.setText("Wrong answer");
			submit6.setDisable(true);
		}           
	});
	GridPane.setConstraints(main6,0,8);
	GridPane.setConstraints(prev6,0,9);
	GridPane.setConstraints(questionTitle6,0,0);
	GridPane.setConstraints(submit6,0,5);
	GridPane.setConstraints(response6,0,6);
	GridPane.setConstraints(radio6_1,0,2);
	GridPane.setConstraints(radio6_2,0,3);
	GridPane.setConstraints(radio6_3,0,4);
	grid6.setPadding(new Insets(20,20,20,20));;
	grid6.getChildren().addAll(questionTitle6, radio6_1, radio6_2, radio6_3, submit6, response6, main6, prev6);
	grid6.setAlignment(Pos.CENTER);
	scene6 = new Scene(grid6, 500, 300);
	
	
	window.setScene(scene1);
	window.setTitle("Jack and Alexandra - Project Name");
	window.show();	
}


}




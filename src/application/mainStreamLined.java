package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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


public class mainStreamLined extends Application {

	
//State variables	
Stage window;
Scene beforeScene, afterScene, currentScene, scene1, scene2, scene3, scene4, scene5, scene6;
createMainButtons create;
Topic currentTopic;
int lessonIndex;
ArrayList<Topic> javaTopics;



//pull scribbles from a file
public void setUpQs() {
	javaTopics = new ArrayList<Topic>();
	lessonIndex = 0;
	
	File file = new File("ContentHash.txt");

	try {
		Scanner scanner = new Scanner(file);
		//skip the label row
		scanner.nextLine();
		//grab the goods
		while (scanner.hasNextLine()) {
	

	
	//this is where we would read in the data and input here
	//for pulling as a loop insert that variable instead of "Basics"
			String row = scanner.nextLine();
			//System.out.println("row, row, row, your boat"+row);
			
			String [] column = row.split("#");
			String lesson = "";
			Topic myTopic = new Topic("");
//			for(String temp: column) {
//				//System.out.println(temp);
//			}
			
//this is to avoid index out of bounds errors
			//both content and questions share these fields
			if (column.length >= 4) {
				
		//grab the topic from the file.	
		String topic = column[1];	
		
	//check to see if topic already exists inside javaTopics, if not create a new topic and add to arraylist
	boolean exists = false;
	for (Topic thisTopic : javaTopics) {
		if(thisTopic.getLesson().equalsIgnoreCase(topic))
		{
			exists = true;
			myTopic = thisTopic;
		}
	}
	
	if (exists == false) {
			myTopic = new Topic(topic);
	javaTopics.add(myTopic);
		
	}
	
		
			
			String type   		= column[0];
			String module 		= column[1];
			lesson 				= column[2];
			String page 		= column[3];
			
			}
			
			//content fields
			if (column[0].trim().equalsIgnoreCase("c") && column.length >=5) {
				
			String content		= column[4];
			//System.out.println(content);
			Content myContent = new Content(lesson, content);
			myTopic.addContent(myContent);
			//System.out.println("c");
			}
			else if (column.length >= 11){
			//question fields
			String questionType = column[5];
			String question 	= column[6];
			//System.out.println(question);
			String correctAnswer= column[7];
			String wrongAnswer1 = column[8];
			String wrongAnswer2 = column [9];
			String wrongAnswer3 = column[10];
			
			Question myQuestion = new Question(question, correctAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3, lesson);
			myTopic.addQuestion(myQuestion);
			}
//			String FIB1 = column[11];
//			String FIB2 = column[12];

		}
			
		
		scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




@Override
public void start(Stage primaryStage) throws Exception{
	window 	= primaryStage;
	 create = new createMainButtons();
	
setUpQs();
//for (Topic myTopic : javaTopics) {
//	System.out.println(myTopic);
//}

//these will become the two paramerters passed to style functions
Topic currentTopic = javaTopics.get(0);
TextScribbles currentScribbles = currentTopic.getText().get(0);


//page 1
	GridPane grid1 = create.setGrid();
	Label title = new Label("Welcome to Java!");
	Label menu = new Label("Menu:");
	GridPane.setConstraints(title,0,0);
	GridPane.setConstraints(menu,3,5);
	grid1.getChildren().add(title);
	grid1.getChildren().add(menu);
	scene1 = new Scene(grid1, 500, 300);
	scene1.getStylesheets().add("Style.css");
	int r = 3; int c = 6;
	//dynamically add buttons
	for(Topic temp: javaTopics) {
		Button goToLesson1 = new Button(temp.getLesson());
		goToLesson1.setOnAction(e -> goToChosenTopic(temp, scene1)); //brings you to new page
		GridPane.setConstraints(goToLesson1, r,c);
	//handle button locations	
		c++;
		if(c>10) {
			c = 6;
			r++;
		}
		grid1.getChildren().add(goToLesson1);
	}
	
	
	
	
	
	

	
	//page 2
//	beforeScene = scene1;
//	afterScene = scene3;
//beforeScene = contentPage(1,beforeScene, afterScene, "Java is a general-purpose computer-programming language originally developed by  James Gosling at Sun Microsystems and released in 1995.");
//afterScene = scene4;
//beforeScene = contentPage(2,beforeScene, afterScene, "Java gained widespread popularity for being Platform Independent, which means that you only need to write the program once to be able to run it on a number of different platforms! \n Today java is one of the most popular languages in the world with over 9 million developers. \n Java intends to let application developers \\\"write once, run anywhere\\\"");
	
////page 3
//	Button next3 = create.next();
//	Button prev3 = create.prev();
//	Label content3_1 = create.content();
//	Label content3_2 = create.content("");
//	Label content3_3 = create.content("");
//	next3.setOnAction(e -> window.setScene(scene4)); 
//	prev3.setOnAction(e -> window.setScene(scene2)); 
//	VBox layout3 = new VBox(20);
//	layout3.setPadding(new Insets(20,20,20,20));
//	layout3.getChildren().addAll(content3_1, content3_2, content3_3, next3, prev3);
//	layout3.setAlignment(Pos.CENTER);
//	scene3 = new Scene(layout3, 500, 300);
//	scene3.getStylesheets().add("Style.css");
	

	

	

	
	window.setScene(scene1);
	window.setTitle("Alack Quander's - 591 Study Guide");
	window.getStyle();
	window.show();	
}

/**
 * 
 * @param myTopic,this is Module eg Basics and from this we derive our lesson data eg content and questions.
 * @param prevScene, should always be the main menu.
 */

public void goToChosenTopic(Topic myTopic, Scene prevScene) {
	
	currentTopic = myTopic;
	lessonIndex = 0;
	TextScribbles scribbles = myTopic.getText().get(0); //what is this grabbing?
	
	//this if/else block should be very similar to what needs to be done to set up the content pages.
	if(scribbles instanceof Content) {
		currentScene = contentPage(lessonIndex, prevScene, ((Content)scribbles).getText());
		window.setScene(currentScene);
		System.out.println("go go gadget IF");
	}
	else {
		currentScene = contentPage(lessonIndex, prevScene, ((Question)scribbles).getQuestion());
		window.setScene(currentScene);
		System.out.println("go go gadget Else");
		
	}
	
	
}


/**
 * 
 * @param lessonPageIndex----how is this useful?
 * @param prevScene -- the previous scene
 * @param content -- informative text to teach user how to (Java)
 * @return
 */


public Scene contentPage(int lessonPageIndex,Scene prevScene, String content)// do I need to change from content to text?
{
//page 2
	System.out.println(content);
	Button next2 = create.next();
	Button prev2 = create.prev();
	Label content2 = create.content(content);
	//Scene nextScene = just like
	
	//if next is content or question
	next2.setOnAction(e -> window.setScene(lessonPageIndex)); //how do i dynamically create the scene? push the index through some function?
	prev2.setOnAction(e -> window.setScene(prevScene)); 
	VBox layout2 = new VBox(20);
	layout2.setPadding(new Insets(20,20,20,20));
	layout2.getChildren().addAll(content2, next2, prev2);
	layout2.setAlignment(Pos.CENTER);
	currentScene = new Scene(layout2, 500, 300);
	currentScene.getStylesheets().add("Style.css");
	return currentScene;
}



//public Scene questionPage4(int lessonPageIndex,Scene prevScene, Scene nextScene, Question question)
//{
//////page 4
//	GridPane grid4 = create.setGrid();
//	Button next4 = create.next();
//	Button prev4 = create.prev();
//	Button submit4 = create.submit();
//	Label response4 = create.response();
//	Label questionTitle4 = create.question(currentQuestion.getQuestion());
//	System.out.println(currentQuestion.getCorrectedness());
//	questionTitle4.setWrapText(true);
//	next4.setOnAction(e -> window.setScene(scene5)); 
//	prev4.setOnAction(e -> window.setScene(scene3)); 
//	RadioButton radio1, radio2, radio3;
//	radio1=new RadioButton(currentQuestion.getWrong1());
//	radio2= new RadioButton(currentQuestion.getWrong2());
//	radio3= new RadioButton(currentQuestion.getAnswer());
//	ToggleGroup question4= new ToggleGroup();
//	radio1.setToggleGroup(question4);
//	radio2.setToggleGroup(question4);
//	radio3.setToggleGroup(question4);
//	submit4.setDisable(true);
//	radio1.setOnAction(e -> submit4.setDisable(false) );
//	radio2.setOnAction(e -> submit4.setDisable(false) );
//	radio3.setOnAction(e -> submit4.setDisable(false) );
//	submit4.setOnAction(e -> {
//		if (radio3.isSelected()) {
//			response4.setText("Correct answer");
//			submit4.setDisable(true);
//			currentQuestion.gotCorrect(true);
//		}
//		else {
//			response4.setText("Wrong answer");
//			submit4.setDisable(true);
//			currentQuestion.gotCorrect(false);
//		}  
//		
//		System.out.println(currentQuestion.getCorrectedness());
//	});
//	
//	
//	GridPane.setConstraints(next4,0,8);
//	GridPane.setConstraints(prev4,0,9);
//	GridPane.setConstraints(questionTitle4,0,0);
//	GridPane.setConstraints(submit4,0,5);
//	GridPane.setConstraints(response4,0,6);
//	GridPane.setConstraints(radio1,0,2);
//	GridPane.setConstraints(radio2,0,3);
//	GridPane.setConstraints(radio3,0,4);
//	grid4.setPadding(new Insets(20,20,20,20));;
//	grid4.getChildren().addAll(questionTitle4, radio1, radio2, radio3, submit4, response4, next4, prev4);
//	grid4.setAlignment(Pos.CENTER);
//	scene4 = new Scene(grid4, 500, 300);
//	scene4.getStylesheets().add("Style.css");
//}







//public Scene contentPage5(int lessonPageIndex,Scene prevScene, Scene nextScene, String content)
//{
////page 5
//	Button next5 = create.next();
//	Button prev5 = create.prev();
//	
//	Label content5_1 = create.content("Java runs on more than 3 billion devices. ");
//	Label content5_2 = create.content("Java is used to develop apps for Google's Android OS, various Desktop Applications,, Web Applications, Enterprise Applications (i.e. trading, inventory), and many more!\r\n");
//	Label content5_3 = create.content("Learn, practice, and then join the huge community of developers around the world creating the content of the future!");
//	next5.setOnAction(e -> window.setScene(scene6)); 
//	prev5.setOnAction(e -> window.setScene(scene4)); 
//	VBox layout5 = new VBox(20);
//	layout5.setPadding(new Insets(20,20,20,20));
//	layout5.getChildren().addAll(content5_1, content5_2, content5_3, next5, prev5);
//	layout5.setAlignment(Pos.CENTER);
//	scene5 = new Scene(layout5, 500, 300);
//	scene5.getStylesheets().add("Style.css");
//}
//
//public Scene questionPage6(int lessonPageIndex,Scene prevScene, Scene nextScene, String content)
//{
////page 6
//	GridPane grid6 = create.setGrid();
//	Button main6 = create.goToMenu();
//	Button prev6 = create.prev();
//	Button submit6 = create.submit();
//	Label response6 = create.response();
//	Label questionTitle6 = create.question("Which one of the following statements is true?");
//	questionTitle6.setWrapText(true);
//	main6.setOnAction(e -> window.setScene(scene1)); 
//	prev6.setOnAction(e -> window.setScene(scene3)); 
//	RadioButton radio6_1, radio6_2, radio6_3;
//	radio6_1=new RadioButton("Java has a huge developer community.");
//	radio6_2= new RadioButton("Java is used only in web and mobile applications.");
//	radio6_3= new RadioButton("Java is used only in NASA's space related applications.");
//	ToggleGroup question6= new ToggleGroup();
//	radio6_1.setToggleGroup(question6);
//	radio6_2.setToggleGroup(question6);
//	radio6_3.setToggleGroup(question6);
//	submit6.setDisable(true);
//	radio6_1.setOnAction(e -> submit6.setDisable(false) );
//	radio6_2.setOnAction(e -> submit6.setDisable(false) );
//	radio6_3.setOnAction(e -> submit6.setDisable(false) );
//	submit6.setOnAction(e -> {
//		if (radio6_1.isSelected()) {
//			response6.setText("Correct answer");
//			submit6.setDisable(true);
//		}
//		else {
//			response6.setText("Wrong answer");
//			submit6.setDisable(true);
//		}           
//	});
//	GridPane.setConstraints(main6,0,8);
//	GridPane.setConstraints(prev6,0,9);
//	GridPane.setConstraints(questionTitle6,0,0);
//	GridPane.setConstraints(submit6,0,5);
//	GridPane.setConstraints(response6,0,6);
//	GridPane.setConstraints(radio6_1,0,2);
//	GridPane.setConstraints(radio6_2,0,3);
//	GridPane.setConstraints(radio6_3,0,4);
//	grid6.setPadding(new Insets(20,20,20,20));;
//	grid6.getChildren().addAll(questionTitle6, radio6_1, radio6_2, radio6_3, submit6, response6, main6, prev6);
//	grid6.setAlignment(Pos.CENTER);
//	
//	scene6 = new Scene(grid6, 500, 300);
//	scene6.getStylesheets().add("Style.css");
//}
public static void main(String[] args) {
	launch(args);
}
}




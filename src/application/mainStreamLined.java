package application;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainStreamLined extends Application {

	//State variables	
		Stage window;
		Scene beforeScene, afterScene, currentScene, topicMenu, lessonMenu;
		CreateMainButtons createButton;
		CreateMainLayout createLayout;
		GetMultipleChoice multipleChoice;
		int lessonIndex;
		ArrayList<Topic> javaTopics;
		String windowTitle = "Alack-Quander 591 Study Buddy";
		Reader reader = new Reader();
		String style = "Style.css";
		
	//Topic Menu
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		createButton = new CreateMainButtons();
		createLayout = new CreateMainLayout();
		javaTopics = reader.topics();
		
		/*
		 * Create panels for BorderPane
		 * @param center is a GridPane in the center panel of BorderPane
		 * @param right is a VBox in the right panel of BorderPane
		 * @param left is a VBox in the right panel of BorderPane
		 * @param top is a GridPane in the top panel of BorderPane
		 * @param bottom is an HBox in the bottom panel of BorderPane
		 * @param title will appear in 
		 */
		GridPane center = createLayout.setGrid();
		VBox right = createLayout.setVbox();
		VBox left = createLayout.setVbox();
		GridPane top = createLayout.setGrid();
		Label title = createButton.title("Welcome to Alack-Quander 591 Study Buddy!");
		
		GridPane.setConstraints(title, 8, 1);
		top.getChildren().add(title);
	    title.getStyleClass().add("label-title");
		
		//center: add buttons for each Topic to grid using ArrayList of Topics
		lessonIndex = 0;
		int r = 3;
		int c = 4;
		for (Topic temp : javaTopics) {
			Button btnTopic = createButton.topicButton(temp.getTopic());
			//Brings you to list of lessons for the chosen Topic
			btnTopic.setOnAction(e -> goToLessons(primaryStage, temp)); 
			GridPane.setConstraints(btnTopic, r, c);
			//Place buttons in grid
			c++;
			if (c > 10) {
				c = 4;
				r++;
		}
		center.getChildren().add(btnTopic);
		}
		
		Label menu = createButton.title("Lesson: ");
		menu.setId("big-label"); //specific style from CSS (not applied to all labels)
		GridPane.setConstraints(menu, 2, 2);
		center.getChildren().addAll(menu);
		
		/*
		 * Add panels to BorderPane and set scene/window
		 */
		BorderPane bp = createLayout.setBorderPane(right, center, left, top);
		topicMenu = new Scene(bp, 900, 800);
		window.setScene(topicMenu);
		topicMenu.getStylesheets().add(style);
		window.setTitle(windowTitle);
		window.show();
	}
	
	//Lesson menu
	public void goToLessons(Stage primaryStage, Topic currentTopic) {
		window = primaryStage;
		window.setTitle(windowTitle);
		
		/*
		 * Create panels for BorderPane
		 * @param center is a GridPane in the center panel of BorderPane
		 * @param right is a VBox in the right panel of BorderPane
		 * @param left is a VBox in the right panel of BorderPane
		 * @param top is a GridPane in the top panel of BorderPane
		 * @param bottom is an HBox in the bottom panel of BorderPane
		 * @param title will appear in 
		 */
		GridPane center = createLayout.setGrid();
		VBox right = createLayout.setVbox();
		VBox left = createLayout.setVbox();
		GridPane top = createLayout.setGrid();
		String t = "Topic: " + currentTopic.getTopic();
		Label title = createButton.title(t);
		
		title.getStyleClass().add("label-title");
		GridPane.setConstraints(title, 8, 1);
		top.getChildren().add(title);
		
		//Create button to bring you to previous page. Place in right panel.
		Button p = createButton.prev();
		p.setOnAction(e -> getToThePreviousScreen(topicMenu));
		left.getChildren().addAll(p);
		
		//Add buttons to the grid for each topic (using ArrayList of lessons)
		lessonIndex = 0;
		int r = 3;
		int c = 2;
		ArrayList<Lesson> lessons = currentTopic.getLessons();
			for (Lesson temp : lessons) {
				Button btnLesson = new Button(temp.getLesson());
				btnLesson.setOnAction(e -> getToTheNextScreen(currentTopic, temp, lessonMenu)); // brings you to new page
				btnLesson.getStyleClass().add("button-transparent");
				GridPane.setConstraints(btnLesson, r, c);
				//Place buttons in grid
				c++;
				if (c > 15) {
					c = 2;
					r++;
				}
			center.getChildren().add(btnLesson);
			}
		
		/*
		 * Add panels to BorderPane and set scene/window
		 */
		BorderPane bp = createLayout.setBorderPane(right, center, left, top);
		lessonMenu = new Scene(bp, 900, 800);
		window.setScene(lessonMenu);
		lessonMenu.getStylesheets().add(style);
		window.setTitle(windowTitle);
		window.show();
	}

	/**
	 * While lesson has a next Screen navigate to it, else return to the lesson menu
	 * @param myTopic the topic from which the lessons are derived
	 * @param myLesson the lesson we are referring to
	 * @param prevScene the scene that came before
	 */
	public void getToTheNextScreen(Topic myTopic, Lesson myLesson, Scene prevScene) {
		lessonIndex++; 
		ArrayList<TextScribbles> contentAndQuestions = myLesson.getText();
		// see if Lesson has next index
		if (lessonIndex <= contentAndQuestions.size()) {
			TextScribbles scribbles = contentAndQuestions.get(lessonIndex-1); 
			if (scribbles instanceof Content) {
				currentScene = contentPage(lessonIndex, myTopic, myLesson, prevScene, ((Content) scribbles).getText());
				window.setScene(currentScene);
			} else {
				currentScene = questionPage(lessonIndex, myTopic, myLesson, prevScene, ((Question) scribbles));
				window.setScene(currentScene);
				window.setTitle(windowTitle);
			}
		}
		//no next screen in lesson, return to lesson menu
		else {
			window.setScene(lessonMenu);
			window.setTitle(windowTitle);
			lessonIndex = 0;
		}
	}

	public void getToThePreviousScreen(Scene prevScene) {
		lessonIndex--;
		window.setScene(prevScene);
	}

	/**
	 * 
	 * @param lessonPageIndex-- used to navigate lessons arrayList
	 * @param prevScene -- the previous scene
	 * @param content   -- informative text to teach user how to (Java)
	 * @return
	 */
	public Scene contentPage(int lessonPageIndex, Topic myTopic, Lesson myLesson, Scene prevScene, String content)	{

		/*
		 * Create panels for BorderPane
		 * @param center is a GridPane in the center panel of BorderPane
		 * @param right is a VBox in the right panel of BorderPane
		 * @param left is a VBox in the right panel of BorderPane
		 * @param top is a GridPane in the top panel of BorderPane
		 * @param bottom is an HBox in the bottom panel of BorderPane
		 * @param title will appear in 
		 */
		GridPane center = createLayout.setGrid();
		VBox right = createLayout.setVbox();
		VBox left = createLayout.setVbox();
		GridPane top = createLayout.setGrid();
		String lesson = myLesson.getLesson();
	    Label title = createButton.title("Lesson: " + lesson);
		
	    top.getChildren().add(title);
	    GridPane.setConstraints(title, 8, 1);
	    title.getStyleClass().add("label-title");
	    
	    //Create label for content text. Place in center panel.
		Label c = createButton.content(content);
		GridPane.setConstraints(c, 2, 2);
		center.getChildren().add(c);
		
		Button n = createButton.next();
		Button p = createButton.prev();
		n.setOnAction(e -> getToTheNextScreen(myTopic, myLesson, currentScene)); 
		p.setOnAction(e -> getToThePreviousScreen(prevScene));
	    right.getChildren().add(n);
	    left.getChildren().add(p);

	    /*
		 * Add panels to BorderPane and set scene
		 */
	    BorderPane bp = createLayout.setBorderPane(right, center, left, top);
	    currentScene = new Scene(bp, 900, 800);
		currentScene.getStylesheets().add(style);
		return currentScene;
	}

	public Scene questionPage(int lessonPageIndex, Topic myTopic, Lesson myLesson, Scene prevScene, Question myQuestion) {
	
		/*
		 * Create panels for BorderPane
		 * @param center is a GridPane in the center panel of BorderPane
		 * @param right is a VBox in the right panel of BorderPane
		 * @param left is a VBox in the right panel of BorderPane
		 * @param top is a GridPane in the top panel of BorderPane
		 * @param bottom is an HBox in the bottom panel of BorderPane
		 * @param title will appear in 
		 */
		GridPane center = createLayout.setGrid();
		VBox right = createLayout.setVbox();
		VBox left = createLayout.setVbox();
		GridPane top = createLayout.setGrid();	
		
		String lesson = myLesson.getLesson();
	    Label title = createButton.title("Lesson: " + lesson);
	    top.getChildren().add(title);
	    GridPane.setConstraints(title, 8, 1);
	    title.getStyleClass().add("label-title");
		
		//Create button to bring you to previous/next page. Place in right panel.
		Button n = createButton.next();
		Button p = createButton.prev();
		n.setOnAction(e -> getToTheNextScreen(myTopic, myLesson, currentScene)); 
		p.setOnAction(e -> getToThePreviousScreen(prevScene));
	    right.getChildren().add(n);
	    left.getChildren().add(p);
	    
		//Get answer choices (1 correct, 3 incorrect) from myQuestion. 
		String correctMC1   = myQuestion.getAnswer();
		String incorrectMC2 = myQuestion.getWrong1();
		String incorrectMC3 = myQuestion.getWrong2();
		String incorrectMC4 = myQuestion.getWrong3();
		Button submit = createButton.submit();
		Label response = createButton.content("");
		Label question = createButton.question(myQuestion.getQuestion());
		
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
		GridPane.setConstraints(question,2,2);
		GridPane.setConstraints(answerRadio.get(0),2,4);
		GridPane.setConstraints(answerRadio.get(1),2,5);
		GridPane.setConstraints(answerRadio.get(2),2,6);
		GridPane.setConstraints(answerRadio.get(3),2,7);
		GridPane.setConstraints(submit,2,9);
		GridPane.setConstraints(response,2,10);
		center.getChildren().addAll(question, radio1, radio2, radio3, radio4, response, submit);
		
		/*
		 * Add panels to BorderPane and set scene
		 */
		BorderPane bp = createLayout.setBorderPane(right, center, left, top);
		currentScene = new Scene(bp, 900, 800);
		currentScene.getStylesheets().add(style);
		return currentScene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}

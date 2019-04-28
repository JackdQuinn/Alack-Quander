package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
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
	Scene beforeScene, afterScene, currentScene, topicMenu, lessonMenu;
	createMainButtons create;

	int lessonIndex;
	ArrayList<Topic> javaTopics;

//pull scribbles from a file
	public void setUpQs() {
		javaTopics = new ArrayList<Topic>();
		lessonIndex = 0; // offset for goToChosen topic increment call

		File file = new File("ContentHash.txt");

		try {
			Scanner scanner = new Scanner(file);
			// skip the label row
			scanner.nextLine();
			// grab the goods
			while (scanner.hasNextLine()) {

				// this is where we would read in the data and input here
				// for pulling as a loop insert that variable instead of "Basics"
				String row = scanner.nextLine();
				// System.out.println("row, row, row, your boat"+row);

				String[] column = row.split("#");
				Topic myTopic = new Topic("");
				Lesson myLesson = new Lesson("");


//this is to avoid index out of bounds errors
				// both content and questions share these fields
				if (column.length >= 4) {

					// grab the topic from the file.
					String topic = column[1].trim();
					String lessonText = column[2];
					// check to see if topic already exists inside javaTopics, if not create a new
					// topic and add to arraylist
					boolean exists = false;
					for (Topic thisTopic : javaTopics) {
						if (thisTopic.getTopic().equalsIgnoreCase(topic)) {
							exists = true;
							myTopic = thisTopic;
						}
					}

					if (exists == false) {
						myTopic = new Topic(topic.trim());
						javaTopics.add(myTopic);

					}

					// check to see if lesson already exists inside the Topic Object
					myLesson = myTopic.addLesson(lessonText.trim());

					String type = column[0];
					String module = column[1];

					String page = column[3];

				}

				// content fields
				if (column[0].trim().equalsIgnoreCase("c") && column.length >= 5) {

					String content = column[4];
					//System.out.println(content);
					Content myContent = new Content(content);
					myLesson.addContent(myContent);
					// System.out.println("c");
				} else if (column.length >= 11) {
					// question fields
					String questionType = column[5];
					String question = column[6];
					// System.out.println(question);
					String correctAnswer = column[7];
					String wrongAnswer1 = column[8];
					String wrongAnswer2 = column[9];
					String wrongAnswer3 = column[10];

					Question myQuestion = new Question(question, correctAnswer, wrongAnswer1, wrongAnswer2,
							wrongAnswer3);
					myLesson.addQuestion(myQuestion);
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
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		create = new createMainButtons();

		setUpQs();

		GridPane grid1 = create.setGrid();
		Label title = new Label("Welcome to Java!");
		Label menu = new Label("Menu:");
		GridPane.setConstraints(title, 0, 0);
		GridPane.setConstraints(menu, 3, 5);
		grid1.getChildren().add(title);
		grid1.getChildren().add(menu);
		topicMenu = new Scene(grid1, 500, 300);
		topicMenu.getStylesheets().add("Style.css");
		int r = 3;
		int c = 6;
		// dynamically add buttons
		lessonIndex = 0;
		for (Topic temp : javaTopics) {
			Button btnTopic = new Button(temp.getTopic());
			btnTopic.setOnAction(e -> goToLessons(primaryStage, temp)); // brings you to new page
			GridPane.setConstraints(btnTopic, r, c);
			// handle button locations
			c++;
			if (c > 10) {
				c = 6;
				r++;
			}
			grid1.getChildren().add(btnTopic);
		}

		window.setScene(topicMenu);
		window.setTitle("Alack Quander's - 591 Study Guide");
		window.getStyle();
		window.show();
	}

	public void goToLessons(Stage primaryStage, Topic currentTopic) {
		window = primaryStage;
		create = new createMainButtons();

		Button prev = create.prev();
		prev.setOnAction(e -> getToThePreviousScreen(topicMenu));
		GridPane grid1 = create.setGrid();
		Label title = new Label("Lesson Menu for " + currentTopic.getTopic());
		Label menu = new Label("Menu:");
		GridPane.setConstraints(title, 0, 0);
		GridPane.setConstraints(menu, 3, 5);
		GridPane.setConstraints(prev, 0, 18);
		grid1.getChildren().add(title);
		grid1.getChildren().add(menu);
		lessonMenu = new Scene(grid1, 500, 300);
		lessonMenu.getStylesheets().add("Style.css");
		int r = 3;
		int c = 6;
		// dynamically add buttons
		lessonIndex = 0;
		ArrayList<Lesson> lessons = currentTopic.getLessons();
		for (Lesson temp : lessons) {
			Button btnLesson = new Button(temp.getLesson());
			btnLesson.setOnAction(e -> getToTheNextScreen(currentTopic, temp, lessonMenu)); // brings you to new page
			GridPane.setConstraints(btnLesson, r, c);
			// handle button locations
			c++;
			if (c > 10) {
				c = 6;
				r++;
			}
			grid1.getChildren().add(btnLesson);
		}
		grid1.getChildren().add(prev);
		window.setScene(lessonMenu);
		window.setTitle("Alack Quander's - 591 Study Guide");
		window.getStyle();
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
		if (lessonIndex < contentAndQuestions.size()) {

			TextScribbles scribbles = contentAndQuestions.get(lessonIndex-1); 

			if (scribbles instanceof Content) {
				currentScene = contentPage(lessonIndex, myTopic, myLesson, prevScene, ((Content) scribbles).getText());
				window.setScene(currentScene);
				// System.out.println("go go gadget IF");
			} else {
				currentScene = questionPage(lessonIndex, myTopic, myLesson, prevScene, ((Question) scribbles));
				window.setScene(currentScene);
				// System.out.println("go go gadget Else");

			}

		}
		//no next screen in lesson, return to lesson menu
		else {
			window.setScene(lessonMenu);
			lessonIndex = 0;
		}

	}

	public void getToThePreviousScreen(Scene prevScene) {

		lessonIndex--;
		window.setScene(prevScene);
	}

	/**
	 * 
	 * @param lessonPageIndex-- used to nagivate lessons arraylist
	 * @param prevScene -- the previous scene
	 * @param content   -- informative text to teach user how to (Java)
	 * @return
	 */

	public Scene contentPage(int lessonPageIndex, Topic myTopic, Lesson myLesson, Scene prevScene, String content)	{

		System.out.println(content);
		Button next2 = create.next();
		Button prev2 = create.prev();
		Label content2 = create.content(content);

		next2.setOnAction(e -> getToTheNextScreen(myTopic, myLesson, currentScene)); 
		prev2.setOnAction(e -> getToThePreviousScreen(prevScene));
		VBox layout2 = new VBox(20);
		layout2.setPadding(new Insets(20, 20, 20, 20));
		layout2.getChildren().addAll(content2, next2, prev2);
		layout2.setAlignment(Pos.CENTER);
		currentScene = new Scene(layout2, 500, 300);
		currentScene.getStylesheets().add("Style.css");
		return currentScene;
	}

	public Scene questionPage(int lessonPageIndex, Topic myTopic, Lesson myLesson, Scene prevScene,
			Question myQuestion) {

		Button next2 = create.next();
		Button prev2 = create.prev();
		next2.setOnAction(e -> getToTheNextScreen(myTopic, myLesson, currentScene)); 
		prev2.setOnAction(e -> getToThePreviousScreen(prevScene));
		VBox layout2 = new VBox(20);
		layout2.setPadding(new Insets(20, 20, 20, 20));
		layout2.setAlignment(Pos.CENTER);
		currentScene = new Scene(layout2, 500, 300);
		currentScene.getStylesheets().add("Style.css");

		// add answer choices
		String question = myQuestion.getQuestion(), correctMC1 = myQuestion.getAnswer(),
				incorrectMC2 = myQuestion.getWrong1(), incorrectMC3 = myQuestion.getWrong2(),
				incorrectMC4 = myQuestion.getWrong3();

		Label questionTitle = create.content(question);
		Button submit = create.submit();
		Label response = create.content("");

//create radio buttons
		RadioButton radio1, radio2, radio3, radio4;
		radio1 = new RadioButton(correctMC1);
		radio2 = new RadioButton(incorrectMC2);
		radio3 = new RadioButton(incorrectMC3);
		radio4 = new RadioButton(incorrectMC4);
		ToggleGroup q = new ToggleGroup();
		radio1.setToggleGroup(q);
		radio2.setToggleGroup(q);
		radio3.setToggleGroup(q);
		radio4.setToggleGroup(q);
		submit.setDisable(true);
		radio1.setOnAction(e -> submit.setDisable(false));
		radio2.setOnAction(e -> submit.setDisable(false));
		radio3.setOnAction(e -> submit.setDisable(false));
		radio4.setOnAction(e -> submit.setDisable(false));
		submit.setOnAction(e -> {
			if (radio1.isSelected()) {
				response.setText("Correct answer");
				submit.setDisable(true);
			} else {
				response.setText("Wrong answer");
				submit.setDisable(true);
			}
		});

//arrange radioButtons in random order to place in grid
		ArrayList<RadioButton> answerRadio = new ArrayList<RadioButton>();
		answerRadio.add(radio1);
		answerRadio.add(radio2);
		answerRadio.add(radio3);
		answerRadio.add(radio4);
		Collections.shuffle(answerRadio);

//create grid and place all objects in it
		GridPane grid = new GridPane();
		GridPane.setConstraints(questionTitle, 0, 0);
		//GridPane.setConstraints(submit, 0, 6);
		GridPane.setConstraints(response, 0, 7);
		GridPane.setConstraints(answerRadio.get(0), 0, 2);
		GridPane.setConstraints(answerRadio.get(1), 0, 3);
		GridPane.setConstraints(answerRadio.get(2), 0, 4);
		GridPane.setConstraints(answerRadio.get(3), 0, 5);

//grid settings
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);
		;
		grid.setHgap(10);
		grid.getStylesheets().add("Style.css");
		grid.getChildren().addAll(questionTitle, radio1, radio2, radio3, radio4,
		 response);
		grid.setAlignment(Pos.CENTER);

		layout2.getChildren().addAll(questionTitle, radio1, radio2, radio3, radio4, response, next2, prev2, submit);

		return currentScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}

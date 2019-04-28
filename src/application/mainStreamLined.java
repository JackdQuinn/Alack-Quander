package application;

import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainStreamLined extends Application {

	//State variables	
	Stage window;
	Scene beforeScene, afterScene, currentScene, topicMenu, lessonMenu;
	createMainButtons create;
	int lessonIndex;
	ArrayList<Topic> javaTopics;
	String windowTitle = "Alack-Quander's 591 Study Guide";
	String windowStyle = "Style.css";
	Reader reader = new Reader();
	
	
//pull scribbles from a file
//		public void setUpQs() {
//		javaTopics = new ArrayList<Topic>();
//		lessonIndex = 0; // offset for goToChosen topic increment call
//
//		File file = new File("ContentHash.txt");
//
//		try {
//			Scanner scanner = new Scanner(file);
//			// skip the label row
//			scanner.nextLine();
//			// grab the goods
//			while (scanner.hasNextLine()) {
//
//				// this is where we would read in the data and input here
//				// for pulling as a loop insert that variable instead of "Basics"
//				String row = scanner.nextLine();
//				// System.out.println("row, row, row, your boat"+row);
//
//				String[] column = row.split("#");
//				Topic myTopic = new Topic("");
//				Lesson myLesson = new Lesson("");
//
//				//this is to avoid index out of bounds errors
//				// both content and questions share these fields
//				if (column.length >= 4) {
//
//					// grab the topic from the file.
//					String topic = column[1].trim();
//					String lessonText = column[2];
//					// check to see if topic already exists inside javaTopics, if not create a new
//					// topic and add to arraylist
//					boolean exists = false;
//					for (Topic thisTopic : javaTopics) {
//						if (thisTopic.getTopic().equalsIgnoreCase(topic)) {
//							exists = true;
//							myTopic = thisTopic;
//						}
//					}
//
//					if (exists == false) {
//						myTopic = new Topic(topic.trim());
//						javaTopics.add(myTopic);
//
//					}
//
//					// check to see if lesson already exists inside the Topic Object
//					myLesson = myTopic.addLesson(lessonText.trim());
//
//					String type = column[0];
//					String module = column[1];
//					String page = column[3];
//
//				}
//
//				// content fields
//				if (column[0].trim().equalsIgnoreCase("c") && column.length >= 5) {
//
//					String content = column[4];
//					//System.out.println(content);
//					Content myContent = new Content(content);
//					myLesson.addContent(myContent);
//					// System.out.println("c");
//				} else if (column.length >= 11) {
//					// question fields
//					String questionType = column[5];
//					String question = column[6];
//					//System.out.println(question);
//					String correctAnswer = column[7];
//					String wrongAnswer1 = column[8];
//					String wrongAnswer2 = column[9];
//					String wrongAnswer3 = column[10];
//
//					Question myQuestion = new Question(question, correctAnswer, wrongAnswer1, 
//							wrongAnswer2, wrongAnswer3);
//					myLesson.addQuestion(myQuestion);
//				}
////			String FIB1 = column[11];
////			String FIB2 = column[12];
//
//			}
//
//			scanner.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	//Topic Menu
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		create = new createMainButtons();
		
		//ONE DIFFERENCE WITH USING READER FILE
		javaTopics = reader.topics();
		//setUpQs();
		
		GridPane g = create.setGrid();
		Label title = new Label("Welcome!");
		Label menu = new Label("Menu:");
		GridPane.setConstraints(title, 0, 0);
		GridPane.setConstraints(menu, 3, 5);
		
		// dynamically add buttons
		lessonIndex = 0;
		int r = 3;
		int c = 6;
		for (Topic temp : javaTopics) {
			Button btnTopic = create.topicButton(temp.getTopic());
			btnTopic.setOnAction(e -> goToLessons(primaryStage, temp)); // brings you to new page
			GridPane.setConstraints(btnTopic, r, c);
			// handle button locations
			c++;
			if (c > 10) {
				c = 6;
				r++;
			}
			g.getChildren().add(btnTopic);
		}
		g.getChildren().addAll(title, menu);
		
		topicMenu = new Scene(g, 500, 300);
		topicMenu.getStylesheets().add(windowStyle);
		window.setScene(topicMenu);
		window.setTitle(windowTitle);
		window.getStyle();
		window.show();
	}
	
	//lesson menu
	public void goToLessons(Stage primaryStage, Topic currentTopic) {
		window = primaryStage;
	
		GridPane g = create.setGrid();
		
		Label title = new Label("Lesson Menu for " + currentTopic.getTopic());
		Label menu = new Label("Menu:");
		Button p = create.prev();
		p.setOnAction(e -> getToThePreviousScreen(topicMenu));

		GridPane.setConstraints(title, 0, 0);
		GridPane.setConstraints(menu, 3, 5);
		GridPane.setConstraints(p, 0, 18);
		
		// dynamically add buttons
		int r = 3;
		int c = 6;
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
			g.getChildren().add(btnLesson);
		}
		
		g.getChildren().addAll(title, menu, p);
		lessonMenu = new Scene(g, 500, 300);
		lessonMenu.getStylesheets().add(windowStyle);
		window.setScene(lessonMenu);
		window.setTitle(windowTitle);
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
		if (lessonIndex <= contentAndQuestions.size()) {
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
	 * @param lessonPageIndex-- used to navigate lessons arrayList
	 * @param prevScene -- the previous scene
	 * @param content   -- informative text to teach user how to (Java)
	 * @return
	 */
	
	public Scene contentPage(int lessonPageIndex, Topic myTopic, Lesson myLesson, Scene prevScene, String content)	{

		Label c = create.content(content);
		Button n = create.next();
		Button p = create.prev();
		
		n.setOnAction(e -> getToTheNextScreen(myTopic, myLesson, currentScene)); 
		p.setOnAction(e -> getToThePreviousScreen(prevScene));
		
		VBox vbox = new VBox(20);
		vbox.setPadding(new Insets(20, 20, 20, 20));
		vbox.getChildren().addAll(c, n, p);
		vbox.setAlignment(Pos.CENTER);
		
		currentScene = new Scene(vbox, 500, 300);
		currentScene.getStylesheets().add(windowStyle);
		return currentScene;
	}

	public Scene questionPage(int lessonPageIndex, Topic myTopic, Lesson myLesson, Scene prevScene,
			Question myQuestion) {
		
		// add question/response label and submit button
		String question = myQuestion.getQuestion();
		Label questionTitle = create.content(question);
		Button submit = create.submit();
		Label response = create.content("");
		
		// add answer choices 
		String correctMC1 = myQuestion.getAnswer(),
				incorrectMC2 = myQuestion.getWrong1(), 
				incorrectMC3 = myQuestion.getWrong2(),
				incorrectMC4 = myQuestion.getWrong3();
		
		//create prev and next button
		Button next2 = create.next();
		Button prev2 = create.prev();
		next2.setOnAction(e -> getToTheNextScreen(myTopic, myLesson, currentScene)); 
		prev2.setOnAction(e -> getToThePreviousScreen(prevScene));
		
		//create radio buttons
		RadioButton radio1, radio2, radio3, radio4;
		radio1=new RadioButton(correctMC1);
		radio2=new RadioButton(incorrectMC2);
		radio3=new RadioButton(incorrectMC3);
		radio4=new RadioButton(incorrectMC4);
		ToggleGroup q= new ToggleGroup();
		radio1.setToggleGroup(q);
		radio2.setToggleGroup(q);
		radio3.setToggleGroup(q);
		radio4.setToggleGroup(q);
		submit.setDisable(true);
		radio1.setOnAction(e -> submit.setDisable(false) );
		radio2.setOnAction(e -> submit.setDisable(false) );
		radio3.setOnAction(e -> submit.setDisable(false) );
		radio4.setOnAction(e -> submit.setDisable(false) );
		submit.setOnAction(e -> {
		if (radio1.isSelected()) {
			response.setText("Correct answer");
			submit.setDisable(true);
		}
		else {
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
		GridPane.setConstraints(questionTitle,0,0);
		GridPane.setConstraints(submit,0,6);
		GridPane.setConstraints(response,0,7);
		GridPane.setConstraints(answerRadio.get(0),0,2);
		GridPane.setConstraints(answerRadio.get(1),0,3);
		GridPane.setConstraints(answerRadio.get(2),0,4);
		GridPane.setConstraints(answerRadio.get(3),0,5);
		GridPane.setConstraints(prev2, 0, 10);
		GridPane.setConstraints(next2, 0, 9);
		
		//grid settings
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.getStylesheets().add("Style.css");
		grid.getChildren().addAll(questionTitle, radio1, radio2, radio3, radio4, response, next2, prev2, submit);
		grid.setAlignment(Pos.CENTER);
		
		//set current scene and add style sheet
		currentScene = new Scene(grid, 500, 300);
		currentScene.getStylesheets().add(windowStyle);
		return currentScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}




















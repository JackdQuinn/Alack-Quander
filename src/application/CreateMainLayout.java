package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/*
 * This class is used to create all layouts
 */
public class CreateMainLayout {
	
	//create GridPane -- then used as  parameter in BorderPane
	public GridPane setGrid() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(10);
		return grid;
	}
	
	//create VBox -- then used as  parameter in BorderPane
	public VBox setVbox() {
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10,10,10,10));
		vbox.setAlignment(Pos.CENTER);
		return vbox;
	}
	
	//create HBox -- then used as  parameter in BorderPane
	public HBox setHbox() {
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setAlignment(Pos.CENTER);
		hbox.getStyleClass().add("hbox");
		return hbox;
	}
	
	//create borderPane using parameters for each panel. Every page is a BorderPane layout.
	public BorderPane setBorderPane(VBox right, GridPane center, VBox left, GridPane top) {
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(10,10,10,10));
		
		//CENTER
		GridPane centerMenu = new GridPane();
		centerMenu.setPadding(new Insets(10,10,10,10));
		centerMenu.getChildren().addAll(center);
		centerMenu.setAlignment(Pos.TOP_LEFT);
		centerMenu.getStyleClass().add("gridpane");
		ScrollPane sc = new ScrollPane();
		sc.setContent(centerMenu);
		sc.setContent(centerMenu);
		
		//LEFT
		VBox leftMenu = new VBox(10);
		leftMenu.setPrefWidth(100);
		leftMenu.setAlignment(Pos.BOTTOM_LEFT);
		leftMenu.getStyleClass().add("vbox");
		leftMenu.getChildren().addAll(left);
		
		//RIGHT
		VBox rightMenu = new VBox(10);
		rightMenu.getChildren().addAll(right);
		rightMenu.setAlignment(Pos.BOTTOM_RIGHT);
		rightMenu.setPrefWidth(100);
		rightMenu.getStyleClass().add("vbox");
		
		//TOP
		GridPane topMenu = new GridPane();
		topMenu.setPadding(new Insets(10,10,10,10));
		topMenu.setAlignment(Pos.CENTER_LEFT);
		//Get image and place into leftMenu at the bottom
		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream("LOGO.svg.png");
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		} 
		Image image = new Image(inputstream); 
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(100); 
		imageView.setPreserveRatio(true);
		topMenu.getChildren().add(imageView);
		GridPane.setConstraints(imageView, 0, 0);
		topMenu.getChildren().add(top);
		topMenu.setPrefHeight(100);
		topMenu.getStyleClass().add("hbox");
		
		//ADD TO BORDERPANE
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);
		borderPane.setRight(rightMenu);
		borderPane.setCenter(sc);
		return borderPane;
	}
}

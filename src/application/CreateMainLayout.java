package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreateMainLayout {

	public GridPane setGrid() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		return grid;
	}
	
	public VBox setVbox() {
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(20,10,10,10));
		vbox.setAlignment(Pos.CENTER);
		return vbox;
	}
	
	public HBox setHbox() {
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(20,10,10,10));
		hbox.setAlignment(Pos.CENTER);
		hbox.getStyleClass().add("hbox");
		return hbox;
	}
	
	public BorderPane setBorderPane(VBox right, GridPane center, VBox left, HBox bottom, HBox top) {
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(10,10,10,10));
		
		//center
		GridPane centerMenu = new GridPane();
		centerMenu.getChildren().addAll(center);
		centerMenu.getStyleClass().add("gridpane");
		
		//left
		VBox leftMenu = new VBox();
		
		/*
		 * Get image and place into leftMenu at the bottom
		 */
		FileInputStream inputstream = null;
			try {
				inputstream = new FileInputStream("penn3.png");
			} catch (FileNotFoundException e) {
				System.out.println("Error");
				e.printStackTrace();
			} 
				
			Image image = new Image(inputstream); 
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(100); 
			imageView.setPreserveRatio(true);
		
		left.getChildren().add(imageView);
		leftMenu.setPrefWidth(100);
		leftMenu.getStyleClass().add("vbox");
		leftMenu.setAlignment(Pos.BOTTOM_LEFT);
		leftMenu.getChildren().addAll(left);
		
		//top
		HBox topMenu = new HBox();
		topMenu.setPadding(new Insets(10,10,10,10));
		topMenu.setAlignment(Pos.CENTER_LEFT);
		topMenu.getChildren().add(top);
		topMenu.setPrefHeight(100);
		topMenu.getStyleClass().add("hbox");
		
		//right
		VBox rightMenu = new VBox();
		rightMenu.getChildren().addAll(right);
		rightMenu.setAlignment(Pos.BOTTOM_RIGHT);
		rightMenu.setPrefWidth(150);
		rightMenu.getStyleClass().add("vbox");
		
		//bottom
		HBox bottomMenu = new HBox();
		bottomMenu.getChildren().add(bottom);
		bottomMenu.setPrefHeight(100);
		bottomMenu.setAlignment(Pos.BOTTOM_LEFT);
		bottomMenu.getStyleClass().add("hbox");
		
		//add to borderPane
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);
		borderPane.setRight(rightMenu);
		borderPane.setCenter(centerMenu);
		//borderPane.setBottom(bottomMenu);
		return borderPane;
	}
}

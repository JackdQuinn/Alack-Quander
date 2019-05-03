package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreateMainLayout {

	String GridStyle = "Style.css";
	String VBoxStyle = "Style.css";
	String HBoxStyle = "Style.css";
	
	public GridPane setGrid() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20,20,20,20));
		grid.setVgap(8);
		grid.setHgap(10);
		grid.getStylesheets().add(GridStyle);
		return grid;
	}
	
	public VBox setVbox() {
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(20,20,20,20));
		vbox.setAlignment(Pos.CENTER);
		vbox.getStylesheets().add(VBoxStyle);
		return vbox;
	}
	
	public HBox setHbox() {
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(20,20,20,20));
		hbox.setAlignment(Pos.CENTER);
		hbox.getStylesheets().add(HBoxStyle);
		return hbox;
	}
	
	public BorderPane setBorderPane(String title, VBox v, GridPane g) {
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(10,10,10,10));

		//center
		GridPane centerMenu = new GridPane();
		centerMenu.getChildren().add(g);
		centerMenu.getStylesheets().add(GridStyle);
		
		//left
		VBox leftMenu = new VBox();

		FileInputStream inputstream = null;
			try {
				inputstream = new FileInputStream("penn3.png");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
				
		Image image = new Image(inputstream); 
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(150); 
		imageView.setPreserveRatio(true);
	    leftMenu.getChildren().add(imageView);
		leftMenu.setAlignment(Pos.BOTTOM_LEFT);
		leftMenu.getStylesheets().add(VBoxStyle);
		
		//top
		HBox topMenu = new HBox();
		Label t = new Label(title);
		t.setWrapText(true);
		topMenu.setAlignment(Pos.TOP_LEFT);
		topMenu.getChildren().addAll(t);
		topMenu.getStyleClass().add("menuPane");
		topMenu.getStylesheets().add(HBoxStyle);
		
		//right
		VBox rightMenu = new VBox();
		rightMenu.getChildren().add(v);
		rightMenu.setAlignment(Pos.BOTTOM_RIGHT);
		rightMenu.getStylesheets().add(VBoxStyle);
		
		//add to borderPane
		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);
		borderPane.setRight(rightMenu);
		borderPane.setCenter(centerMenu);
		return borderPane;
	}
}

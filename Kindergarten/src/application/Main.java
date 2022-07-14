package application;
	
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
			Scene scene = new Scene(root,Color.ANTIQUEWHITE);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Image icon = new Image("sun.png");
			stage.getIcons().add(icon);
			stage.setTitle("Kindergarten");
			stage.setFullScreen(false);
			stage.setWidth(700);
			stage.setHeight(500);
			
			Text text = new Text();
			text.setText("Hoþgeldiniz");
			text.setX(10);
			text.setY(10);
			text.setFont(Font.font("Verdana",50));
			text.setFill(Color.BROWN);
			
			
			
			
			stage.setScene(scene);
		    stage.setResizable(false);
			stage.show();
			
			


		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
		
		
		
	}
}

package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class addNoteController implements Initializable {
	
	@FXML
	private TextField studentidTextField;
	@FXML
	private ChoiceBox<String> lehrfachChoiceBox;
	
	private String[] classes = {"Sport","Math","Drama","Musik","Zeichnen"} ;
	@FXML
	private ChoiceBox<String> noteChoiceBox;
	
	private String[] noten = {"1","2","3","4","5"} ;
	@FXML
	private TextField passwordTextField;
	@FXML
	private Button saveUserButton;
	
	private Scene scene;
	private Parent root;
	String role;

	

	
	public void addNoteButtonOnAction(ActionEvent e) {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		String addNoteQuery = "";
		
		if(lehrfachChoiceBox.getSelectionModel().getSelectedItem()== "Sport") {
			addNoteQuery = "UPDATE `noten`SET sport= '"+noteChoiceBox.getSelectionModel().getSelectedItem()+"' WHERE studentID="+studentidTextField.getText();
			
		}
		else if(lehrfachChoiceBox.getSelectionModel().getSelectedItem()== "Math") {
			addNoteQuery = "UPDATE `noten`SET math= '"+noteChoiceBox.getSelectionModel().getSelectedItem()+"' WHERE studentID="+studentidTextField.getText();
			
		}
		else if(lehrfachChoiceBox.getSelectionModel().getSelectedItem()== "Drama") {
			addNoteQuery = "UPDATE `noten`SET drama= '"+noteChoiceBox.getSelectionModel().getSelectedItem()+"' WHERE studentID="+studentidTextField.getText();
		}
		else if(lehrfachChoiceBox.getSelectionModel().getSelectedItem()== "Musik") {
			addNoteQuery = "UPDATE `noten`SET musik= '"+noteChoiceBox.getSelectionModel().getSelectedItem()+"' WHERE studentID="+studentidTextField.getText();
		}
		else {
			addNoteQuery = "UPDATE `noten`SET zeichnen= '"+noteChoiceBox.getSelectionModel().getSelectedItem()+"' WHERE studentID="+studentidTextField.getText();
		}
		System.out.println(addNoteQuery);
		try {
		Statement statement = connectDB.createStatement();
		//ResultSet queryResult = statement.executeQuery(addStudentQuery);
		statement.executeUpdate(addNoteQuery);
		
		}
		catch(Exception exception) {
			System.out.println("not ok");
		}
	}
	
	public void cancelButtonOnAction(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(role +"-Main.fxml"));
		root=loader.load();
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(1100);
		stage.setHeight(720);
		stage.setX(130);
		stage.setY(20);
		stage.setScene(scene);
		
		
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		lehrfachChoiceBox.getItems().addAll(classes);
		lehrfachChoiceBox.setValue("Sport");
		noteChoiceBox.getItems().addAll(noten);
		noteChoiceBox.setValue("5");
	}
	public void setRole(String role){
		this.role = role;
	}

}
package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class deleteStudentController {
	@FXML
	private TextField nameTextField;
	@FXML
	private TextField ageTextField;
	@FXML
	private TextField classTextField;
	@FXML
	private TextField idTextField;
	@FXML
	private Button deleteStudentButton;
	@FXML
	private Button cancelButton;
	int number = 1;
	private Scene scene;
	private Parent root;
	String role;
	

	
	public void deleteStudentButtonOnAction(ActionEvent e) {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		String deleteStudentQuery = "DELETE FROM `students` WHERE studentID='"+idTextField.getText()+"'AND name='"+nameTextField.getText()+"'AND age='"+ageTextField.getText()+"' AND class ='"+classTextField.getText()+"'";
		try {
		Statement statement = connectDB.createStatement();
		//ResultSet queryResult = statement.executeQuery(addStudentQuery);
		statement.executeUpdate(deleteStudentQuery);
		}
		catch(Exception exception) {
			System.out.println("not ok");
		}
	}
	public void cancelButtonOnAction(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(role+"-Main.fxml"));
		root=loader.load();
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(1100);
		stage.setHeight(737);
		stage.setX(130);
		stage.setY(20);
		stage.setScene(scene);
		
		
		stage.show();
	}
	public void setRole(String role){
		this.role = role;
	}
}

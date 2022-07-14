package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class deleteUserController implements Initializable {
	@FXML
	private TextField nameTextField;
	@FXML
	private TextField userIDTextField;
	@FXML
	private ChoiceBox<String> roleChoiceBox;
	
	private String[] roles = {"Lehrer","Admin"} ;
	@FXML
	private Button deleteUserButton;
	@FXML
	private Button cancelButton;
	int number = 1;
	private Scene scene;
	private Parent root;
	String role;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		roleChoiceBox.getItems().addAll(role);
		roleChoiceBox.setValue("Lehrer");
	}

	

	
	public void deleteUserButtonOnAction(ActionEvent e) {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		String deleteUserQuery = "DELETE FROM `users` WHERE user_ID='"+userIDTextField.getText()+"'AND name='"+nameTextField.getText()+"'AND role='"+roleChoiceBox.getSelectionModel().getSelectedItem()+"'";
		try {
		Statement statement = connectDB.createStatement();
		//ResultSet queryResult = statement.executeQuery(addStudentQuery);
		statement.executeUpdate(deleteUserQuery);
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

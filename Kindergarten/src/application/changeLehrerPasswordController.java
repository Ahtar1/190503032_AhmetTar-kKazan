package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

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

public class changeLehrerPasswordController implements Initializable {
	

	@FXML
	private TextField passwordNow;
	@FXML
	private TextField newPassword;
	
	@FXML
	private ChoiceBox<String> roleChoiceBox;
	
	private String[] roles = {"Lehrer","Admin"} ;
	@FXML
	private Button changePasswordButton;

	private Scene scene;
	private Parent root;

	String changePasswordQuery;
	String role;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		roleChoiceBox.getItems().addAll(roles);
		roleChoiceBox.setValue("Lehrer");
	}
	
	public void changePasswordButtonOnAction(ActionEvent e) {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		//if(passwordNow=)
		//changePasswordQuery = "UPDATE users SET password ='" +newPassword.getText()+ "' WHERE user_ID ='"+idTextField.getText()+"' AND role = '"+ roleChoiceBox.getSelectionModel().getSelectedItem()+"'";
		
		
		try {
		Statement statement = connectDB.createStatement();
		//ResultSet queryResult = statement.executeQuery(addStudentQuery);
		statement.executeUpdate(changePasswordQuery);
		}
		catch(Exception exception) {
			System.out.println("not ok");
		}
	}
	public void cancelButtonOnAction(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(role+ "-Main.fxml"));
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
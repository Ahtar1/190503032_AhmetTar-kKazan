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

public class addUserController implements Initializable {
	
	@FXML
	private TextField nameTextField;
	@FXML
	private ChoiceBox<String> roleChoiceBox;
	
	private String[] roles = {"Lehrer","Admin"} ;
	@FXML
	private TextField passwordTextField;
	@FXML
	private Button saveUserButton;
	
	private Scene scene;
	private Parent root;
	String role;
	

	
	public void addUserButtonOnAction(ActionEvent e) {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		String addStudentQuery = "INSERT INTO `users`(`user_ID`, `name`, `role`, `password`) VALUES ('"+connectNow.getUserID()+"','"+nameTextField.getText()+"','"+roleChoiceBox.getSelectionModel().getSelectedItem()+"','"+passwordTextField.getText()+"')";
		try {
		Statement statement = connectDB.createStatement();
		//ResultSet queryResult = statement.executeQuery(addStudentQuery);
		statement.executeUpdate(addStudentQuery);
		
		}
		catch(Exception exception) {
			System.out.println("not ok");
		}
	}
	
	public void cancelButtonOnAction(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(role +"-Main.fxml"));
		root=loader.load();
		AdminController admin = loader.getController();
		admin.handleCancel("Kontos");
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
		roleChoiceBox.getItems().addAll(roles);
		roleChoiceBox.setValue("Lehrer");
	}
	public void setRole(String role){
		this.role = role;
	}
}
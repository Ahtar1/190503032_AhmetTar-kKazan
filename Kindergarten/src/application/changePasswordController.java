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

public class changePasswordController implements Initializable {
	
	@FXML
	private TextField idTextField;
	@FXML
	private TextField nameTextField;
	@FXML
	private TextField newPassword;
	
	@FXML
	private ChoiceBox<String> roleChoiceBox;
	
	private String[] roles = {"Lehrer","Admin"} ;
	@FXML
	private Button changePasswordButton;

	private Scene scene;
	private Parent root;
	@FXML
	private Label label;

	String changePasswordQuery;
	String role;
	String password;
	String username;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		roleChoiceBox.getItems().addAll(roles);
		roleChoiceBox.setValue("Lehrer");
	}
	
	public int changePasswordButtonOnAction(ActionEvent e) {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		if(role=="Lehrer" && roleChoiceBox.getSelectionModel().getSelectedItem()== "Admin") {
			label.setText("Sie sind Lehrer!!");
			return 0;
		}
		if(connectNow.validateLogin(username, password, role)== false) {
			label.setText("False Password");
			return 0;
		}
		
		changePasswordQuery = "UPDATE users SET password ='" +newPassword.getText()+ "' WHERE user_ID ='"+idTextField.getText()+"' AND role = '"+ roleChoiceBox.getSelectionModel().getSelectedItem()+"'";
		
		
		try {
		Statement statement = connectDB.createStatement();
		//ResultSet queryResult = statement.executeQuery(addStudentQuery);
		statement.executeUpdate(changePasswordQuery);
		}
		catch(Exception exception) {
			System.out.println("not ok");
		}
		return 0;
	}
	public void cancelButtonOnAction(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(role+"-Main.fxml"));
		root=loader.load();
		if(role == "Admin") {
			AdminController lehrerController = loader.getController();
			lehrerController.handleCancel("Kontos");
		}
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
	public void setPassword(String password){
		this.password = password;
	}
	public void setusername(String username){
		this.username = username;
	}
	

}
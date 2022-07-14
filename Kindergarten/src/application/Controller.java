package application;

import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller implements Initializable{

	
	@FXML
	private Label loginMessageLabel;
	@FXML
	private TextField usernameTextField;
	
	public String getUsername() {
		return usernameTextField.getText();
	}

	public void setUsername(String username) {
		usernameTextField.setText(username);
	}
	
	@FXML
	private PasswordField passwordPasswordField;
	@FXML
	private ChoiceBox<String> rolesChoiceBox;
	
	private String[] roles = {"Lehrer","Admin"} ;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		rolesChoiceBox.getItems().addAll(roles);
		rolesChoiceBox.setValue("Lehrer");
		
	}
	
	public void switchToMain(ActionEvent event) throws IOException {
		String fxmlPage = rolesChoiceBox.getSelectionModel().getSelectedItem() + "-Main.fxml" ;
		//String username = usernameTextField.getText();
		//String role = rolesChoiceBox.getSelectionModel().getSelectedItem();
		//FXMLLoader.load(getClass().getResource(fxmlPage));
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPage));
		root=loader.load();
		if(rolesChoiceBox.getSelectionModel().getSelectedItem() == "Admin") {
			AdminController adminController = loader.getController();
			
			adminController.setPassword(passwordPasswordField.getText());
			adminController.setUserName(usernameTextField.getText());
			
		}
		else {
			LehrerController lehrerController = loader.getController();
			lehrerController.setPassword(passwordPasswordField.getText());
			lehrerController.setUserName(usernameTextField.getText());
		}
		
		
		//Parent root = FXMLLoader.load(getClass().getResource(fxmlPage));
		
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(1100);
		stage.setHeight(737);
		stage.setX(130);
		stage.setY(20);
		stage.setScene(scene);
		
		
		stage.show();
	}
	
	public void loginButtonOnAction(ActionEvent e) throws IOException {
		
		if(usernameTextField.getText().isBlank()==false && passwordPasswordField.getText().isBlank()==false) {
			if(validateLogin()) {
				switchToMain(e);
			}
			else {
				
			}
		}
		else {
			loginMessageLabel.setText("Please enter username and password");
		}
	}
	public boolean validateLogin() {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		String verifyLogin = "SELECT count(1) FROM users WHERE name = '" + usernameTextField.getText() +"' AND password = '" + passwordPasswordField.getText() + "' AND  role ='" + rolesChoiceBox.getSelectionModel().getSelectedItem() + "'" ;		
		System.out.println(verifyLogin);
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin);
			loginMessageLabel.setText("Olmadi be");
			while(queryResult.next()) {
				if(queryResult.getInt(1) ==1) {
					loginMessageLabel.setText("Welcome");
					return true;
					
					
				} else {
					loginMessageLabel.setText("Invalid Login");
					return false;
				}
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
}

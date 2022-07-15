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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class addStudentController {
	
	@FXML
	private TextField nameTextField;
	@FXML
	private TextField ageTextField;
	@FXML
	private TextField classTextField;
	
	@FXML
	private TextField elternNameTextField;
	@FXML
	private TextField elternNoTextField;
	private Button saveStudentButton;
	
    private int number;
	private Scene scene;
	private Parent root;
	String role;

	

	
	public void saveStudentButtonOnAction(ActionEvent e) {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		int id =connectNow.getStudentID();
		
		String addStudentQuery = "INSERT INTO `students`(`studentID`, `name`, `age`, `class`) VALUES ('"+id+"','"+nameTextField.getText()+"','"+ageTextField.getText()+"','"+classTextField.getText()+"')";
		String addtoNoten = "INSERT INTO `noten`(`studentID`) VALUES ('"+id+"')";
		String addToEltern = "INSERT INTO `eltern`(`studentID`, `ElternName`, `ElternNo`) VALUES ('"+id+"','"+elternNameTextField.getText()+"','"+elternNoTextField.getText()+"')";
		String addToanwesenheit = "INSERT INTO `anwesenheit`(`studentid`, `Tagzahl`) VALUES ('"+id+"','0')";
		String addToZahlung = "INSERT INTO `zahlung`(`studentid`, `gezahltBetrag`, `ungezahltBetrag`) VALUES ('"+id+"','"+"0"+"','"+"3000"+"')";
		
		try {
		Statement statement = connectDB.createStatement();
		//ResultSet queryResult = statement.executeQuery(addStudentQuery);
		statement.executeUpdate(addStudentQuery);
		statement.executeUpdate(addtoNoten);
		statement.executeUpdate(addToEltern);
		statement.executeUpdate(addToanwesenheit);
		statement.executeUpdate(addToZahlung);
		
		}
		catch(Exception exception) {
			System.out.println("not ok");
		}
	}
	public void cancelButtonOnAction(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(role +"-Main.fxml"));
		root=loader.load();
		if(role=="Admin") {
			AdminController lehrerController = loader.getController();
			lehrerController.handleCancel("Klassen");
		}
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(1100);
		stage.setHeight(720);
		stage.setX(130);
		stage.setY(20);
		stage.setScene(scene);
		
		
		stage.show();
	}
	public void setRole(String role){
		this.role = role;
	}
}

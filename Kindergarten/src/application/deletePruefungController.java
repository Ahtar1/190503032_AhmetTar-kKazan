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

public class deletePruefungController implements Initializable {
	
	@FXML
	private DatePicker datePicker;
	@FXML
	private ChoiceBox<String> lehrfachChoiceBox;
	
	private String[] lehrfachen = {"Sport","Math","Drama","Musik","Zeichnen"} ;
	@FXML
	private TextField classTextField;
	@FXML
	private Button deletePruefungButton;
	@FXML
	private Button cancelButton;

	
	private Scene scene;
	private Parent root;
	String role;
	

	
	public void deletePruefungButtonOnAction(ActionEvent e) {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		String addStudentQuery = "DELETE FROM `exams` WHERE subject='"+lehrfachChoiceBox.getSelectionModel().getSelectedItem()+"' AND class='"+classTextField.getText()+"' AND date='"+datePicker.getValue().toString()+"'";
		System.out.println(addStudentQuery);

		try {
		Statement statement = connectDB.createStatement();
		//ResultSet queryResult = statement.executeQuery(addStudentQuery);
		statement.executeUpdate(addStudentQuery);
		System.out.println(addStudentQuery);
		
		}
		catch(Exception exception) {
			System.out.println("not ok");
		}
	}
	
	public void cancelButtonOnAction(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin-Main.fxml"));
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
		lehrfachChoiceBox.getItems().addAll(lehrfachen);
		lehrfachChoiceBox.setValue("Sport");
	}
	public void setRole(String role){
		this.role = role;
	}
}
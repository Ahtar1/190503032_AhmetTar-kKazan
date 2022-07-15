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

public class changeLehrplanController implements Initializable {
	

	@FXML
	private TextField inputTextField;

	
	@FXML
	private ChoiceBox<String> monatBox;
	@FXML
	private ChoiceBox<String> wocheBox;
	
	private String[] monaten = {"September","Oktober","November","Dezembar","Januar","Februar","Marz","April","Mai","Juni"} ;
	private String[] wochen = {"Woche 1","Woche 2","Woche 3","Woche 4"} ;
	
	@FXML
	private Button changeLehrplanButton;

	private Scene scene;
	private Parent root;
	String role;

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		monatBox.getItems().addAll(monaten);
		monatBox.setValue("September");
		wocheBox.getItems().addAll(wochen);
		wocheBox.setValue("Woche 1");
		
	}
	
	public void changeLehrplanButtonOnAction(ActionEvent e) {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		String monat = monatBox.getSelectionModel().getSelectedItem();
		String woche = wocheBox.getSelectionModel().getSelectedItem();
		String newValue = inputTextField.getText();
		
		String changeLehrplanQuery = "UPDATE lehrplan SET "+monat +"='"+ newValue + "' WHERE Wochen ='" + woche+"'";
		
		try {
		Statement statement = connectDB.createStatement();
		//ResultSet queryResult = statement.executeQuery(addStudentQuery);
		System.out.println(changeLehrplanQuery);		
		statement.executeUpdate(changeLehrplanQuery);
		}
		catch(Exception exception) {
			System.out.println("not ok");
		}
	}
	public void cancelButtonOnAction(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(role+"-Main.fxml"));
		root=loader.load();
		LehrerController lehrerController = loader.getController();
		lehrerController.handleCancel("Lehrplan");
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

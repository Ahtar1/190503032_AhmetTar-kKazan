package application;

import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class AdminController implements Initializable{
	
	@FXML
	private Label lblStatus;
	@FXML
	private Label role;
	@FXML
	private Button btnClose;
	@FXML
	private Button btnKontos;
	@FXML
	private Button btnKlassen;
	@FXML
	private Button btnFristen;
	@FXML
	private Button btnEltern;
	@FXML
	private Button btnPruefungen;
	@FXML
	private Button btnZahlungen;
	@FXML
	private GridPane pnKontos;
	@FXML
	private GridPane pnKlassen;
	@FXML
	private GridPane pnPruefungen;
	@FXML
	private GridPane pnZahlungen;
	@FXML
	private GridPane pnEltern;
	private Scene scene;
	private Parent root;
	@FXML
	private DatePicker fristDatePicker;
	@FXML
	private Button fristButton;
	
	//Student
	@FXML
	private Button btnAddStudent;
	@FXML
	private Button btnDeleteStudent;
	@FXML
	private Button btnChangeStudent;
	
	@FXML
	private Button btnChangeLehrplan;
	
	// GridPane Students
	
	@FXML
	private TableView<UserSearchModel> userTableView;
	@FXML
	private TableColumn<UserSearchModel,String> user_ID;
	@FXML
	private TableColumn<UserSearchModel,String> roles;
	@FXML
	private TableColumn<UserSearchModel,String> name;

	@FXML
	private TextField searchTextField;
	
	@FXML 
	private TableView<LehrplanSearchModel> lehrplanTableView;
	@FXML
	private TableColumn<LehrplanSearchModel,String> wochen;
	@FXML
	private TableColumn<LehrplanSearchModel,String> september;
	@FXML
	private TableColumn<LehrplanSearchModel,String>oktober;
	@FXML
	private TableColumn<LehrplanSearchModel,String> november;
	@FXML
	private TableColumn<LehrplanSearchModel,String> dezember;
	@FXML
	private TableColumn<LehrplanSearchModel,String> januar;
	@FXML
	private TableColumn<LehrplanSearchModel,String> februar;
	@FXML
	private TableColumn<LehrplanSearchModel,String> marz;
	@FXML
	private TableColumn<LehrplanSearchModel,String> april;
	@FXML
	private TableColumn<LehrplanSearchModel,String> mai;
	@FXML
	private TableColumn<LehrplanSearchModel,String> juni;
	@FXML
	private TableView<StudentSearchModel> studentTableView;
	@FXML
	private TableColumn<StudentSearchModel,String> classColumn;
	@FXML
	private TableColumn<StudentSearchModel,Integer> idColumn;
	@FXML
	private TableColumn<StudentSearchModel,String> nameColumn;
	@FXML
	private TableColumn<StudentSearchModel,Integer> ageColumn;
	@FXML
	private TableView<PruefungSearchModel> pruefungTableView;
	@FXML
	private TableColumn<PruefungSearchModel,String> classNoColumn;
	@FXML
	private TableColumn<PruefungSearchModel,String> lehrfachColumn;
	@FXML
	private TableColumn<PruefungSearchModel,String> dateColumn;
	@FXML
	private TableView<ElternSearchModel> elternTableView;
	@FXML
	private TableColumn<ElternSearchModel,String> elternNameColumn;
	@FXML
	private TableColumn<ElternSearchModel,String> elternNoColumn;
	@FXML
	private TableColumn<ElternSearchModel,String> studentIDColumn;
	
	//Zahlungen
	
	@FXML
	private TableView<ZahlungSearchModel> zahlungTableView;
	@FXML
	private TableColumn<ZahlungSearchModel,String> elternNameZahlungColumn;
	@FXML
	private TableColumn<ZahlungSearchModel,String> studentidColumn;
	@FXML
	private TableColumn<ZahlungSearchModel,String> gezahltBetragColumn;
	@FXML
	private TableColumn<ZahlungSearchModel,String> ungezahltBetragColumn;
	@FXML
	private Button addZahlungButton;
	@FXML
	private TextField betragTextField;
	@FXML
	private TextField studentidTextField;
	@FXML
	private ToolBar toolbar;
	
	@FXML
	private TextField studentidTelTextField;
	@FXML
	private TextField telNoTextField;
	@FXML
	private Button telNoButton;
	

	String password;
	String username;
	
	
	ObservableList<StudentSearchModel> studentSearchModelObservableList = FXCollections.observableArrayList();
	ObservableList<LehrplanSearchModel> lehrplanSearchModelObservableList = FXCollections.observableArrayList();
	ObservableList<UserSearchModel> userSearchModelObservableList = FXCollections.observableArrayList();
	ObservableList<PruefungSearchModel> pruefungSearchModelObservableList = FXCollections.observableArrayList();
	ObservableList<ElternSearchModel> elternSearchModelObservableList = FXCollections.observableArrayList();
	ObservableList<ZahlungSearchModel> zahlungSearchModelObservableList = FXCollections.observableArrayList();

	//private Stage stage;
	//private Scene scene;
	//private Parent root;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		pnKontos.toFront();
		lblStatus.setText("Kontos");

		DatabaseConnection connectNow = new DatabaseConnection();
		
		connectNow.displayUsers(userSearchModelObservableList, user_ID, name, roles,userTableView);
		connectNow.displayStudents(studentSearchModelObservableList, classColumn, idColumn, nameColumn, ageColumn,studentTableView);
		connectNow.displayPruefung(pruefungSearchModelObservableList, classNoColumn, lehrfachColumn, dateColumn, pruefungTableView);
		connectNow.displayEltern(elternSearchModelObservableList, studentIDColumn, elternNameColumn, elternNoColumn, elternTableView);
		connectNow.displayZahlung(zahlungSearchModelObservableList, studentidColumn, elternNameZahlungColumn, gezahltBetragColumn, ungezahltBetragColumn, zahlungTableView);
		
FilteredList<StudentSearchModel> filteredData = new FilteredList<>(studentSearchModelObservableList,b -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) ->{
			filteredData.setPredicate(studentSearchModel  -> {
				if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
					return true;
				}
				String searchKeyword = newValue.toLowerCase();
				int StudentID =studentSearchModel.getStudentID();
				String stringStudentID = Integer.toString(StudentID);
				int age =studentSearchModel.getAge();
				String stringAge = Integer.toString(age);
				if(stringStudentID.indexOf(searchKeyword)>-1) {
					return true;
				}
				else if(studentSearchModel.getClassNo().toLowerCase().indexOf(searchKeyword)>-1) {
					return true;
				}
				else if(studentSearchModel.getName().toLowerCase().indexOf(searchKeyword)>-1) {
					return true;
				}
				else if(stringAge.indexOf(searchKeyword)>-1) {
					return true;
				}
				
				else return false;
			});
		});
		
		SortedList<StudentSearchModel> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(studentTableView.comparatorProperty());
		
		studentTableView.setItems(sortedData);
	}
	
	
	
	
	@FXML
	public void handleClicks(ActionEvent event) {
		if(event.getSource() == btnKontos) {
			lblStatus.setText("Kontos");
			pnKontos.toFront();
		}
		if(event.getSource() == btnKlassen) {
			lblStatus.setText("Klassen");
			pnKlassen.toFront();
		}
		
		if(event.getSource() == btnEltern) {
			lblStatus.setText("Eltern");
			pnEltern.toFront();
		}
		if(event.getSource() == btnPruefungen) {
			lblStatus.setText("Prüfungen");
			pnPruefungen.toFront();
		}
		if(event.getSource() == btnZahlungen) {
			lblStatus.setText("Zahlungen");
			pnZahlungen.toFront();
		}
	}
	@FXML
	public void changePassword(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("changePassword.fxml"));
		root=loader.load();
		changePasswordController controller = loader.getController();
		controller.setRole("Admin");
		controller.setPassword(password);
		controller.setusername(username);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(700);
		stage.setHeight(500);
		stage.setScene(scene);
		stage.setX(400);
		stage.setY(200);
	}
	public void changeUserInfo(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("changeUserInfo.fxml"));
		root=loader.load();
		changeUserInfoController controller = loader.getController();
		controller.setRole("Admin");
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(700);
		stage.setHeight(500);
		stage.setScene(scene);
		stage.setX(400);
		stage.setY(200);
	}
	public void addUser(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("addUser.fxml"));
		root=loader.load();
		addUserController controller = loader.getController();
		controller.setRole("Admin");
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(700);
		stage.setHeight(500);
		stage.setScene(scene);
		stage.setX(400);
		stage.setY(200);
	}
	public void deleteUser(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteUser.fxml"));
		root=loader.load();
		deleteUserController controller = loader.getController();
		controller.setRole("Admin");
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(700);
		stage.setHeight(500);
		stage.setScene(scene);
		stage.setX(400);
		stage.setY(200);
	}
	public void addStudent(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("addStudent.fxml"));
		root=loader.load();
		addStudentController controller = loader.getController();
		controller.setRole("Admin");
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(700);
		stage.setHeight(500);
		stage.setScene(scene);
		stage.setX(400);
		stage.setY(200);
	}
	public void deleteStudent(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteStudent.fxml"));
		root=loader.load();
		deleteStudentController controller = loader.getController();
		controller.setRole("Admin");
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(700);
		stage.setHeight(500);
		stage.setScene(scene);
		stage.setX(400);
		stage.setY(200);
	}
	public void changeStudent(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("changeStudentInfo.fxml"));
		root=loader.load();
		changeStudentInfoController controller = loader.getController();
		controller.setRole("Admin");
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(700);
		stage.setHeight(500);
		stage.setScene(scene);
		stage.setX(400);
		stage.setY(200);
	}
	public void deletePruefung(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("deletePruefung.fxml"));
		root=loader.load();

		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(700);
		stage.setHeight(500);
		stage.setScene(scene);
		stage.setX(400);
		stage.setY(200);
	}
	public void addPruefung(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("addPruefung.fxml"));
		root=loader.load();
		addPruefungController controller = loader.getController();
		controller.setRole("Admin");
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(700);
		stage.setHeight(500);
		stage.setScene(scene);
		stage.setX(400);
		stage.setY(200);
	}
	public void determineFrist(ActionEvent event) throws IOException {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		String fristQuery = "UPDATE frist SET Frist='"+fristDatePicker.getValue()+"'";
		try {
			Statement statement = connectDB.createStatement();
			statement.executeUpdate(fristQuery);
			

			
		} catch(SQLException e) {
			Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
	}
	
	public int addZahlung(ActionEvent event) throws IOException {
		 DatabaseConnection connectNow = new DatabaseConnection();
		 Connection connectDB = connectNow.getConnection();
		 int ungezahltbetrag=3000;
		 int gezahltbetrag=0;
		 String ungezahltQuery = "SELECT ungezahltBetrag FROM zahlung WHERE studentid ='"+studentidTextField.getText()+"'";
		 String gezahltQuery = "SELECT gezahltBetrag FROM zahlung WHERE studentid ='"+studentidTextField.getText()+"'";
		 int newgezahltbetrag=0;
		 try {
				Statement statement = connectDB.createStatement();
				ResultSet queryOutput =  statement.executeQuery(gezahltQuery);
				
				while(queryOutput.next()) {
					gezahltbetrag=Integer.parseInt(queryOutput.getString("gezahltBetrag"));
				}
			    newgezahltbetrag = gezahltbetrag+Integer.parseInt(betragTextField.getText()) ;  

				
			} catch(SQLException e) {
				Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
				e.printStackTrace();
			}
		 if(gezahltbetrag==3000) {
			 return 0;
		 }
		 try {
				Statement statement = connectDB.createStatement();
				ResultSet queryOutput =  statement.executeQuery(ungezahltQuery);
				
				while(queryOutput.next()) {
					ungezahltbetrag= Integer.parseInt(queryOutput.getString("ungezahltBetrag"));
					System.out.println(ungezahltbetrag);
				}
				System.out.println(ungezahltbetrag);
				
				int newungezahltbetrag = ungezahltbetrag- Integer.parseInt(betragTextField.getText());
				 String increaseNumberQuery = "UPDATE zahlung SET ungezahltBetrag ='" +newungezahltbetrag+"',gezahltBetrag='"+newgezahltbetrag+"' WHERE studentid ='"+ studentidTextField.getText() +"'";
				 try {
						statement = connectDB.createStatement();
						statement.executeUpdate(increaseNumberQuery);

						
					} catch(SQLException e) {
						Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
						e.printStackTrace();
					}
				
			} catch(SQLException e) {
				Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
				e.printStackTrace();
			}
		 return 0;
	}
	
	public void changeTelNo(ActionEvent event) throws IOException {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		String fristQuery = "UPDATE eltern SET ElternNo='"+telNoTextField.getText()+"'WHERE studentID="+studentidTelTextField.getText();
		try {
			Statement statement = connectDB.createStatement();
			statement.executeUpdate(fristQuery);
			

			
		} catch(SQLException e) {
			Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
	}



	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password=password;
	}
	public void setUserName(String username) {
		// TODO Auto-generated method stub
		this.username=username;
	}
	public void handleCancel(String str) {
		if(str == "Kontos") {
			lblStatus.setText("Kontos");
			pnKontos.toFront();
		}
		if(str == "Klassen") {
			lblStatus.setText("Klassen");
			pnKlassen.toFront();
		}
		
		if(str == "Eltern") {
			lblStatus.setText("Eltern");
			pnEltern.toFront();
		}
		if(str == "Prüfungen") {
			lblStatus.setText("Prüfungen");
			pnPruefungen.toFront();
		}
		if(str == "Zahlungen") {
			lblStatus.setText("Zahlungen");
			pnZahlungen.toFront();
		}
	}
}

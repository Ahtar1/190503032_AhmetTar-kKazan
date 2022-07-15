package application;

import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

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

public class LehrerController implements Initializable{
	
	@FXML
	private Label lblStatus;
	@FXML
	private Label role;
	@FXML
	private Button btnClose;
	@FXML
	private Button btnSchueler;
	@FXML
	private Button btnLehrplan;
	@FXML
	private Button btnNoten;
	@FXML
	private Button btnPI;
	@FXML
	private Button btnAnwesenheit;
	@FXML
	private GridPane pnSchueler;
	@FXML
	private GridPane pnLehrplan;
	@FXML
	private GridPane pnNoten;
	@FXML
	private GridPane pnAnwesenheit;
	private Scene scene;
	private Parent root;
	
	String password;
	
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
	private TextField searchTextField;
	
	//Lehrplan
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
	
	//Noten
	@FXML
	private Label fristLabel;

	@FXML
	private TableView<NoteSearchModel> notenTableView;
	@FXML
	private TableColumn<NoteSearchModel,String> studentidColumn;
	@FXML
	private TableColumn<NoteSearchModel,String> sportColumn;
	@FXML
	private TableColumn<NoteSearchModel,String> mathColumn;
	@FXML
	private TableColumn<NoteSearchModel,String> dramaColumn;
	@FXML
	private TableColumn<NoteSearchModel,String> musikColumn;
	@FXML
	private TableColumn<NoteSearchModel,String> zeichnenColumn;
	@FXML
	private TextField notenTextField;
	@FXML
	private Button btnAddNote;
	@FXML
	private Button btnChangePassword;
	
	//Anwesenheit
	@FXML
	private TableView<AnwesenheitSearchModel> anwesenheitTableView;
	@FXML
	private TableColumn<AnwesenheitSearchModel,Integer> studentIDColumn;
	@FXML
	private TableColumn<AnwesenheitSearchModel,String> anwesenheitColumn;
	@FXML
	private TextField studentidTextField;
	@FXML
	private DatePicker datePicker;
	@FXML
	private DatePicker searchDatePicker;	
	@FXML
	private Button btnSaveAnwesenheit;

	String username;
	
	
	
	ObservableList<StudentSearchModel> studentSearchModelObservableList = FXCollections.observableArrayList();
	ObservableList<LehrplanSearchModel> lehrplanSearchModelObservableList = FXCollections.observableArrayList();
	ObservableList<NoteSearchModel> noteSearchModelObservableList = FXCollections.observableArrayList();
	ObservableList<AnwesenheitSearchModel> anwesenheitSearchModelObservableList = FXCollections.observableArrayList();

	//private Stage stage;
	//private Scene scene;
	//private Parent root;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		pnSchueler.toFront();

		DatabaseConnection connectNow = new DatabaseConnection();
		connectNow.displayStudents(studentSearchModelObservableList, classColumn, idColumn, nameColumn, ageColumn,studentTableView);
		connectNow.displayLehrplan(lehrplanSearchModelObservableList,wochen, september, oktober, november, dezember, januar, februar, marz, april, mai, juni, lehrplanTableView);
		connectNow.displayNoten(noteSearchModelObservableList, studentidColumn, sportColumn, mathColumn, dramaColumn,musikColumn,zeichnenColumn,notenTableView);
		connectNow.displayAnwesenheit(anwesenheitSearchModelObservableList, studentIDColumn,anwesenheitColumn, anwesenheitTableView);
		fristLabel.setText(connectNow.getFrist());
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
		if(event.getSource() == btnSchueler) {
			lblStatus.setText("Schüler");
			pnSchueler.toFront();
		}
		if(event.getSource() == btnLehrplan) {
			lblStatus.setText("Lehrplan");
			pnLehrplan.toFront();
		}
		if(event.getSource() == btnNoten) {
			lblStatus.setText("Noten");
			pnNoten.toFront();
		}
		
		if(event.getSource() == btnAnwesenheit) {
			lblStatus.setText("Anwesenheit");
			pnAnwesenheit.toFront();
		}
	}
	@FXML
	public void addStudent(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("addStudent.fxml"));
		root=loader.load();
		addStudentController controller = loader.getController();
		controller.setRole("Lehrer");

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
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		deleteStudentController controller = loader.getController();
		controller.setRole("Lehrer");
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
		controller.setRole("Lehrer");
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(700);
		stage.setHeight(500);
		stage.setScene(scene);
		stage.setX(400);
		stage.setY(200);
	}
	public void changeLehrplan(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("changeLehrplan.fxml"));
		root=loader.load();
		changeLehrplanController controller = loader.getController();
		controller.setRole("Lehrer");
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(700);
		stage.setHeight(500);
		stage.setScene(scene);
		stage.setX(400);
		stage.setY(200);
	}
	public void addNote(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("addNote.fxml"));
		root=loader.load();
		addNoteController controller = loader.getController();
		controller.setRole("Lehrer");
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setWidth(700);
		stage.setHeight(500);
		stage.setScene(scene);
		stage.setX(400);
		stage.setY(200);
	}
	public void changePassword(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("changePassword.fxml"));
		root=loader.load();
		changePasswordController controller = loader.getController();
		controller.setRole("Lehrer");
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
	public void saveAnwesenheit(ActionEvent event) {
		DatabaseConnection connectNow = new DatabaseConnection();
		connectNow.getConnection();
		String id= studentidTextField.getText();
		System.out.println(id);
		connectNow.getTagZahl(id);
		System.out.println("get tagzahl");
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUserName(String username) {
		// TODO Auto-generated method stub
		this.username=username;
	}
	public void handleCancel(String str) {
		if(str == "Schüler") {
			lblStatus.setText("Schüler");
			pnSchueler.toFront();
		}
		if(str == "Lehrplan") {
			lblStatus.setText("Lehrplan");
			pnLehrplan.toFront();
		}
		if(str == "Noten") {
			lblStatus.setText("Noten");
			pnNoten.toFront();
		}
		
		if(str == "Anwesenheit") {
			lblStatus.setText("Anwesenheit");
			pnAnwesenheit.toFront();
		}
	}
}

package application;



import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DatabaseConnection {
	public Connection databaseLink;

	
	public Connection getConnection() {
		String databaseName = "kindergarten";
		String databaseUser = "root";
		String databasePassword = "";
		String url = "jdbc:mysql://localhost:3306/" + databaseName;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
		} catch( Exception e) {
			e.printStackTrace();
		}
		return databaseLink;
	}
	
	 public void displayStudents(ObservableList<StudentSearchModel> obs,TableColumn<StudentSearchModel,String> classColumn,TableColumn<StudentSearchModel,Integer> idColumn,TableColumn<StudentSearchModel,String> nameColumn,TableColumn<StudentSearchModel,Integer> ageColumn,TableView<StudentSearchModel> studentTableView) {
		
		 DatabaseConnection connectNow = new DatabaseConnection();
		 Connection connectDB = connectNow.getConnection();
		 
		 String StudentViewQuery="SELECT class,studentID,name,age FROM students";
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryOutput =  statement.executeQuery(StudentViewQuery);
			
			while( queryOutput.next()) {
				
				String queryClassNo = queryOutput.getString("class");
				int queryid = queryOutput.getInt("studentID");
				String queryName = queryOutput.getString("name");
				int queryAge = queryOutput.getInt("age");
				obs.add(new StudentSearchModel(queryid,queryName,queryAge,queryClassNo));
			}
			classColumn.setCellValueFactory(new PropertyValueFactory<>("classNo"));
			idColumn.setCellValueFactory(new PropertyValueFactory<>("studentID"));
			nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
			ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
			
			studentTableView.setItems(obs);

			
		} catch(SQLException e) {
			Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
		
	}
	 public void displayUsers(ObservableList<UserSearchModel> obs,TableColumn<UserSearchModel,String> user_IDColumn,TableColumn<UserSearchModel,String> name,TableColumn<UserSearchModel,String> roles,TableView<UserSearchModel> userTableView) {
			
		 DatabaseConnection connectNow = new DatabaseConnection();
		 Connection connectDB = connectNow.getConnection();
		 
		 String userViewQuery="SELECT user_ID,name,role FROM users";
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryOutput =  statement.executeQuery(userViewQuery);
			
			while( queryOutput.next()) {
				
				String queryuser_ID = queryOutput.getString("user_ID");
				String queryname = queryOutput.getString("name");
				String queryrole = queryOutput.getString("role");
				obs.add(new UserSearchModel(queryuser_ID,queryname,queryrole));
			}
			user_IDColumn.setCellValueFactory(new PropertyValueFactory<>("user_ID"));
			name.setCellValueFactory(new PropertyValueFactory<>("name"));
			roles.setCellValueFactory(new PropertyValueFactory<>("role"));
			
			userTableView.setItems(obs);

			
		} catch(SQLException e) {
			Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
		
	}
	 
	 
	
	 public void displayLehrplan(ObservableList<LehrplanSearchModel> obs,TableColumn<LehrplanSearchModel, String> wochen,
				TableColumn<LehrplanSearchModel, String> september, TableColumn<LehrplanSearchModel, String> oktober,
				TableColumn<LehrplanSearchModel, String> november, TableColumn<LehrplanSearchModel, String> dezember,
				TableColumn<LehrplanSearchModel, String> januar, TableColumn<LehrplanSearchModel, String> februar,
				TableColumn<LehrplanSearchModel, String> marz, TableColumn<LehrplanSearchModel, String> april,
				TableColumn<LehrplanSearchModel, String> mai, TableColumn<LehrplanSearchModel, String> juni,
				TableView<LehrplanSearchModel> lehrplanTableView) {
		 DatabaseConnection connectNow = new DatabaseConnection();
		 Connection connectDB = connectNow.getConnection();
		 String LehrplanViewQuery="SELECT * FROM lehrplan";
		 //Wochen,September,Oktober,November,Dezember,Januar,Februar,Marz,April
		 try {
				Statement statement = connectDB.createStatement();
				ResultSet queryOutput =  statement.executeQuery(LehrplanViewQuery);
				System.out.println();
				
				while( queryOutput.next()) {
					String querywochen = queryOutput.getString("Wochen");
					String queryseptember = queryOutput.getString("September");
					String queryoktober = queryOutput.getString("Oktober");
					String querynovember = queryOutput.getString("November");
					String querydezember = queryOutput.getString("Dezembar");
					String queryjanuar = queryOutput.getString("Januar");
					String queryfebruar = queryOutput.getString("Februar");
					String querymarz = queryOutput.getString("Marz");
					String queryapril = queryOutput.getString("April");
					String querymai = queryOutput.getString("Mai");
					String queryjuni = queryOutput.getString("Juni");
					
					
					obs.add(new LehrplanSearchModel(querywochen,queryseptember,queryoktober,querynovember,querydezember,queryjanuar,queryfebruar,querymarz,queryapril,querymai,queryjuni));
				}
				wochen.setCellValueFactory(new PropertyValueFactory<>("Wochen"));
				september.setCellValueFactory(new PropertyValueFactory<>("September"));
				oktober.setCellValueFactory(new PropertyValueFactory<>("Oktober"));
				november.setCellValueFactory(new PropertyValueFactory<>("November"));
				dezember.setCellValueFactory(new PropertyValueFactory<>("Dezember"));
				januar.setCellValueFactory(new PropertyValueFactory<>("Januar"));
				februar.setCellValueFactory(new PropertyValueFactory<>("Februar"));
				marz.setCellValueFactory(new PropertyValueFactory<>("Marz"));
				april.setCellValueFactory(new PropertyValueFactory<>("April"));
				mai.setCellValueFactory(new PropertyValueFactory<>("Mai"));
				juni.setCellValueFactory(new PropertyValueFactory<>("Juni"));
				
				lehrplanTableView.setItems(obs);

				
			} catch(SQLException e) {
				Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
				e.printStackTrace();
			}
	 }
	 public void displayNoten(ObservableList<NoteSearchModel> obs,TableColumn<NoteSearchModel,String> studentID,TableColumn<NoteSearchModel,String> sport,TableColumn<NoteSearchModel,String> math,TableColumn<NoteSearchModel,String> drama,TableColumn<NoteSearchModel,String> musik,TableColumn<NoteSearchModel,String> zeichnen,TableView<NoteSearchModel> notenTableView) {
			
		 DatabaseConnection connectNow = new DatabaseConnection();
		 Connection connectDB = connectNow.getConnection();
		 
		 String notenViewQuery="SELECT * FROM noten";
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryOutput =  statement.executeQuery(notenViewQuery);
			
			while( queryOutput.next()) {
				
				String querystudentid = queryOutput.getString("studentID");
				String querysport = queryOutput.getString("sport");
				String querymath = queryOutput.getString("math");
				String querydrama = queryOutput.getString("drama");
				String querymusik = queryOutput.getString("musik");
				String queryzeichnen = queryOutput.getString("zeichnen");
				obs.add(new NoteSearchModel(querystudentid,querysport,querymath,querydrama,querymusik,queryzeichnen));
			}
			studentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
			sport.setCellValueFactory(new PropertyValueFactory<>("sport"));
			math.setCellValueFactory(new PropertyValueFactory<>("math"));
			drama.setCellValueFactory(new PropertyValueFactory<>("drama"));
			musik.setCellValueFactory(new PropertyValueFactory<>("musik"));
			zeichnen.setCellValueFactory(new PropertyValueFactory<>("zeichnen"));
			
			notenTableView.setItems(obs);

			
		} catch(SQLException e) {
			Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
		
	}
	 public void displayAnwesenheit(ObservableList<AnwesenheitSearchModel> obs,TableColumn<AnwesenheitSearchModel,Integer> studentid,TableColumn<AnwesenheitSearchModel,String> anwesenheit,TableView<AnwesenheitSearchModel> anwesenheitTableView) {
			
		 DatabaseConnection connectNow = new DatabaseConnection();
		 Connection connectDB = connectNow.getConnection();
		 
		 String anwesenheitViewQuery="SELECT studentID, TagZahl FROM anwesenheit";
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryOutput =  statement.executeQuery(anwesenheitViewQuery);
			
			while( queryOutput.next()) {
				
				String querystudentid = queryOutput.getString("studentID");
				String queryanw = queryOutput.getString("TagZahl");
				
				obs.add(new AnwesenheitSearchModel(querystudentid,queryanw));
			}
			studentid.setCellValueFactory(new PropertyValueFactory<>("studentid"));
			anwesenheit.setCellValueFactory(new PropertyValueFactory<>("TagZahl"));
			
			anwesenheitTableView.setItems(obs);

			
		} catch(SQLException e) {
			Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
		
	}
	 public void displayPruefung(ObservableList<PruefungSearchModel> obs,TableColumn<PruefungSearchModel,String> classNo,TableColumn<PruefungSearchModel,String> lehrfach,TableColumn<PruefungSearchModel,String> date,TableView<PruefungSearchModel> pruefungTableView) {
			
		 DatabaseConnection connectNow = new DatabaseConnection();
		 Connection connectDB = connectNow.getConnection();
		 
		 String notenViewQuery="SELECT * FROM exams";
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryOutput =  statement.executeQuery(notenViewQuery);
			
			while( queryOutput.next()) {
				
				String queryclass = queryOutput.getString("class");
				String querysubject = queryOutput.getString("subject");
				String querydate = queryOutput.getString("date");
				
				obs.add(new PruefungSearchModel(queryclass,querysubject,querydate));
			}
			classNo.setCellValueFactory(new PropertyValueFactory<>("classNo"));
			lehrfach.setCellValueFactory(new PropertyValueFactory<>("lehrfach"));
			date.setCellValueFactory(new PropertyValueFactory<>("date"));
			
			pruefungTableView.setItems(obs);

			
		} catch(SQLException e) {
			Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
		
	}
	 public void displayEltern(ObservableList<ElternSearchModel> obs,TableColumn<ElternSearchModel,String> studentid,TableColumn<ElternSearchModel,String> elternName,TableColumn<ElternSearchModel,String> elternNo,TableView<ElternSearchModel> elternTableView) {
			
		 DatabaseConnection connectNow = new DatabaseConnection();
		 Connection connectDB = connectNow.getConnection();
		 
		 String notenViewQuery="SELECT * FROM eltern";
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryOutput =  statement.executeQuery(notenViewQuery);
			
			while( queryOutput.next()) {
				
				String queryclass = queryOutput.getString("studentID");
				String querysubject = queryOutput.getString("ElternName");
				String querydate = queryOutput.getString("ElternNo");
				
				obs.add(new ElternSearchModel(queryclass,querysubject,querydate));
			}
			studentid.setCellValueFactory(new PropertyValueFactory<>("studentid"));
			elternName.setCellValueFactory(new PropertyValueFactory<>("elternName"));
			elternNo.setCellValueFactory(new PropertyValueFactory<>("elternNo"));
			
			elternTableView.setItems(obs);

			
		} catch(SQLException e) {
			Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
		
	}
	 public void displayZahlung(ObservableList<ZahlungSearchModel> obs,TableColumn<ZahlungSearchModel,String> studentid,TableColumn<ZahlungSearchModel,String> elternName,TableColumn<ZahlungSearchModel,String> gezahltBetrag,TableColumn<ZahlungSearchModel,String> ungezahltBetrag,TableView<ZahlungSearchModel> zahlungTableView) {
			
		 DatabaseConnection connectNow = new DatabaseConnection();
		 Connection connectDB = connectNow.getConnection();
		 
		 String notenViewQuery="SELECT * FROM zahlung INNER JOIN eltern ON zahlung.studentid = eltern.studentID";
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryOutput =  statement.executeQuery(notenViewQuery);
			
			while( queryOutput.next()) {
				
				String queryid = queryOutput.getString("studentid");
				String queryename = queryOutput.getString("ElternName");
				String querygbetrag = queryOutput.getString("gezahltBetrag");
				String queryubetrag = queryOutput.getString("ungezahltBetrag");
				
				obs.add(new ZahlungSearchModel(queryid,queryename,querygbetrag,queryubetrag));
			}
			studentid.setCellValueFactory(new PropertyValueFactory<>("studentid"));
			elternName.setCellValueFactory(new PropertyValueFactory<>("elternName"));
			gezahltBetrag.setCellValueFactory(new PropertyValueFactory<>("gezahltBetrag"));
			ungezahltBetrag.setCellValueFactory(new PropertyValueFactory<>("ungezahltBetrag"));
			
			zahlungTableView.setItems(obs);

			
		} catch(SQLException e) {
			Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
		
	}
	 public int getStudentID() {
		 int number=-1;
		 DatabaseConnection connectNow = new DatabaseConnection();
		 Connection connectDB = connectNow.getConnection();
		 
		 String numberQuery = "SELECT number FROM idcounter";
		 
		 try {
				Statement statement = connectDB.createStatement();
				ResultSet queryOutput =  statement.executeQuery(numberQuery);
				
				while(queryOutput.next()) {
					number= queryOutput.getInt("number");
				}

				
			} catch(SQLException e) {
				Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
				e.printStackTrace();
			}
		 String increaseNumberQuery = "UPDATE idcounter SET number =" +(number+1);
		 try {
				Statement statement = connectDB.createStatement();
				statement.executeUpdate(increaseNumberQuery);

				
			} catch(SQLException e) {
				Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
				e.printStackTrace();
			}
		 
		return number;
			

	 }
	 public int getUserID() {
		 int number=-1;
		 DatabaseConnection connectNow = new DatabaseConnection();
		 Connection connectDB = connectNow.getConnection();
		 
		 String numberQuery = "SELECT number FROM userIDCounter";
		 
		 try {
				Statement statement = connectDB.createStatement();
				ResultSet queryOutput =  statement.executeQuery(numberQuery);
				
				while(queryOutput.next()) {
					number= queryOutput.getInt("number");
				}

				
			} catch(SQLException e) {
				Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
				e.printStackTrace();
			}
		 String increaseNumberQuery = "UPDATE idcounter SET 'number' =" +(number+1);
		 try {
				Statement statement = connectDB.createStatement();
				statement.executeUpdate(increaseNumberQuery);

				
			} catch(SQLException e) {
				Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
				e.printStackTrace();
			}
		 
		return number;
			

	 }
	 public void getTagZahl(String id) {
		 int number =1;
		 DatabaseConnection connectNow = new DatabaseConnection();
		 Connection connectDB = connectNow.getConnection();
		 
		 String numberQuery = "SELECT TagZahl FROM anwesenheit WHERE studentid ='"+id+"'";
		 
		 try {
				Statement statement = connectDB.createStatement();
				ResultSet queryOutput =  statement.executeQuery(numberQuery);
				
				while(queryOutput.next()) {
					number= queryOutput.getInt("TagZahl");
					System.out.println(number);
				}
				System.out.println(number);
				System.out.println(id);
				int newNumber = number+1;
				 String increaseNumberQuery = "UPDATE anwesenheit SET TagZahl ='" +newNumber+"' WHERE studentid ='"+ id +"'";
				 try {
						statement = connectDB.createStatement();
						statement.executeUpdate(increaseNumberQuery);
						System.out.println(number);

						
					} catch(SQLException e) {
						Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
						e.printStackTrace();
					}
				
			} catch(SQLException e) {
				Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
				e.printStackTrace();
			}

		 
		}
	 public String getFrist() {
		 String frist = "";
		 DatabaseConnection connectNow = new DatabaseConnection();
		 Connection connectDB = connectNow.getConnection();
		 
		 String fristQuery = "SELECT Frist FROM frist";
		 try {
				Statement statement = connectDB.createStatement();
				ResultSet queryOutput =  statement.executeQuery(fristQuery);
				
				while(queryOutput.next()) {
					frist= queryOutput.getString("Frist");
				}

				
			} catch(SQLException e) {
				Logger.getLogger(LehrerController.class.getName()).log(Level.SEVERE,null,e);
				e.printStackTrace();
			}
		 return frist;
	 }
	 public boolean validateLogin(String username, String password,String role) {
			DatabaseConnection connectNow = new DatabaseConnection();
			Connection connectDB = connectNow.getConnection();
			
			String verifyLogin = "SELECT count(1) FROM users WHERE name = '" + username +"' AND password = '" + password + "' AND  role ='" + role + "'" ;		
			System.out.println(verifyLogin);
			try {
				Statement statement = connectDB.createStatement();
				ResultSet queryResult = statement.executeQuery(verifyLogin);
			
				while(queryResult.next()) {
					if(queryResult.getInt(1) ==1) {
						
						return true;
						
						
					} else {
						
						return false;
					}
				}
				
			} catch(Exception e){
				e.printStackTrace();
			}
			return false;
		}
	
}

//String classNo, int id, String name, int age
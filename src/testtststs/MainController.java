package testtststs;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import oracle.jdbc.OracleDriver;

public class MainController implements Initializable {

    @FXML
    private TableColumn<Patient, String> C1name;
    @FXML
    private TableColumn<Patient, Integer> C2ID;
    @FXML
    private TableColumn<Patient, Integer> C3Code;
    @FXML
    private TableColumn<Patient, String> C4Address;
    @FXML
    private TableColumn<Patient, Integer> C5age;

    @FXML
    private TableColumn<Patient, String> C6casetype;
    @FXML
    private TableColumn<Patient, String> C7dr;
    @FXML
    private TableColumn<Patient, Integer> C8room;
    @FXML
    private TableView<Patient> tv;
    @FXML
    private AnchorPane main;
    private TextField DDsearch;
    @FXML
    private TextField PPsearch;
    @FXML
    private TableColumn<?, ?> C9Date;
    @FXML
    private TableView<Doctor> tv1;
    @FXML
    private TableColumn<?, ?> C1name1;
    @FXML
    private TableColumn<?, ?> C2ID1;
    @FXML
    private TableColumn<?, ?> C3Code1;
    @FXML
    private TableColumn<?, ?> C4Address1;
    @FXML
    private TableColumn<?, ?> C5age1;
    @FXML
    private TableColumn<?, ?> C6speciality;
    @FXML
    private TableColumn<?, ?> C7salary;
    @FXML
    private TextField txt;

    /**
     * #
     * Initializes the controller class.
     */
    @Override
    /*
    public Patient(  String Name, Integer ID , Integer Code, String ADdress, Integer Age ,String CaseType, String DR, int Room) {
        super(Name, ID, ADdress, Code, Age);
        this.CaseType = CaseType;
        this.DR = DR;
        this.Room = Room;
     */
    public void initialize(URL url, ResourceBundle rb) {
//     Connection conn ;
//    ResultSet res = null;
//     PreparedStatement pst = null;
//     ObservableList<Patient> data;
       
        ObservableList<Patient> list = FXCollections.observableArrayList();
        System.out.println("I made list");
        try {
            C1name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            C2ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            C3Code.setCellValueFactory(new PropertyValueFactory<>("Code"));
            C4Address.setCellValueFactory(new PropertyValueFactory<>("ADdress"));
            C5age.setCellValueFactory(new PropertyValueFactory<>("Age"));
            C6casetype.setCellValueFactory(new PropertyValueFactory<>("CaseType"));
            C7dr.setCellValueFactory(new PropertyValueFactory<>("DR"));
            C8room.setCellValueFactory(new PropertyValueFactory<>("Room"));

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
            System.out.println("I made connection");
            ResultSet rs = con.createStatement().executeQuery("select * from Patient");
            System.out.println("I reached before while");
            while (rs.next()) {
                String n = rs.getString("name");
                int id = rs.getInt("id");
                int Code = rs.getInt("code");
                String Address = rs.getString("address");
                int age = rs.getInt("age");
                String casetype = rs.getString("case");
                String dr = rs.getString("dr");
                int room = rs.getInt("room");
                System.out.println(n + "  " + id + "  " + Code + "  " + Address + "  " + age + "   " + casetype + "  " + dr + "  " + room);
                list.add(new Patient(n, id, Code, Address, age, casetype, dr, room));
//
            }
            tv.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                selectDR();
        /*
create table patient( name varchar(70) not null, id number(20), code number(5),address varchar(100),age number (3),case varchar(20),dr varchar(20),room number(2),primary key(name),FOREIGN KEY (dr) REFERENCES doctor(name))
insert into patient values ('Ahmed',130131313,400,'Mandara',27,'stomach ache','Ali',40);
create table surgery ( name varchar(20) , code number(5) ,Pname varchar(80),bookeddate date,primary key (code) ,foreign key (Pname) references patuent(name));

         */
        ;

    }
    public void selectDR(){
          ObservableList<Doctor> list2 = FXCollections.observableArrayList();
        System.out.println("I made list");
        try {
            C1name1.setCellValueFactory(new PropertyValueFactory<>("Name"));
            C2ID1.setCellValueFactory(new PropertyValueFactory<>("ID"));
            C3Code1.setCellValueFactory(new PropertyValueFactory<>("Code"));
            C4Address1.setCellValueFactory(new PropertyValueFactory<>("ADdress"));
            C5age1.setCellValueFactory(new PropertyValueFactory<>("Age"));
            C6speciality.setCellValueFactory(new PropertyValueFactory<>("Speciality"));
            C7salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
            System.out.println("I made connection");
            ResultSet rs = con.createStatement().executeQuery("select * from doctor");
            System.out.println("I reached before while");
            while (rs.next()) {
                String n = rs.getString("name");
                int id = rs.getInt("id");
                int Code = rs.getInt("code");
                String Address = rs.getString("address");
                int age = rs.getInt("age");
                String speciality = rs.getString("speciality");
                float salary = rs.getFloat("salary");

                list2.add(new Doctor(n, id, Code, Address, age, speciality, salary));
//String Name, Integer ID , Integer Code, String ADdress, Integer Age ,String CaseType, String DR, int Room)
            }

            tv1.setItems(list2);
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void select() {

        ObservableList<Patient> list = FXCollections.observableArrayList();
        System.out.println("I made list");
        try {
            C1name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            C2ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            C3Code.setCellValueFactory(new PropertyValueFactory<>("Code"));
            C4Address.setCellValueFactory(new PropertyValueFactory<>("ADdress"));
            C5age.setCellValueFactory(new PropertyValueFactory<>("Age"));
            C6casetype.setCellValueFactory(new PropertyValueFactory<>("CaseType"));
            C7dr.setCellValueFactory(new PropertyValueFactory<>("DR"));
            C8room.setCellValueFactory(new PropertyValueFactory<>("Room"));

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
            System.out.println("I made connection");
            ResultSet rs = con.createStatement().executeQuery("select * from Patient");
            System.out.println("I reached before while");
            while (rs.next()) {
                String n = rs.getString("name");
                int id = rs.getInt("id");
                int Code = rs.getInt("code");
                String Address = rs.getString("address");
                int age = rs.getInt("age");
                String casetype = rs.getString("case");
                String dr = rs.getString("dr");
                int room = rs.getInt("room");
                System.out.println(n + "  " + id + "  " + Code + "  " + Address + "  " + age + "   " + casetype + "  " + dr + "  " + room);
                list.add(new Patient(n, id, Code, Address, age, casetype, dr, room));
//String Name, Integer ID , Integer Code, String ADdress, Integer Age ,String CaseType, String DR, int Room)
            }
            tv.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Dadd(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("add doctor.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Add doctors");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();

    }

    @FXML
    private void Dupdate(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("Doctor update.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("update doctors");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();
    }

    @FXML
    private void Dremove(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("Remove Doctor.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Remove doctors");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();
    }

    @FXML
    private void Padd(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("Add patiet.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Add patients");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();

    }

    private void Premove(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("remove.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Remove patient");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();

    }

    @FXML
    private void Pupdate(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("update.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Update patients");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();

    }

    @FXML
    private void fees(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("getfees.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Calculate Fees");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();

    }

    private void Psurgery(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("Booksurg.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Book surgeries");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();

    }

    @FXML
    private void Pmedical_history(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("history.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Patient Medical History");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();

    }

    @FXML
    private void check_rooms(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("Available ROOMS.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Check Rooms");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();

    }

    @FXML
    private void show_surgeries(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("Booking.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Show Booked Surgeries");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();

    }

    private void show_dr(ActionEvent event) throws IOException {
        System.out.println("showdr");
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("viewdr.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Show Doctors List");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();
    }

    @FXML
    private void Dsearch(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("Search Doctor.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Search Doctors");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();

    }

    @FXML
    private void psearch(ActionEvent event) throws IOException {

        AnchorPane root1 = FXMLLoader.load(getClass().getResource("Search patient.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Search Patients");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();

    }

    @FXML
    private void booksurgery(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("booksurgery.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Book Surgeries");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();
    }

    private void secwin(ActionEvent event) throws IOException {
        System.out.println("showdr");
        AnchorPane a = FXMLLoader.load(getClass().getResource("DOCC.fxml"));
        System.out.println("docc");
        main.getChildren().setAll(a);
        System.out.println("set");
    }

    @FXML
    private void drlist(ActionEvent event) throws IOException {
        AnchorPane root1 = FXMLLoader.load(getClass().getResource("viewdr.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene(root1);
        Stage window = new Stage();
        window.setScene(s);
        window.setTitle("Show Doctors List");
        window.initModality(Modality.APPLICATION_MODAL);
        window.show();
    }

    private void clear_DDsearch(ActionEvent event) {
        DDsearch.setText("");
        select();
    }

    private void PPremove(ActionEvent event) throws SQLException {
        DriverManager.registerDriver(new OracleDriver());

        Connection c = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
        Patient d = tv.getSelectionModel().getSelectedItem();
        String sql = "delete from patient where code=?"; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
        PreparedStatement S = c.prepareStatement(sql);

        S.setInt(1, d.Code);
        S.executeQuery();
        select();
    }

    @FXML
    private void clear_PPsearch(ActionEvent event) {
        PPsearch.setText(null);
        select();
    }

    @FXML
    private void PPsearch(KeyEvent event) {
        if (PPsearch.getText() == null) {
            select();
        }
        ObservableList<Patient> list = FXCollections.observableArrayList();
        System.out.println("I made list");
        try {
            C1name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            C2ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            C3Code.setCellValueFactory(new PropertyValueFactory<>("Code"));
            C4Address.setCellValueFactory(new PropertyValueFactory<>("ADdress"));
            C5age.setCellValueFactory(new PropertyValueFactory<>("Age"));
            C6casetype.setCellValueFactory(new PropertyValueFactory<>("CaseType"));
            C7dr.setCellValueFactory(new PropertyValueFactory<>("DR"));
            C8room.setCellValueFactory(new PropertyValueFactory<>("Room"));

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
            System.out.println("I made connection");
            String sql = "select * from Patient where code LIKE '" + Integer.parseInt(PPsearch.getText()) + "%'";
            PreparedStatement S = con.prepareStatement(sql);
            int a = Integer.parseInt(PPsearch.getText());
//          S.setInt(1, a);
            ResultSet rs = S.executeQuery();
            while (rs.next()) {

                String n = rs.getString("name");
                int id = rs.getInt("id");
                int Code = rs.getInt("code");
                String Address = rs.getString("address");
                int age = rs.getInt("age");
                String casetype = rs.getString("case");
                String dr = rs.getString("dr");
                int room = rs.getInt("room");
                System.out.println(n + "  " + id + "  " + Code + "  " + Address + "  " + age + "   " + casetype + "  " + dr + "  " + room);
                list.add(new Patient(n, id, Code, Address, age, casetype, dr, room));
//String Name, Integer ID , Integer Code, String ADdress, Integer Age ,String CaseType, String DR, int Room)
            }
            tv.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void patientremove(ActionEvent event) throws SQLException {
        DriverManager.registerDriver(new OracleDriver());

        Connection c = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
        Patient d = tv.getSelectionModel().getSelectedItem();
        String sql = "delete from patient where code=?"; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
        PreparedStatement S = c.prepareStatement(sql);

        S.setInt(1, d.Code);
        S.executeQuery();
        select();
    }

    @FXML
    private void animationtoDDRR(ActionEvent event) {
        TranslateTransition transition=new TranslateTransition(Duration.seconds(2), tv1);
        transition.setToX(-1466);
        transition.play();
        TranslateTransition tr=new TranslateTransition(Duration.seconds(2), tv);
        tr.setToX(-1466);
        tr.play();
    }

    @FXML
    private void animationtoPATIENT(ActionEvent event) {
         TranslateTransition transition=new TranslateTransition(Duration.seconds(2), tv1);
        transition.setToX(0);
        transition.play();
        TranslateTransition tr=new TranslateTransition(Duration.seconds(2), tv);
        tr.setToX(0);
        tr.play();
    }

    @FXML
    private void rer(ActionEvent event) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
            Doctor d = tv1.getSelectionModel().getSelectedItem();
            String sql = "delete from doctor where code=?"; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
            PreparedStatement S = c.prepareStatement(sql);
            
            S.setInt(1, d.Code);
            S.executeQuery();
            selectDR();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clear(ActionEvent event) {
         txt.setText(null);
         
         selectDR();
    }

    @FXML
    private void search(KeyEvent event) {
           
        ObservableList<Doctor> list1 = FXCollections.observableArrayList();
        System.out.println("I made list");
        try {
            C1name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            C2ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            C3Code.setCellValueFactory(new PropertyValueFactory<>("Code"));
            C4Address.setCellValueFactory(new PropertyValueFactory<>("ADdress"));
            C5age.setCellValueFactory(new PropertyValueFactory<>("Age"));
            C6speciality.setCellValueFactory(new PropertyValueFactory<>("Speciality"));
            C7salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
            String sql = "select * from doctor where code LIKE '" + Integer.parseInt(txt.getText()) + "%'";
            PreparedStatement S = con.prepareStatement(sql);
            int a = Integer.parseInt(txt.getText());
//          S.setInt(1, a);
            ResultSet rs = S.executeQuery();
            while (rs.next()) {
                String n = rs.getString("name");
                int id = rs.getInt("id");
                int Code = rs.getInt("code");
                String Address = rs.getString("address");
                int age = rs.getInt("age");
                String speciality = rs.getString("speciality");
                float salary = rs.getFloat("salary");

                list1.add(new Doctor(n, id, Code, Address, age, speciality, salary));
//String Name, Integer ID , Integer Code, String ADdress, Integer Age ,String CaseType, String DR, int Room)
            }

            tv1.setItems(list1);
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

//        setCellTable();
//        loadData();
//    private void loadData() {
//        data = FXCollections.observableArrayList();
//        try {
//            conn = DB.DBConnection();
//            pst = conn.prepareStatement("Select * from PATIENT");
//            res = pst.executeQuery();
//            System.out.println(res.getString(1)+"   "+res.getInt(2));
//            while (res.next()) {
//                //   data.add(new Patient(res.getInt(1),res.getString(2),res.getDouble(3),res.getInt(4)));
//                data.add(new Patient(
//                                res.getString(1),
//                                res.getInt(2),
//                                res.getInt(3),
//                                res.getString(4),
//                                res.getInt(5),
//                                res.getString(7), res.getString(8), res.getInt(9)));
//                System.out.println(res.getString(1)+"   "+res.getInt(2));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        tv.setItems(data);
//    }
/*
    private String Name,ADdress;
    private Integer Code,Age,ID;
    private String CaseType; 
    private String DR;
    private int Room;
 */
//    private void setCellTable() {
//        C1name.setCellValueFactory(new PropertyValueFactory<>("Name"));
//        C2ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
//        C3Code.setCellValueFactory(new PropertyValueFactory<>("Code"));
//        C4Address.setCellValueFactory(new PropertyValueFactory<>("ADdress"));
//        C5age.setCellValueFactory(new PropertyValueFactory<>("Age"));
//        C6casetype.setCellValueFactory(new PropertyValueFactory<>("CaseType"));
//        C7dr.setCellValueFactory(new PropertyValueFactory<>("DR"));
//        C8room.setCellValueFactory(new PropertyValueFactory<>("Room"));
//    }
/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package testtststs;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohamed Foula
 *
public class showallcontroller implements Initializable {

    @FXML
    private AnchorPane drlist;
    @FXML
    private TableView<Doctor> tv;
    @FXML
    private TableColumn<?, ?> C1name;
    @FXML
    private TableColumn<?, ?> C2ID;
    @FXML
    private TableColumn<?, ?> C3Code;
    @FXML
    private TableColumn<?, ?> C4Address;
    @FXML
    private TableColumn<?, ?> C5age;
    @FXML
    private TableColumn<?, ?> C6speciality;
    @FXML
    private TableColumn<?, ?> C7salary;

    /**
     * Initializes the controller class.
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            ObservableList<Doctor> list = FXCollections.observableArrayList();
            System.out.println("I made list");
try { 
       C1name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            C2ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            C3Code.setCellValueFactory(new PropertyValueFactory<>("Code"));
            C4Address.setCellValueFactory(new PropertyValueFactory<>("ADdress"));
            C5age.setCellValueFactory(new PropertyValueFactory<>("Age"));
            C6speciality.setCellValueFactory(new PropertyValueFactory<>("Speciality"));
            C7salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
            
     
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
        System.out.println("I made connection");
            ResultSet rs = con.createStatement().executeQuery("select * from doctor");
            System.out.println("I reached before while");
            while (rs.next()){
                String n=rs.getString("name");
                int id =rs.getInt("id");
                int Code = rs.getInt("code");
                String Address=rs.getString("address");
                int age = rs.getInt("age");
                String speciality=rs.getString("speciality");
                float salary=rs.getFloat("salary");
              
                list.add(new Doctor(n, id, Code, Address, age, speciality, salary));
//String Name, Integer ID , Integer Code, String ADdress, Integer Age ,String CaseType, String DR, int Room)
            }
            tv.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void Dadd(ActionEvent event) throws IOException {
         AnchorPane root1=  FXMLLoader.load(getClass().getResource("add doctor.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show();

    }

    @FXML
    private void Dupdate(ActionEvent event) throws IOException {  
        AnchorPane root1=  FXMLLoader.load(getClass().getResource("Doctor update.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show();
    }

    @FXML
    private void Dremove(ActionEvent event) throws IOException {
          AnchorPane root1=  FXMLLoader.load(getClass().getResource("Remove Doctor.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show();
    }


    @FXML
    private void Padd(ActionEvent event) throws IOException {
          AnchorPane root1=  FXMLLoader.load(getClass().getResource("Add patiet.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show();

    }

    @FXML
    private void Premove(ActionEvent event) throws IOException {
          AnchorPane root1=  FXMLLoader.load(getClass().getResource("remove.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show();


    }

    @FXML
    private void Pupdate(ActionEvent event) throws IOException {
          AnchorPane root1=  FXMLLoader.load(getClass().getResource("update.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show();

    }

    @FXML
    private void fees(ActionEvent event) throws IOException {
          AnchorPane root1=  FXMLLoader.load(getClass().getResource("getfees.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show();

    }


    @FXML
    private void Psurgery(ActionEvent event) throws IOException {
        AnchorPane root1=  FXMLLoader.load(getClass().getResource("Booksurg.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show();

    }

    @FXML
    private void Pmedical_history(ActionEvent event) throws IOException {
                AnchorPane root1=  FXMLLoader.load(getClass().getResource("history.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show();

    }

    @FXML
    private void check_rooms(ActionEvent event) throws IOException { 
        AnchorPane root1=  FXMLLoader.load(getClass().getResource("Available ROOMS.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show();

    }
    
    @FXML
    private void show_surgeries(ActionEvent event) throws IOException {
          AnchorPane root1=  FXMLLoader.load(getClass().getResource("Booking.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show();

    }

   

    private void Dsearch(ActionEvent event) throws IOException {
         AnchorPane root1=  FXMLLoader.load(getClass().getResource("Search Doctor.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show(); 
        
       
    }

    private void psearch(ActionEvent event) throws IOException {
        
          AnchorPane root1=  FXMLLoader.load(getClass().getResource("Search patient.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show();

    }

    private void booksurgery(ActionEvent event) throws IOException {
           AnchorPane root1=  FXMLLoader.load(getClass().getResource("booksurgery.fxml"));
//        root2.getChildren().setAll(root1); 

        Scene s = new Scene (root1);
Stage window = new Stage ();
window.setScene(s);
window.initModality(Modality.APPLICATION_MODAL);
window.show();
    }
    @FXML
    private void show_patient(ActionEvent event) throws IOException {
               AnchorPane a=FXMLLoader.load(getClass().getResource("Main.fxml"));
        drlist.getChildren().setAll(a);
        
    }

}

 */

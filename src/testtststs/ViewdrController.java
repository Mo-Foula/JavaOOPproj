/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtststs;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import oracle.jdbc.driver.OracleDriver;

/**
 * FXML Controller class
 *
 * @author Mohamed Foula
 */
public class ViewdrController implements Initializable {

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
    @FXML
    private TextField txt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//
//        ObservableList<Doctor> list = FXCollections.observableArrayList();
//        System.out.println("I made list");
//        try {
//            C1name.setCellValueFactory(new PropertyValueFactory<>("Name"));
//            C2ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
//            C3Code.setCellValueFactory(new PropertyValueFactory<>("Code"));
//            C4Address.setCellValueFactory(new PropertyValueFactory<>("ADdress"));
//            C5age.setCellValueFactory(new PropertyValueFactory<>("Age"));
//            C6speciality.setCellValueFactory(new PropertyValueFactory<>("Speciality"));
//            C7salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
//
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
//            System.out.println("I made connection");
//            ResultSet rs = con.createStatement().executeQuery("select * from doctor");
//            System.out.println("I reached before while");
//            while (rs.next()) {
//                String n = rs.getString("name");
//                int id = rs.getInt("id");
//                int Code = rs.getInt("code");
//                String Address = rs.getString("address");
//                int age = rs.getInt("age");
//                String speciality = rs.getString("speciality");
//                float salary = rs.getFloat("salary");
//
//                list.add(new Doctor(n, id, Code, Address, age, speciality, salary));
////String Name, Integer ID , Integer Code, String ADdress, Integer Age ,String CaseType, String DR, int Room)
//            }
//
//            tv.setItems(list);
//        } catch (SQLException ex) {
//            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
//        }
                    select();
    }

    private void remove(ActionEvent event) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
           
           Connection c=DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
               String sql="delete from doctor where code=?"; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
           PreparedStatement S=c.prepareStatement(sql);
           int code=tv.getSelectionModel().getSelectedItem().Code;
            S.setInt(1, code);
            S.executeQuery();
            select();
    }

    private void search(ActionEvent event) {
     
    }

    @FXML
    private void search(KeyEvent event) {
           
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

                list.add(new Doctor(n, id, Code, Address, age, speciality, salary));
//String Name, Integer ID , Integer Code, String ADdress, Integer Age ,String CaseType, String DR, int Room)
            }

            tv.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clear(ActionEvent event) {
        txt.setText(null);
        select();
    }
    private void select(){
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
            while (rs.next()) {
                String n = rs.getString("name");
                int id = rs.getInt("id");
                int Code = rs.getInt("code");
                String Address = rs.getString("address");
                int age = rs.getInt("age");
                String speciality = rs.getString("speciality");
                float salary = rs.getFloat("salary");

                list.add(new Doctor(n, id, Code, Address, age, speciality, salary));
//String Name, Integer ID , Integer Code, String ADdress, Integer Age ,String CaseType, String DR, int Room)
            }

            tv.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void rere(ActionEvent event) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

        Connection c = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
        Doctor d = tv.getSelectionModel().getSelectedItem();
        String sql = "delete from doctor where code=?"; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
        PreparedStatement S = c.prepareStatement(sql);

        S.setInt(1, d.Code);
        S.executeQuery();
        select();
    }

    @FXML
    private void rer(ActionEvent event) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
            Doctor d = tv.getSelectionModel().getSelectedItem();
            String sql = "delete from doctor where CODE=?"; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
            PreparedStatement S = c.prepareStatement(sql);
            
            S.setInt(1, d.Code);
            S.executeQuery();
            select();
        } catch (SQLException ex) {
            Logger.getLogger(ViewdrController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
//#412d2d

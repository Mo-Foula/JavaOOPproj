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
import oracle.jdbc.OracleDriver;

/**
 * FXML Controller class
 *
 * @author Mohamed Foula
 */
public class SearchPatientController implements Initializable {

    @FXML
    private TableView<Patient> tv;
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
    private TableColumn<?, ?> C6casetype;
    @FXML
    private TableColumn<?, ?> C7dr;
    @FXML
    private TableColumn<?, ?> C8room;
    @FXML
    private TextField txt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void search(ActionEvent event) throws SQLException {
        
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
        String sql="select * from Patient where code=?";
       PreparedStatement S=con.prepareStatement(sql);
          int a=Integer.parseInt(txt.getText());
          S.setInt(1, a);
          ResultSet rs= S.executeQuery();
            System.out.println("I reached before while");
            while (rs.next()){
                String n=rs.getString("name");
                int id =rs.getInt("id");
                int Code = rs.getInt("code");
                String Address=rs.getString("address");
                int age = rs.getInt("age");
                String casetype=rs.getString("case");
                String dr=rs.getString("dr");
                int room = rs.getInt("room");
                System.out.println(n+"  "+id+"  "+ Code+"  "+Address+"  "+age + "   "+casetype+"  "+dr+"  "+room );
                list.add(new Patient(n,id,Code,Address,age,casetype,dr,room)); 
//String Name, Integer ID , Integer Code, String ADdress, Integer Age ,String CaseType, String DR, int Room)
            }
            tv.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
//           DriverManager.registerDriver(new OracleDriver());
//           
//          
//           Connection c=DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
//         
//           String sql="select * from patient where code=?"; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
//           
//           PreparedStatement S=c.prepareStatement(sql);
//           S.setString(1, txt.getText());
//          ResultSet rs= S.executeQuery();
        
    }
    
}

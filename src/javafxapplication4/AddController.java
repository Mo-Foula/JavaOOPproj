/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import oracle.jdbc.OracleDriver;

/**
 * FXML Controller class
 *
 * @author Mohamed Foula
 */
public class AddController implements Initializable {

    @FXML
    private TextField txtroom;
    @FXML
    private TextField txtdoctor;
    @FXML
    private TextField txtage;
    @FXML
    private Label label;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtcode;
    @FXML
    private TextField txtaddress;
    @FXML
    private TextField txtcasetype;
    @FXML
    private TextField txtdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insert(ActionEvent event) {
      try{
           DriverManager.registerDriver(new OracleDriver());
           
           Connection c=DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
           String sql="insert into patient values (?,?,?,?,?,?,?,?,?)"; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
           PreparedStatement S=c.prepareStatement(sql);
           int id=Integer.parseInt(txtid.getText());
           int code=Integer.parseInt(txtcode.getText());
           String name=txtname.getText();
           String address=txtaddress.getText();
           String casetype=txtcasetype.getText();
           String doctor=txtdoctor.getText();
           String room=txtroom.getText();
           String date1=txtdate.getText();
           int age=Integer.parseInt(txtage.getText());
           S.setString(1, name);
           S.setInt(2, id);
           S.setInt(3, code);
           S.setString(4, address);
           S.setInt(5, age);
           S.setString(6, casetype);
           S.setString(7, doctor);
           S.setString(8, room);
           S.setString(9, date1);
           S.executeQuery();
       }
       catch (Exception e) {
           System.out.println(e.toString());
       }
    }

    @FXML
    private void cancel(ActionEvent event) {
    }
    
}

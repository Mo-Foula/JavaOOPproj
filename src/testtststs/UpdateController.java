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
public class UpdateController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField textname;
    @FXML
    private TextField txtdoctor;
    @FXML
    private TextField txtcode;
    @FXML
    private TextField txtage;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtaddress;
    @FXML
    private TextField txtcasetype;
    @FXML
    private TextField txtroom;
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
    private void add(ActionEvent event) {
    }

    @FXML
    private void cancel(ActionEvent event) {
    }

   @FXML
        private void update(ActionEvent event) {
        
       try{
           DriverManager.registerDriver(new OracleDriver());
           
          
           Connection c=DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
           System.out.println("I reached here");
           String sql="update patient set name= ? ,id= ? ,address= ? ,age= ? , case= ? ,dr= ? ,room= ? ,date1= ?  where code= ? "; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
           
           PreparedStatement S=c.prepareStatement(sql);
           System.out.println("I reached here");
           int id=Integer.parseInt(txtid.getText());
           
           Integer Id = new Integer(id);
           String name=txtname.getText();
           
           int code=Integer.parseInt(txtcode.getText());
           
           S.setInt(9, code);
           if(Id.equals(null)){
            
          }else{
            S.setInt(2, id);
          }
           
           //String name=txtname.getText();
          
           if (name.equals(null)) {
             
           }else{
                S.setString(1, name);
           }
           String address=txtaddress.getText();
           if (address.equals(null)) {
             
           }else{
            S.setString(3, address);
          }
           String casetype=txtcasetype.getText();
           if (casetype.equals(null)) {
             
           }else{
            S.setString(5, casetype);
          }
           String doctor=txtdoctor.getText();
           if (doctor.equals(null)) {
             
           }else{
              S.setString(6, doctor);
           }
           String room=txtroom.getText();
           if (room.equals(null)) {
             
           }else{
             S.setString(7, room);
           }
           int age=Integer.parseInt(txtage.getText());
           Integer Age = new Integer(age);
           if (Age.equals(null)) {
             
           }else{
            S.setInt(4, age);
          }

           
           String date1=txtdate.getText();
           if (date1.equals(null)) {
             
           }else{
            S.setString(8, date1);
           }
           S.executeQuery();
       }
       catch (Exception e) {
           System.out.println(e.toString());
       }
        
    }

}

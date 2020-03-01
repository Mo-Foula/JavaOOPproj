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
public class DoctorUpdateController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField textname;
    private TextField txtdoctor;
    @FXML
    private TextField txtcode;
    @FXML
    private TextField txtage;
    private TextField txtroom;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtaddress;
    @FXML
    private TextField txtspec;
    @FXML
    private TextField txtsalary;

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
           String sql="update doctor set name= ? ,id= ? ,address= ? ,age= ? , speciality= ? ,salary= ?   where code= ? "; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
           
           PreparedStatement S=c.prepareStatement(sql);
           System.out.println("I reached here");
           int id=Integer.parseInt(txtid.getText());
           
           Integer Id = new Integer(id);
           String name=txtname.getText();
          
           int code=Integer.parseInt(txtcode.getText());
           
           S.setInt(7, code);
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
           String spec=txtspec.getText();
           if (spec.equals(null)) {
             
           }else{
            S.setString(5, spec);
          }
           
           Float sal=Float.parseFloat(txtsalary.getText());
           
           if (sal.equals(null)) {
             
           }else{
               
             S.setFloat(6,  sal);
           }
           int age=Integer.parseInt(txtage.getText());
           Integer Age = new Integer(age);
           if (Age.equals(null)) {
             
           }else{
            S.setInt(4, age);
          }

           
           
           S.executeQuery();
       }
       catch (Exception e) {
           System.out.println(e.toString());
       }
        
    
    }
    
}

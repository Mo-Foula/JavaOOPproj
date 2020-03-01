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
public class AddDoctorController implements Initializable {

    @FXML
    private TextField dage;
    @FXML
    private TextField dsalary;
    @FXML
    private Label label;
    @FXML
    private TextField dname;
    @FXML
    private TextField did;
    @FXML
    private TextField dcode;
    @FXML
    private TextField daddress;
    @FXML
    private TextField dspeciality;

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
           String sql="insert into doctor values (?,?,?,?,?,?,?)"; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
           PreparedStatement S=c.prepareStatement(sql);
           int id=Integer.parseInt(did.getText());
           int code=Integer.parseInt(dcode.getText());
           String name=dname.getText();
           String address=daddress.getText();
           String speciality=dspeciality.getText();
           int age=Integer.parseInt(dage.getText());
           double salary= Double.parseDouble(dsalary.getText());
           S.setString(1, name);
           S.setInt(2, id);
           S.setInt(3, code);
           S.setString(4, address);
           S.setInt(5, age);
           S.setString(6, speciality);
           S.setFloat(7, (float) salary);
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

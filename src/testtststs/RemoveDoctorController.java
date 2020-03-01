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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import oracle.jdbc.driver.OracleDriver;

/**
 * FXML Controller class
 *
 * @author Mohamed Foula
 */
public class RemoveDoctorController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField textname;
    @FXML
    private TextField textcode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
@FXML
    private void remove(ActionEvent event) throws SQLException {
        
           DriverManager.registerDriver(new OracleDriver());
           
           Connection c=DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
               String sql="delete from doctor where code=?"; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
           PreparedStatement S=c.prepareStatement(sql);
           int code=Integer.parseInt(textcode.getText());
            S.setInt(1, code);
            S.executeQuery();
            //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
            //PreparedStatement S=c.prepareStatement(sql);
//             String sql="delete from product where ID=?";
//          
//            Statement S= c.createStatement();
//            
//            S.execute(sql);
            //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
            //PreparedStatement S=c.prepareStatement(sql);
//             String sql="delete from product where ID=?";
//          
//            Statement S= c.createStatement();
//            
//            S.execute(sql);


    }


    @FXML
    private void cancel(ActionEvent event) {
    }
    
}

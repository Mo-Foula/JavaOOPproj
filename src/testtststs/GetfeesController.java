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
public class GetfeesController implements Initializable {

    @FXML
    private TextField textcode;
    @FXML
    private Label FeesLbl;
    @FXML
    private TextField textdays;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RemovePatient(ActionEvent event) throws SQLException {
        double a=Double.parseDouble(textdays.getText())*550;
        int b=0;
        
            DriverManager.registerDriver(new OracleDriver());
           
          
           Connection c=DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
         
           String sql="select * from surgery where Pname=?"; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
           
           PreparedStatement S=c.prepareStatement(sql);
           S.setString(1, textcode.getText());
          ResultSet rs= S.executeQuery();
          while(rs.next()){
              b++;
          }
        a+=b*2000;
        String cc=a+"";
        FeesLbl.setText(cc);
    }

    
}

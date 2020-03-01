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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author Mohamed Foula
 */
public class BookSurgController implements Initializable {
    


/**
 * FXML Controller class
 *
 * @author Mohamed Foula
 */


    @FXML
    private TextField name;
    @FXML
    private TextField code;
    private TextField Pname;
    @FXML
    private TextField drtxt;
    @FXML
    private DatePicker date1;
    @FXML
    private TextField textPname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void add(ActionEvent event) {
          try{
           DriverManager.registerDriver(new OracleDriver());
           
           Connection c=DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
           String sql="insert into surgery  values (?,?,?,?,?) "; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
           PreparedStatement S=c.prepareStatement(sql);
           int code=Integer.parseInt(this.code.getText());
           String name1=name.getText();
           
          //Date date1=Date.valueOf(LocalDate.MAX);
           
//               Date date1 = Calendar.getInstance().getTime();  
//DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
//            String strDate = dateFormat.format(date); 
LocalDate date1 = this.date1.getValue();
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
              String strDate = date1.format(formatter);
//              System.out.println(date1);
//String strDate = date.getText();
              System.out.println();
              System.out.println(strDate);
//              String aa= date1;
           String pname=Pname.getText();
           S.setInt(2, code);
           S.setString(1, name1);
           S.setString(3, pname);
           S.setString(4, drtxt.getText());
           S.setString(5, strDate);
           S.executeQuery(); 
       }
       catch (Exception e) {
           System.out.println(e.toString());
       }
    }}

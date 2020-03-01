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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
public class HistoryController implements Initializable {

    private TextField textcode;
    @FXML
    private TableView<Surgery> tv;
    @FXML
    private TableColumn<?, ?> C1Code;
    @FXML
    private TableColumn<?, ?> C2Name;
    @FXML
    private TableColumn<?, ?> C3Doctor;
    @FXML
    private TableColumn<?, ?> C4date;
    @FXML
    private Label surg;
    @FXML
    private TextField textname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        surg.setVisible(false);
        tv.setVisible(false);
    }    

    @FXML
    private void showhistory(ActionEvent event) throws SQLException {
           String a=textname.getText();
           DriverManager.registerDriver(new OracleDriver());
           
           Connection c=DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
           String sql="select * from surgery where Pname=?"; //jdbc:oracle:thin:HR2/HR@localhost:1521/XE
        
           PreparedStatement S=c.prepareStatement(sql);
           S.setString(1, a);
           ResultSet rs=S.executeQuery();
          ObservableList<Surgery> list = FXCollections.observableArrayList();
            
try { 
       C1Code.setCellValueFactory(new PropertyValueFactory<>("code"));
            C2Name.setCellValueFactory(new PropertyValueFactory<>("name"));
            C3Doctor.setCellValueFactory(new PropertyValueFactory<>("dr"));
            C4date.setCellValueFactory(new PropertyValueFactory<>("bookeddate"));
           
            while(rs.next()){
              int code =rs.getInt("code");
              String name=rs.getString("name");
              String dr=rs.getString("doctor");
              String date=rs.getString("bookeddate");
              list.add(new Surgery(code, name, dr, date));
            }
            tv.setItems(list);
} catch(Exception e){
    
}
           
           
           surg.setVisible(true);
        tv.setVisible(true);
         
    }
    
}

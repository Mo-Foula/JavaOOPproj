/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtststs;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Mohamed Foula
 */
public class BookingController implements Initializable {

    @FXML
    private TableView <Surgery> tv;
    @FXML
    private TableColumn<?, ?> C1PName;
    @FXML
    private TableColumn<?, ?> C2Surgery;
    @FXML
    private TableColumn<?, ?> C3Code;
    @FXML
    private TableColumn<?, ?> C4Date;
    @FXML
    private TableColumn<?, ?> C5Doctor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              ObservableList<Surgery> list = FXCollections.observableArrayList();
            System.out.println("I made list");
try { 
       C1PName.setCellValueFactory(new PropertyValueFactory<>("Pname"));
            C2Surgery.setCellValueFactory(new PropertyValueFactory<>("name"));
            C3Code.setCellValueFactory(new PropertyValueFactory<>("code"));
            C4Date.setCellValueFactory(new PropertyValueFactory<>("bookeddate"));
            C5Doctor.setCellValueFactory(new PropertyValueFactory<>("dr"));
           
     
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
        System.out.println("I made connection");
            ResultSet rs = con.createStatement().executeQuery("select * from surgery");
            System.out.println("I reached before while");
            while (rs.next()){
                String nn=rs.getString("Pname");
                String n=rs.getString("name");
                int Code = rs.getInt("code");
                String d=rs.getString("bookeddate");
                String dr=rs.getString("doctor");
                //int code, String name, String Pname, String dr, String bookeddate
                list.add(new Surgery(Code, n, nn, dr,d)); 
//String Name, Integer ID , Integer Code, String ADdress, Integer Age ,String CaseType, String DR, int Room)
            }
            tv.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}

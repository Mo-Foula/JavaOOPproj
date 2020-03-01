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
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Mohamed Foula
 */
public class AvailableROOMSController implements Initializable {

    @FXML
    private TableView<Patient> tvv;
    @FXML
    private TableColumn<?, ?> C1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
            ObservableList <Patient> list1 = FXCollections.observableArrayList();
            System.out.println("I made list");
try { 
            C1.setCellValueFactory(new PropertyValueFactory<>("room"));
     
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:FOULA/dbpass@localhost:1521:XE");
        System.out.println("I made connection");
            ResultSet rs = con.createStatement().executeQuery("select * from Patient ");
            System.out.println("I reached before while");
            while (rs.next()){
                int aa = rs.getInt("room");
               list1.add(new Patient(aa,null,null,null,null,null));
               //int Room, String Name, Integer ID, String ADdress, Integer Code, Integer Age
//String Name, Integer ID , Integer Code, String ADdress, Integer Age ,String CaseType, String DR, int Room)
            }
                tvv.setItems(list1);
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}

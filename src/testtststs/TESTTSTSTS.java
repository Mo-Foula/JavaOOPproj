/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtststs;

import java.lang.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 *
 * @author Mohamed Foula
 */
public class TESTTSTSTS extends Application {
    public static Stage a;
    @Override
    public void start(Stage a) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        a.setScene(scene);
        a.setTitle("Login");
        a.show();
         
    }
    public static void main(String[] args) {
        launch(args);
    }
}

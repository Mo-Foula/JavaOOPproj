package testtststs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    static String aaad;
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private AnchorPane root1;
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        String a = user.getText();
        String b = pass.getText();
        login(a, b);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    public boolean login(String a, String b) throws IOException {

        if (a.equals("email") && b.equals("pass")) {
            label.setText("successful login");

            aaad = label.getStyle();
//                label.setTextFill(Paint.valueOf("green"));
            label.setStyle("-fx-text-fill: green;");
            AnchorPane Main = FXMLLoader.load(getClass().getResource("Main.fxml"));
//                    root1.getChildren().setAll(Main);
            Scene s = new Scene(Main);
            Stage window = new Stage();
            window.setScene(s);
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Hospital management program");
            window.show();
            user.setText(null);
            pass.setText(null);
            
            //root1.getChildren().setAll(Main);
            return true;
        }
        label.setText("Wrong input , try again.");
        label.setStyle(aaad); // TO make red again even if u entered it once right
        return false;
    }
    private void handleButtonAction(KeyEvent event) throws IOException {
        String a = user.getText();
        String b = pass.getText();
        login(a, b);
    }
}

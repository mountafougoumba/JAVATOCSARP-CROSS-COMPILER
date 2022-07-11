/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senior_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Mountafougoumba
 */
public class LoginController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private TextField usernametxtfield;
    @FXML
    private PasswordField passwordtxtfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onLogin(ActionEvent event) throws IOException {
        if (usernametxtfield.getText().equals("mountafougoumba19@gmail.com") && passwordtxtfield.getText().equals("Mounta1997@")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Translator.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene((Pane) loader.load()));
            stage.show();
            Node closeWindow = (Node) event.getSource();
            Stage stage1 = (Stage) closeWindow.getScene().getWindow();
            stage1.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Sorry you password is wrong!");
            alert.showAndWait();
            usernametxtfield.clear();
            passwordtxtfield.clear();
        }
    }

    @FXML
    private void Oncancel(ActionEvent event) {
        usernametxtfield.clear();
        passwordtxtfield.clear();
    }

}

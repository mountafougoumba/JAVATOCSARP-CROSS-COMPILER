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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Mountafougoumba
 */
public class SavefileController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private TextField filepathtxt;
    @FXML
    private TextField filenametxt;
    private String filepath;
    private String filename;
    private String tobedisplayed;

    public Button getLogin() {
        return login;
        // TODO
    }

    public void setLogin(Button login) {
        this.login = login;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTobedisplayed() {
        return tobedisplayed;
    }

    public void setTobedisplayed(String tobedisplayed) {
        this.tobedisplayed = tobedisplayed;
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Onfileparamsave(ActionEvent event) throws IOException {
        filename = filenametxt.getText();
        filepath = filepathtxt.getText();
        System.out.println(filename + filepath);
        System.out.println(tobedisplayed);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Translator.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        stage.show();
        Node closeWindow = (Node) event.getSource();
        Stage stage1 = (Stage) closeWindow.getScene().getWindow();
        stage1.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Well done!");
        alert.showAndWait();

    }
    public void initialiseText(String s){
        tobedisplayed=s;
    }

    @FXML
    private void Oncancel(ActionEvent event) {
    }

}

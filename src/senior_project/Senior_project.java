/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senior_project;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import test.Rectangle;

/**
 *
 * @author Mountafougoumba
 */
public class Senior_project extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       
         Parent root1 = FXMLLoader.load(getClass().getResource("login.fxml"));

        Scene scene = new Scene(root1);
        
        primaryStage.setTitle("JAVA TO C# CROSS COMPILER");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TranslatorController controller = new TranslatorController();
        launch(args);
    }
    
}

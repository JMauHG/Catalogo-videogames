/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogovideojuegos;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CatalogoVideojuegos extends Application {

    Stage window;

    @Override
    public void start(Stage window) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/Resources/Views/sceneGames.fxml"));
            Scene scene = new Scene(root);
            window.setScene(scene);
            window.setTitle("CONTROL DE DIVISAS");
            window.show();

        } catch (IOException ex) {
            Logger.getLogger(CatalogoVideojuegos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

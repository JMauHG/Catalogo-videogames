/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casadecambio;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Proyectos
 */
public class CasaDeCambio extends Application {

    Stage window;

    @Override
    public void start(Stage window) {
        try {
            Parent root; //Defino padre o raíz del documento

            //Cargo la ventana al escenario o raíz del documento
            root = FXMLLoader.load(getClass().getResource("/Resources/Views/sceneDivisas.fxml"));

            //Creo un nuevo escenario y le asigno la raíz
            Scene scene = new Scene(root);

            //Stage - Parent - Scene
            //A la ventana que estoy creado por parámetros le asigno el escenario
            window.setScene(scene);

            //Asigno el títuo de la ventana
            window.setTitle("CONTROL DE DIVISAS");
            //TODO: FALTA MANEJAR TAMAÑOS DE VENTANA
            //            window.setMaximized(true);

            //Finalmente muestro la ventana
            window.show();

        } catch (IOException ex) {
            Logger.getLogger(CasaDeCambio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

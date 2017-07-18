/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduleprefet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author super
 */
public class ModulePrefet extends Application {
    public static Long idCollectivite;
    
    @Override
    public void start(Stage stage) throws Exception {
        FlowControler flowControler=new FlowControler();
        flowControler.openLogin(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

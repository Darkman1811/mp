/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduleprefet;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;


/**
 *
 * @author super
 */
public class PrincipaleControler implements Initializable{
    
    @FXML
    private void openwindow(ActionEvent event) throws IOException{
       Stage fenetre=new Stage();
       fenetre.setTitle("Arbitrage");
      
        Parent arbitrage = FXMLLoader.load(getClass().getResource("arbitrage.fxml"));
         
        
        Scene scene = new Scene(arbitrage);
        
        fenetre.setScene(scene);
        fenetre.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }
    
}

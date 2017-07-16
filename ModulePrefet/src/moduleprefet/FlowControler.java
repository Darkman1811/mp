/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduleprefet;

import Crud.CrudBV;
import Crud.CrudCV;
import Crud.CrudCollectivite;
import Crud.CrudDepartement;
import Crud.CrudQuartier;
import Crud.CrudRegion;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import reporting.BV;
import reporting.CV;
import reporting.Collectivite;
import reporting.Departement;
import reporting.Pays;
import reporting.Quartier;
import reporting.Region;


/**
 *
 * @author super
 */
public class FlowControler implements Initializable{
    public static Stage fenLoad;
    
    @FXML
    ComboBox comboPays;
    @FXML
    ComboBox comboRegion;
    @FXML
    ComboBox comboDepartement;
    @FXML
    ComboBox comboCollectivite;
    @FXML
    ComboBox comboQuartier;
    @FXML
    ComboBox comboCentre;
    @FXML
    ComboBox comboBureau;
    
    @FXML
    public void openLogin(ActionEvent event) throws IOException{
        openLoad("connection.fxml");
    }
    
     @FXML
    public void openInitialisation(ActionEvent event) throws IOException{
         openLoad("Initialiser.fxml");       
    }
    
   
     @FXML
    public void openProgression(ActionEvent event) throws IOException{
         openLoad("progression.fxml");
    }
    
     public void openPrincipale(ActionEvent event) throws IOException{       
         openNew("Principale.fxml", "Module prefet");       
    }
     
    public void openArbitrage(ActionEvent event) throws IOException{       
       openNew("arbitrage.fxml", "Arbitrage");
    }
    
    private void openNew(String url,String title) throws IOException{
       try{fenLoad.close();}       catch( Exception e){}
       Stage fenetre=new Stage();
       fenetre.setTitle("Module prefet");      
       Parent parent = FXMLLoader.load(getClass().getResource(url));
       Scene scene = new Scene(parent);
       fenetre.setScene(scene);
       fenetre.show();
    }
    private void openLoad(String url) throws IOException{
        try{fenLoad.close();}       catch( Exception e){}
         Parent parent = FXMLLoader.load(getClass().getResource(url));       
       Scene scene = new Scene(parent,Color.TRANSPARENT);      
       fenLoad.initStyle(StageStyle.TRANSPARENT);
       fenLoad.setScene(scene);
       fenLoad.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {           
           fenLoad=new Stage();
           fenLoad.setTitle("Connection");
           Scene scene = new Scene(new VBox(),Color.TRANSPARENT);
           fenLoad.initStyle(StageStyle.TRANSPARENT);
           fenLoad.setScene(scene);
           this.load();
            
    }
    
     public void load() {
        //Alimenter le comboBox des pays
        if(comboPays!=null){
        List <Pays> lst=new Crud.CrudPays().getAll();
        lst.stream().forEach((pays) -> {
            comboPays.getItems().add(pays.getLibelle());
        });
        }
        
        //Alimenter le comboBox des Régions
        if(comboRegion!=null){
            List <Region> lstr=new CrudRegion().getAll();
            lstr.stream().forEach((region)->{
                comboRegion.getItems().add(region.getLibelle());
            });
        }
        
         //Alimenter le comboBox des Département
        if(comboDepartement!=null){
            List <Departement> lstr=new CrudDepartement().getAll();
            lstr.stream().forEach((departement)->{
                comboDepartement.getItems().add(departement.getLibelle());
            });
        }
        
        
          //Alimenter le comboBox des Collectivite
        if(comboCollectivite!=null){
            List <Collectivite> lste=new CrudCollectivite().getAll();
            lste.stream().forEach((collectivite)->{
                comboCollectivite.getItems().add(collectivite.getLibelle());
            });
        }
        
          //Alimenter le comboBox des Quartier
        if(comboQuartier!=null){
            List <Quartier> lste=new CrudQuartier().getAll();
            lste.stream().forEach((quartier)->{
                comboQuartier.getItems().add(quartier.getLibelle());
            });
        }
        
        
          //Alimenter le comboBox des Centres de vote
        if(comboCentre!=null){
            List <CV> lste=new CrudCV().getAll();
            lste.stream().forEach((cv)->{
                comboCentre.getItems().add(cv.getLibelle());
            });
        }
        
          //Alimenter le comboBox des Bureau de vote
        if(comboBureau!=null){
            List <BV> lste=new CrudBV().getAll();
            lste.stream().forEach((bureauDeVote)->{
                comboBureau.getItems().add(bureauDeVote.getLibelle());
            });
        }
        
    }
   
     @FXML
     public void load2(ActionEvent event){
         ComboBox combo=(ComboBox<String>)event.getSource();
         System.out.println(combo.getValue());
       //Alimenter le comboBox des Régions
        /*if(combo!=null){
            List <Region> lstr=new CrudRegion().getAll((Long)comboPays.getValue());
            System.out.println(lstr.size());
            lstr.stream().forEach((val)->{
                combo.getItems().add(val.getLibelle());
            });
        }   */
     }
    
}

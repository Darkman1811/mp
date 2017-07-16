/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduleprefet;

import Crud.Crud;
import Crud.CrudBV;
import Crud.CrudCV;
import Crud.CrudCollectivite;
import Crud.CrudDepartement;
import Crud.CrudPays;
import Crud.CrudQuartier;
import Crud.CrudRegion;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.util.StringConverter;
import reporting.BV;
import reporting.CV;
import reporting.Collectivite;
import reporting.Departement;
import reporting.Pays;
import reporting.Quartier;
import reporting.Region;
import utils.ComboLoader;

/**
 *
 * @author super
 */
public class FlowControler implements Initializable {

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
    public void openLogin(ActionEvent event) throws IOException {
        openLoad("connection.fxml");
    }

    @FXML
    public void openInitialisation(ActionEvent event) throws IOException {
        openLoad("Initialiser.fxml");
    }

    @FXML
    public void openProgression(ActionEvent event) throws IOException {
        openLoad("progression.fxml");
    }

    public void openPrincipale(ActionEvent event) throws IOException {
        openNew("Principale.fxml", "Module prefet");
    }

    public void openArbitrage(ActionEvent event) throws IOException {
        openNew("arbitrage.fxml", "Arbitrage");
    }
  
    private void openNew(String url, String title) throws IOException {
        try {fenLoad.close();} catch (Exception e) {}
        Stage fenetre = new Stage();
        fenetre.setTitle("Module prefet");
        Parent parent = FXMLLoader.load(getClass().getResource(url));
        Scene scene = new Scene(parent);
        fenetre.setScene(scene);
        fenetre.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fenLoad = new Stage();
        fenLoad.setTitle("Connection");
        Scene scene = new Scene(new VBox(), Color.TRANSPARENT);
        fenLoad.initStyle(StageStyle.TRANSPARENT);
        fenLoad.setScene(scene);
        try {this.load();} catch (NullPointerException ex) {}
    }

 

    private void openLoad(String url) throws IOException {
        try {fenLoad.close();} catch (Exception e) {}
        Parent parent = FXMLLoader.load(getClass().getResource(url));
        Scene scene = new Scene(parent, Color.TRANSPARENT);
        fenLoad.initStyle(StageStyle.TRANSPARENT);
        fenLoad.setScene(scene);
        fenLoad.show();
    }
    
     public void load() throws NullPointerException {
        new ComboLoader<Pays>().laod(new Pays(), comboPays);
        new ComboLoader<Region>().laod(new Region(), comboRegion);
        new ComboLoader<Departement>().laod(new Departement(), comboDepartement);
        new ComboLoader<Collectivite>().laod(new Collectivite(), comboCollectivite);
        new ComboLoader<Quartier>().laod(new Quartier(), comboQuartier);
        new ComboLoader<CV>().laod(new CV(), comboCentre);
        new ComboLoader<BV>().laod(new BV(), comboBureau);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduleprefet;


import Crud.Crud;
import Crud.CrudParti;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import reporting.BV;
import reporting.CV;
import reporting.Collectivite;
import reporting.Departement;
import reporting.Parti;
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
    ComboBox comboCentre;
    @FXML
    ComboBox comboBureau;
    @FXML
    VBox panelContentContact;
    @FXML
    VBox panelContentParti;        
   
    
    int contactIndex=0;

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
        try {this.load();chargeCollectivite();ajouterPartis();} catch (NullPointerException ex) {}
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
        
        /*  Pays pays=new Pays();
        pays.setId(new Long(198));
        pays.setLibelle("Sénégal");
        comboPays.getSelectionModel().select(pays);
       Pays data=(Pays)comboPays.getSelectionModel().getSelectedItem();
        new ComboLoader<Region>().laodFromParent(new Region(), comboRegion, "pays.id", data.getId());*/
               /* new ComboLoader<Region>().laod(new Region(), comboRegion);
        new ComboLoader<Departement>().laod(new Departement(), comboDepartement);
        new ComboLoader<Collectivite>().laod(new Collectivite(), comboCollectivite);
        new ComboLoader<Quartier>().laod(new Quartier(), comboQuartier);
        new ComboLoader<CV>().laod(new CV(), comboCentre);
        new ComboLoader<BV>().laod(new BV(), comboBureau);*/
        
    }
     
     
     
             
    @FXML
    private void ajouterContact(ActionEvent event) {
        VBox panelContact = new VBox();

        ComboBox roleContact = new ComboBox();
        roleContact.setPromptText("Role");
        roleContact.setPrefWidth(150);
        roleContact.setId("roleContact" + contactIndex);

        Button deleteContact = new Button("Delete");
        deleteContact.setOnAction(e -> {
            panelContentContact.getChildren().remove(deleteContact.getParent().getParent());
        });

        HBox contactTop = new HBox();
        contactTop.getChildren().addAll(roleContact, deleteContact);

        TextField prenomContact = new TextField();
        prenomContact.setPromptText("Prénom");

        TextField nomContact = new TextField();
        nomContact.setPromptText("Nom");

        TextField phoneContact = new TextField();
        phoneContact.setPromptText("Téléphone");

        TextField emailContact = new TextField();
        emailContact.setPromptText("Email");

        Separator sep = new Separator(Orientation.HORIZONTAL);

        panelContact.getChildren().addAll(contactTop, prenomContact, nomContact, phoneContact, emailContact, sep);
        panelContentContact.getChildren().add(panelContact);
         
    }
    
    @FXML
    private void ajouterPartis(){
        String imageBase="file:/media/super/YACINE%20LOGICIELS/ProjetElection/ModulePrefet/src/moduleprefet/images/";
        List<Parti> lst=new CrudParti().getAll();
        lst.stream().forEach((Parti parti)->{
           Label labelNomParti=new Label(parti.getNom());
        TextField score=new TextField();score.setPromptText("Score parti");
        TextField confirmation=new TextField();confirmation.setPromptText("Confirmation score");
        VBox niv1=new VBox(labelNomParti,score,confirmation);
        ImageView logoParti=new ImageView(imageBase+parti.getImage());
        logoParti.setPreserveRatio(true);
        logoParti.setSmooth(true);
        logoParti.setFitHeight(117);
        logoParti.setFitWidth(101);
        HBox niv2=new HBox(logoParti,niv1);
        VBox partiContent=new VBox(new Separator(),niv2,new Separator());
        panelContentParti.getChildren().add(partiContent);  
        });
       
    }
    
    @FXML
    private void saisieInitial(ActionEvent event){
        BV bv=(BV)comboBureau.getSelectionModel().getSelectedItem();
        Long idBV=bv.getId();
        System.out.println(bv.getId()+"-"+bv.getLibelle());
    }
    
    @FXML
    private void  paysSelected(ActionEvent event){
        ComboBox combo=(ComboBox)event.getSource();
        Pays data=(Pays)combo.getSelectionModel().getSelectedItem();
        new ComboLoader<Region>().laodFromParent(new Region(), comboRegion, "pays.id", data.getId());
    }
    
     @FXML
    private void  regionSelected(ActionEvent event){
        ComboBox combo=(ComboBox)event.getSource();
        Region data=(Region)combo.getSelectionModel().getSelectedItem();        
       new ComboLoader<Departement>().laodFromParent(new Departement(), comboDepartement, "region.id", data.getId());
    }
    
     @FXML
    private void  departementSelected(ActionEvent event){
       ComboBox combo=(ComboBox)event.getSource();
       System.out.println(combo.getId());
        Departement data=(Departement)combo.getSelectionModel().getSelectedItem();    
        ModulePrefet.idCollectivite=data.getId();
      
    }
     
    @FXML
    private void  collectiviteSelected(ActionEvent event){
        ComboBox combo=(ComboBox)event.getSource();
        Collectivite data=(Collectivite)combo.getSelectionModel().getSelectedItem();        
      //  ModulePrefet.idCollectivite=data.getId();
        //new ComboLoader<Quartier>().laodFromParent(new Quartier(), comboQuartier, "collectivite.id",  data.getId());
        new ComboLoader<CV>().laodFromParent(new CV(), comboCentre, "collectivite.id",  data.getId());
    }
    
    @FXML
    private void chargeCollectivite(){
        new ComboLoader<Collectivite>().laodFromParent(new Collectivite(), comboCollectivite, "departement.id", ModulePrefet.idCollectivite);
    }
    
     @FXML
    private void  quartierSelected(ActionEvent event){
        ComboBox combo=(ComboBox)event.getSource();
        Quartier data=(Quartier)combo.getSelectionModel().getSelectedItem();        
       new ComboLoader<CV>().laodFromParent(new CV(), comboCentre, "quartier.id", data.getId());
    }
    
     @FXML
    private void  centreDeVoteSelected(ActionEvent event){
        ComboBox combo=(ComboBox)event.getSource();
        CV data=(CV)combo.getSelectionModel().getSelectedItem();        
       new ComboLoader<BV>().laodFromParent(new BV(), comboBureau, "cv.id", data.getId());
    }
    
     @FXML
    private void  bureauDeVoteSelected(ActionEvent event){
        ComboBox combo=(ComboBox)event.getSource();
        BV data=(BV)combo.getSelectionModel().getSelectedItem();        
       System.out.println("BV: "+data.getId()+" - "+data.getLibelle());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Crud.Crud;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.util.StringConverter;
import reporting.Data;
import reporting.Pays;
import reporting.Region;

/**
 *
 * @author super
 */
public class ComboLoader<T extends Data> {
   public void laod(T data,ComboBox<T> combo){
        try{
            
            //Alimenter le comboBox des pays
                List<T> lst = new Crud<T>().getAll(data);
             ObservableList<T> obs = FXCollections.observableArrayList(lst);
            combo.itemsProperty().setValue(obs);
            combo.setConverter(new StringConverter<T>() {

                @Override
                public String toString(T object) {
                    return object.getId() + "-" + object.getLibelle();
                }

                @Override
                public T fromString(String string) {
                    String[] vals = string.split("-");
                    data.setId(new Long(vals[1]));
                    data.setLibelle(vals[2]);
                    return data;
                }

            });
        }
        catch (NullPointerException e){}
   
   }
     public void laodFromParent(T data,ComboBox<T> combo,String parentId,Long parentValue){
        try{
            List<T> lst = new Crud<T>().getFromParent(data,parentId,parentValue);
        combo.getItems().clear();
        ObservableList<T> obs=FXCollections.observableList(lst);
        combo.itemsProperty().setValue(obs);
           
            combo.setConverter(new StringConverter<T>() {

                @Override
                public String toString(T object) {
                    return object.getId() + "-" + object.getLibelle();
                }

                @Override
                public T fromString(String string) {
                    String[] vals = string.split("-");
                    data.setId(new Long(vals[1]));
                    data.setLibelle(vals[2]);
                    return data;
                }

            });
        }
        catch (NullPointerException e){}
   
   }
}

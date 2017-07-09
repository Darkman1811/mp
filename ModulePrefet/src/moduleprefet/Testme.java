/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduleprefet;

import Crud.CrudPays;
import java.util.List;
import moduleprefet.metier.Crud;
import reporting.Pays;
import reporting.Region;

/**
 *
 * @author super
 */
public class Testme {
    public static void main (String[] args){
        System.out.println("dodo");
       CrudPays crudpays=new CrudPays();
       Pays pays=new Pays();
       pays.setLibelle("Mali");
       pays.setId(new Long(6));
       crudpays.supprimer(pays);
    }
}

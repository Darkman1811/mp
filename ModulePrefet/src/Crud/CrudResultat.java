/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import gestion.Resultat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import reporting.Pays;

/**
 *
 * @author super
 */
public class CrudResultat {
     EntityManager em;
    private Resultat data,worker;
    
    public CrudResultat(){
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("ModulePrefetPU");
    em=factory.createEntityManager();
    }
    
    
    
    public void ajouter(Resultat  data){
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();        
    }
    
    
       public void supprimer(Resultat data){
        em.getTransaction().begin();
        worker=em.find(Resultat.class, data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public Resultat get(Resultat data){
        em.getTransaction().begin();
        worker=(Resultat)em.find(Resultat.class, data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<Resultat> getAll(){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT D FROM Resultat D").getResultList();
        
        em.getTransaction().commit();
        return re;
    }
}

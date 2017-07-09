/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import reporting.Collectivite;
import reporting.Pays;

/**
 *
 * @author super
 */
public class CrudCollectivite {
      EntityManager em;
    private Collectivite data,worker;
    
    public CrudCollectivite(){
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("ModulePrefetPU");
    em=factory.createEntityManager();
    }
    
    
    
    public void ajouter(Collectivite  data){
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();        
    }
    
    
       public void supprimer(Collectivite data){
        em.getTransaction().begin();
        worker=em.find(Collectivite.class, data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public Collectivite get(Collectivite data){
        em.getTransaction().begin();
        worker=(Collectivite)em.find(Collectivite.class, data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<Collectivite> getAll(){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT D FROM Collectivite D").getResultList();
        
        em.getTransaction().commit();
        return re;
    }
}

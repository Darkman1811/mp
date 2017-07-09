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
import reporting.Election;
import reporting.Pays;

/**
 *
 * @author super
 */
public class CrudElection {
    EntityManager em;
    private Election data,worker;
    
    public CrudElection(){
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("ModulePrefetPU");
    em=factory.createEntityManager();
    }
    
    
    
    public void ajouter(Election  data){
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();        
    }
    
    
       public void supprimer(Election data){
        em.getTransaction().begin();
        worker=em.find(Election.class, data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public Election get(Election data){
        em.getTransaction().begin();
        worker=(Election)em.find(Election.class, data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<Election> getAll(){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT D FROM Election D").getResultList();
        
        em.getTransaction().commit();
        return re;
    }
}

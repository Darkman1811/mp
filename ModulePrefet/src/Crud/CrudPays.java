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
import reporting.Pays;

/**
 *
 * @author super
 */
public class CrudPays {
    EntityManager em;
    Pays worker;
    public CrudPays(){
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("ModulePrefetPU");
    em=factory.createEntityManager();
    }
    
    
    
    public void ajouter(Pays  data){
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();        
    }
    
    
       public void supprimer(Pays data){
        em.getTransaction().begin();
        worker=(Pays)em.find(Pays.class, data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public Pays get(Pays data){
        em.getTransaction().begin();
        worker=em.find(Pays.class,data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<Pays> getAll(){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT D FROM Pays D").getResultList();
        
        em.getTransaction().commit();
        return re;
    }
}

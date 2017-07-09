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
import reporting.CV;
import reporting.Pays;

/**
 *
 * @author super
 */
public class CrudCV {
        EntityManager em;
    private CV data,worker;
    
    public CrudCV(){
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("ModulePrefetPU");
    em=factory.createEntityManager();
    }
    
    
    
    public void ajouter(CV  data){
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();        
    }
    
    
       public void supprimer(CV data){
        em.getTransaction().begin();
        worker=em.find(CV.class, data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public CV get(CV data){
        em.getTransaction().begin();
        worker=(CV)em.find(CV.class, data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<CV> getAll(){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT D FROM CV D").getResultList();
        
        em.getTransaction().commit();
        return re;
    }
}

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
import reporting.Quartier;

/**
 *
 * @author super
 */
public class CrudQuartier {
        EntityManager em;
    private Quartier data,worker;
    
    public CrudQuartier(){
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("ModulePrefetPU");
    em=factory.createEntityManager();
    }
    
    
    
    public void ajouter(Quartier  data){
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();        
    }
    
    
       public void supprimer(Quartier data){
        em.getTransaction().begin();
        worker=em.find(Quartier.class, data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public Quartier get(Quartier data){
        em.getTransaction().begin();
        worker=(Quartier)em.find(Quartier.class, data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<Quartier> getAll(){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT D FROM Quartier D").getResultList();
        
        em.getTransaction().commit();
        return re;
    }
}

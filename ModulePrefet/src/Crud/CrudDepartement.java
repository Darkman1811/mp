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
import reporting.Departement;
import reporting.Pays;

/**
 *
 * @author super
 */
public class CrudDepartement {
      EntityManager em;
    private Departement data,worker;
    
    public CrudDepartement(){
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("ModulePrefetPU");
    em=factory.createEntityManager();
    }
    
    
    
    public void ajouter(Departement  data){
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();        
    }
    
    
       public void supprimer(Departement data){
        em.getTransaction().begin();
        worker=em.find(Departement.class, data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public Departement get(Departement data){
        em.getTransaction().begin();
        worker=(Departement)em.find(Departement.class, data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<Departement> getAll(){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT D FROM Departement D").getResultList();
        
        em.getTransaction().commit();
        return re;
    }
}
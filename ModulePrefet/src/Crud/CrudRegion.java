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
import reporting.Region;

/**
 *
 * @author super
 */
public class CrudRegion {
       EntityManager em;
    private Region data,worker;
    
    public CrudRegion(){
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("ModulePrefetPU");
    em=factory.createEntityManager();
    }
    
    
    
    public void ajouter(Region  data){
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();        
    }
    
    
       public void supprimer(Region data){
        em.getTransaction().begin();
        worker=em.find(Region.class, data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public Region get(Region data){
        em.getTransaction().begin();
        worker=(Region)em.find(Region.class, data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<Region> getAll(){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT D FROM Region D").getResultList();
        
        em.getTransaction().commit();
        return re;
    }
         
       public List<Region> getAll(Long IdPays){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT D FROM Region D where D.pays.id= "+IdPays).getResultList();
        
        em.getTransaction().commit();
        return re;
    }
}

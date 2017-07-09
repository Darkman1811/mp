/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduleprefet.metier;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import reporting.Data;
import reporting.Pays;



/**
 *
 * @author super
 */
public class Crud <T extends Data>{
    EntityManager em;
    private T data,worker;
    
    public Crud(){
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("ModulePrefetPU");
    em=factory.createEntityManager();
    }
    
    
    
    public void ajouter(T  data){
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();        
    }
    
    
       public void supprimer(T data){
        em.getTransaction().begin();
        worker=(T)em.find(data.getClass(), data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public T get(T data){
        em.getTransaction().begin();
        worker=(T)em.find(data.getClass(), data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<T> getAll(){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT R FROM Region R").getResultList();
        
        em.getTransaction().commit();
        return re;
    }
    
    
}

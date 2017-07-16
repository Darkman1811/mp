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
import reporting.Data;
import reporting.Pays;

/**
 *
 * @author super
 */
public class CrudPays <T extends Data>{
    EntityManager em;
    T worker;
    public CrudPays(){
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
        worker=(T)em.find(worker.getClass(), data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public T get(T data){
        em.getTransaction().begin();
        worker=(T)em.find(worker.getClass(),data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<T> getAll(T data){
        em.getTransaction().begin();
         
       String sql="SELECT D FROM "+data.getClass().getSimpleName()+" D";
       System.out.println(sql);
        List re=em.createQuery(sql).getResultList();
        
        em.getTransaction().commit();
        return re;
    }
       
       
}

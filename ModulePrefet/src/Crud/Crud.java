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
import reporting.Region;

/**
 *
 * @author super
 */
public class Crud <T extends Data>{
    EntityManager em;
    T worker;
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
        List re=em.createQuery(sql).getResultList();        
        em.getTransaction().commit();
        return re;
    }
       
        public List<T> getFromParent(T data,String parentId,Long parentValue){
        em.getTransaction().begin();         
       String sql="SELECT D FROM "+data.getClass().getSimpleName()+" D where D."+parentId+"="+parentValue;
        
      // String sql="SELECT D FROM Region D where D.pays.id=3";
      //  System.out.println(sql);
        List re=em.createQuery(sql,data.getClass()).getResultList();        
        em.getTransaction().commit();
        return re;
    }
       
       
}

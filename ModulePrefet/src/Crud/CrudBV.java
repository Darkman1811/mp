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
import reporting.BV;
import reporting.Data;
import reporting.Pays;

/**
 *
 * @author super
 */
public class CrudBV {
       EntityManager em;
    private BV data,worker;
    
    public CrudBV(){
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("ModulePrefetPU");
    em=factory.createEntityManager();
    }
    
    
    
    public void ajouter(BV  data){
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();        
    }
    
    
       public void supprimer(BV data){
        em.getTransaction().begin();
        worker=em.find(BV.class, data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public BV get(BV data){
        em.getTransaction().begin();
        worker=(BV)em.find(BV.class, data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<BV> getAll(){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT D FROM BV D").getResultList();
        
        em.getTransaction().commit();
        return re;
    }

   
}

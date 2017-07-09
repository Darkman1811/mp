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
import reporting.Parti;
import reporting.Pays;

/**
 *
 * @author super
 */
public class CrudParti {
       EntityManager em;
    private Parti data,worker;
    
    public CrudParti(){
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("ModulePrefetPU");
    em=factory.createEntityManager();
    }
    
    
    
    public void ajouter(Parti  data){
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();        
    }
    
    
       public void supprimer(Parti data){
        em.getTransaction().begin();
        worker=em.find(Parti.class, data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public Parti get(Parti data){
        em.getTransaction().begin();
        worker=(Parti)em.find(Parti.class, data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<Parti> getAll(){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT D FROM Parti D").getResultList();
        
        em.getTransaction().commit();
        return re;
    }
}

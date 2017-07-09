/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import gestion.Score;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import reporting.Pays;

/**
 *
 * @author super
 */
public class CrudScore {
        EntityManager em;
    private Score data,worker;
    
    public CrudScore(){
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("ModulePrefetPU");
    em=factory.createEntityManager();
    }
    
    
    
    public void ajouter(Score  data){
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();        
    }
    
    
       public void supprimer(Score data){
        em.getTransaction().begin();
        worker=em.find(Score.class, data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public Score get(Score data){
        em.getTransaction().begin();
        worker=(Score)em.find(Score.class, data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<Score> getAll(){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT D FROM Score D").getResultList();
        
        em.getTransaction().commit();
        return re;
    }
}

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
import reporting.Contact;
import reporting.Pays;

/**
 *
 * @author super
 */
public class CrudContact {
    EntityManager em;
    private Contact data,worker;
    
    public CrudContact(){
    EntityManagerFactory factory= Persistence.createEntityManagerFactory("ModulePrefetPU");
    em=factory.createEntityManager();
    }
    
    
    
    public void ajouter(Contact  data){
        em.getTransaction().begin();
        em.persist(data);
        em.getTransaction().commit();        
    }
    
    
       public void supprimer(Contact data){
        em.getTransaction().begin();
        worker=em.find(Contact.class, data.getId());
        em.remove(worker);
        em.flush();
        em.getTransaction().commit();        
    }
    
       public Contact get(Contact data){
        em.getTransaction().begin();
        worker=(Contact)em.find(Contact.class, data.getId() );
        em.getTransaction().commit();        
        return worker;
    }
       
       public List<Contact> getAll(){
        em.getTransaction().begin();
       
        List re=em.createQuery("SELECT D FROM Contact D").getResultList();
        
        em.getTransaction().commit();
        return re;
    }
}

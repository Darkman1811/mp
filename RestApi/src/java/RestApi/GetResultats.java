/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestApi;

import gestion.Resultat;
import gestion.Score;
import java.util.Iterator;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import redis.clients.jedis.Jedis;
import reporting.Contact;

/**
 *
 * @author super
 */

@Path("/resultats")
//WebService(serviceName = "SoapApi")
@Stateless
public class GetResultats {
    @PersistenceContext 
    EntityManager em;
     
    @POST
    @Path("/save")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_XML)
    public String save( Resultat resultat){
        
       String ret=" - "+resultat.getBv().getLibelle();
        
        System.out.println("server:"+ret);
        Iterator it=resultat.getScore().iterator();
        while(it.hasNext()){
            Score score=(Score)it.next();
            System.out.println(score.getNb_voix());
        }

        Resultat res= new Resultat();
        res.setBv(resultat.getBv());
        res.setScore(resultat.getScore());
       
        em.persist(res);
        Iterator it2=res.getBv().getContacts().iterator();
        while(it2.hasNext()){
            Contact contact=(Contact)it2.next();
            System.out.println(contact.getNom());
        }
        
          em.merge(res.getBv());
         saveToRedis(res);
        
        return ret;
    }
    
    private void saveToRedis(Resultat resultat){
          Jedis jedis= new Jedis("172.17.0.4",6379); 
        //jedis.auth("scorpio");
        
        System.out.println("Server ping: "+jedis.ping());
        jedis.lpush("key1", "hello1");
       System.out.println(jedis.lrange("key1", 0, -1));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import gestion.Resultat;
import gestion.Score;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
/**
 *
 * @author super
 */
public class SenderRest {
    public static String sendToServer(Resultat resultat){
        Client client = ClientBuilder.newClient();
       /* Response response=client.target("http://localhost:8080/RestApi/rs/").path("resultats").path("save").request().get();
        String resp=response.readEntity(String.class);*/
        URI uri=UriBuilder.fromUri("http://localhost:8080/RestApi/rs/").path("resultats").path("save").build();
       // Resultat resultat= new Resultat();
        //resultat.setId(new Long(1));
        System.out.println(resultat.getBv().getLibelle());
        resultat.getScore().stream().forEach((Score score)->{
            System.out.println(score.getId()+" - "+score.getNb_voix());
        });
        Response response=client.target(uri).request(MediaType.TEXT_PLAIN).post(Entity.xml(resultat));
        String resp=response.readEntity(String.class);
        return resp;
    }
}

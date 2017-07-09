/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author super
 */
@Entity
public class Score {
    @Id
    private Long id;
    private Long nb_voix;
    @ManyToOne
    private Resultat resultat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNb_voix() {
        return nb_voix;
    }

    public void setNb_voix(Long nb_voix) {
        this.nb_voix = nb_voix;
    }
    
    
    
}

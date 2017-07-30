/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import reporting.Parti;

/**
 *
 * @author super
 */
@Entity
@XmlRootElement
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long nb_voix;
    @ManyToOne
    @XmlTransient
    private Resultat resultat;
    @ManyToOne
    private Parti parti;

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
    
    @XmlTransient
    public Resultat getResultat() {
        return resultat;
    }

    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }

    public Parti getParti() {
        return parti;
    }

    public void setParti(Parti parti) {
        this.parti = parti;
    }

    public Score() {
    }

    public Score(Long nb_voix, Resultat resultat,Parti parti) {
        this.nb_voix = nb_voix;
        this.resultat = resultat;
        this.parti=parti;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import reporting.BV;
import reporting.Election;
import reporting.Parti;

/**
 *
 * @author super
 */
@Entity
public class Resultat {
    @Id
    private Long id;
    private String date;
    private String heure;
    private Boolean etat;
    @OneToOne
    private BV bv;
    @OneToMany
    private List <Score> score;
    @ManyToOne
    private Election election;
    @ManyToOne
    private Parti parti;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
    
}

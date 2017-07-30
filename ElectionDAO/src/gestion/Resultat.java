/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import reporting.BV;
import reporting.Parti;

/**
 *
 * @author super
 */
@Entity
@XmlRootElement
public class Resultat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String heure;
    private Integer etat;
    @OneToOne(cascade = CascadeType.MERGE)
    private BV bv;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List <Score> score;
    
    
    
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

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public BV getBv() {
        return bv;
    }

    public void setBv(BV bv) {
        this.bv = bv;
    }

    public List<Score> getScore() {
        return score;
    }

    public void setScore(List<Score> score) {
        this.score = score;
    }
    
      public Resultat() {
    }

    public Resultat(String date, String heure, Integer etat, BV bv, List<Score> score) {
        this.date = date;
        this.heure = heure;
        this.etat = etat;
        this.bv = bv;
        this.score = score;
    }
}

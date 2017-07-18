/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author super
 */
@Entity
public class Collectivite implements Data{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    @ManyToOne
    private Departement departement;
    @OneToMany(mappedBy = "collectivite")
    private List<Quartier> quartier;
    @OneToMany(mappedBy = "collectivite")
    private List<CV> cv;            

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Quartier> getQuartier() {
        return quartier;
    }

    public void setQuartier(List<Quartier> quartier) {
        this.quartier = quartier;
    }

    public List<CV> getCv() {
        return cv;
    }

    public void setCv(List<CV> cv) {
        this.cv = cv;
    }
    
    
    
}

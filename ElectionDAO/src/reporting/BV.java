/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting;

import gestion.Resultat;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
/**
 *
 * @author super
 */
@Entity
public class BV {
    @Id
    private Long id;
    private String libelle;
    @ManyToOne
    private CV cv;
    @OneToOne
    private Resultat resultat;
    @OneToMany(mappedBy = "bv")
    private List <Contact> contacts;
    

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
    
    
    
}

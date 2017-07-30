/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author super
 */
@Entity
@XmlRootElement
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Prenom;
    private String nom;
    private String telephone;
    private String email;
    @ManyToOne(cascade = CascadeType.ALL)
    @XmlTransient
    private BV bv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @XmlTransient
    public BV getBv() {
        return bv;
    }

    public void setBv(BV bv) {
        this.bv = bv;
    }

    public Contact() {
    }

    public Contact(String Prenom, String nom, String telephone, String email, BV bv) {
        this.Prenom = Prenom;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.bv = bv;
    }
    
}

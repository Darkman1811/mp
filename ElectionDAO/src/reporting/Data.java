/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting;

/**
 *
 * @author super
 */
public interface Data {
    public Long getId();
    public String getLibelle();
    
    public void setId(Long id);
    public void setLibelle(String libelle);
}

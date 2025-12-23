package com.recette.model;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Classe représentant une recette
 */
@XmlRootElement(name = "recette")
@XmlAccessorType(XmlAccessType.FIELD)
public class Recette implements Serializable {
    
    private int idRecette;
    private String nomRecette;
    private String description;
    
    // Constructeur par défaut
    public Recette() {
    }
    
    // Constructeur avec paramètres
    public Recette(int idRecette, String nomRecette, String description) {
        this.idRecette = idRecette;
        this.nomRecette = nomRecette;
        this.description = description;
    }
    
    // Getters et Setters
    public int getIdRecette() {
        return idRecette;
    }
    
    public void setIdRecette(int idRecette) {
        this.idRecette = idRecette;
    }
    
    public String getNomRecette() {
        return nomRecette;
    }
    
    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Recette{" +
                "idRecette=" + idRecette +
                ", nomRecette='" + nomRecette + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
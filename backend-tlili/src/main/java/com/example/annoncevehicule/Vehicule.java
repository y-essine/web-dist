package com.example.annoncevehicule;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Vehicule implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String marque;
    private String modele;
    private String immatriculation;
    private String couleur;
    private int place;
    private float prixParJour;
    private Boolean disponibilite;

    public Vehicule() {
    }

    public int getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getPlace() {
        return place;
    }

    public float getPrixParJour() {
        return prixParJour;
    }

    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setPrixParJour(float prixParJour) {
        this.prixParJour = prixParJour;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Vehicule(int id, String marque, String modele, String immatriculation, String couleur, int place, float prixParJour, Boolean disponibilite) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.immatriculation = immatriculation;
        this.couleur = couleur;
        this.place = place;
        this.prixParJour = prixParJour;
        this.disponibilite = disponibilite;
    }
}

package com.sio.arbimatch.classe;

import android.support.v7.appcompat.R;

/**
 * Created by jrinquepach on 27/11/13.
 */
public class Joueur {
    private int id;
    private String nom;
    private String prenom;
    private boolean titre;

    public Joueur(){

    }

    public Joueur(int id, String nom, String prenom, boolean titre) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.titre = titre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean getTitre() {
        return titre;
    }

    public void setTitre(boolean titre) {
        this.titre = titre;
    }

    public String toString(){
        return (" " + this.getNom() + " "+ this.getPrenom() + "");
    }

    public String ligneTableau(){
        return ( this.getNom() + " "+ this.getPrenom());
    }

}


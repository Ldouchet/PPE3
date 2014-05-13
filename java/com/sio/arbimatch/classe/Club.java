package com.sio.arbimatch.classe;

import java.util.ArrayList;

/**
 * Created by jrinquepach on 27/11/13.
 */
public class Club {
    private int id;
    private String nom;

    private ArrayList<Joueur> listeJoueur;

    // des collections pour gérer les titulaires et remplacants
    private ArrayList<Joueur> lesTitulaires;
    private ArrayList<Joueur> lesRemplacants;

    public Club(int id , String nom){
        this.id = id;
        this.nom = nom;
        listeJoueur = new ArrayList<Joueur>();
        lesRemplacants = new ArrayList<Joueur>();
        lesTitulaires = new ArrayList<Joueur>();
    }

    public void ajouterJoueur(Joueur j){
        this.listeJoueur.add(j);
    }

    public void ajouterTitulaire(Joueur j){
        this.lesTitulaires.add(j);
    }
    public void ajouterRemplacant(Joueur j){
        this.lesRemplacants.add(j);
    }

    public void setListeJoueur(ArrayList<Joueur> listeJoueur) {
        this.listeJoueur = listeJoueur;
    }

    public ArrayList<Joueur> getLesTitulaires() {
        return lesTitulaires;
    }

    public void setLesTitulaires(ArrayList<Joueur> lesTitulaires) {
        this.lesTitulaires = lesTitulaires;
    }

    public ArrayList<Joueur> getLesRemplacants() {
        return lesRemplacants;
    }

    public void setLesRemplacants(ArrayList<Joueur> lesRemplacants) {
        this.lesRemplacants = lesRemplacants;
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

    public ArrayList<Joueur> getListeJoueur() {
        return listeJoueur;
    }

    public void setListeJoueurc1(ArrayList<Joueur> listeJoueur) {
        this.listeJoueur = listeJoueur;
    }
}



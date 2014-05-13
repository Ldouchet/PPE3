package com.sio.arbimatch.classe;

/**
 * Created by jrinquepach on 27/11/13.
 */
public class Carton {
    private String couleur;
    private Joueur joueurConcerne;
    private int temps;

    public Carton(String couleur, Joueur joueurConcerne, int temps) {
        this.couleur = couleur;
        this.joueurConcerne = joueurConcerne;
        this.temps = temps;
    }

    public Carton(){}

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }
    public Joueur getJoueurConcerne() {
        return joueurConcerne;
    }

    public void setJoueurConcerne(Joueur joueurConcerne) {
        this.joueurConcerne = joueurConcerne;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String ligneTableau(){
        return ( this.getJoueurConcerne() + " à "+ this.getTemps() + "ème " + this.getCouleur());
    }
}

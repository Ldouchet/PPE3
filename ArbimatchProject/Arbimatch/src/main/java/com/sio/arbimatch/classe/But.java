package com.sio.arbimatch.classe;

/**
 * Created by jrinquepach on 05/12/13.
 */
public class But {

    private int temps ;
    private Joueur joueurConcerne;

    public But() {
    }

    public Joueur getJoueurConcerne() {
        return joueurConcerne;
    }

    public void setJoueurConcerne(Joueur joueurConcerne) {
        this.joueurConcerne = joueurConcerne;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public String ligneTableau(){
        return ( "But de " + this.getJoueurConcerne() + " à "+ this.getTemps());
    }

    public String toString(){
        return ( + this.getTemps() + "ème "+ this.getJoueurConcerne());
    }
}

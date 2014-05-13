package com.sio.arbimatch.classe;

/**
 * Created by Vampire on 14/12/13.
 */
public class Remplacement {
    private Joueur J1;
    private Joueur J2;
    private int temps ;

    public Remplacement(Joueur j1, Joueur j2, int temps) {
        J1 = j1;
        J2 = j2;
        this.temps = temps;
    }

    public Remplacement(){

    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public Joueur getJ1() {
        return J1;
    }

    public void setJ1(Joueur j1) {
        J1 = j1;
    }

    public Joueur getJ2() {
        return J2;
    }

    public void setJ2(Joueur j2) {
        J2 = j2;
    }

    public String ligneTableau(){
        return ( this.getJ1() + "Remplacé par "+ this.getJ2() + " à " + this.getTemps()+"");
    }
}

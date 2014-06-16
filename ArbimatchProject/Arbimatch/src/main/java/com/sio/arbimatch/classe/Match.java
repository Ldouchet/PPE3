package com.sio.arbimatch.classe;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jrinquepach on 27/11/13.
 */
public class Match {
    private String date;
    private int id;

    private Club c1;
    private Club c2;

    private ArrayList<But> les_buts;
    private ArrayList<But> les_buts2;
    private ArrayList<Carton> les_cartons;
    private ArrayList<Remplacement> les_remplacements;


    public Match(String date, int id, Club c1, Club c2, ArrayList<But> les_buts, ArrayList<But> les_buts2, ArrayList<Carton> les_cartons) {
        this.date = date;
        this.id = id;
        this.c1 = c1;
        this.c2 = c2;
        this.les_buts = les_buts;
        this.les_buts2 = les_buts2;
        this.les_cartons = les_cartons;
        this.les_buts = new ArrayList<But>();
        this.les_buts2 = new ArrayList<But>();
        this.les_cartons = new ArrayList<Carton>();
        this.les_remplacements= new ArrayList<Remplacement>();
    }



    public Match(){
        this.les_buts = new ArrayList<But>();

        this.les_buts2 = new ArrayList<But>();
        this.les_cartons = new ArrayList<Carton>();
        this.les_remplacements= new ArrayList<Remplacement>();
    }


    public ArrayList<Remplacement> getLes_remplacements() {
        return les_remplacements;
    }

    public void setLes_remplacements(ArrayList<Remplacement> les_remplacements) {
        this.les_remplacements = les_remplacements;
    }

    public ArrayList<But> getLes_buts2() {
        return les_buts2;
    }

    public void setLes_buts2(ArrayList<But> les_buts2) {
        this.les_buts2 = les_buts2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Club getC1() {
        return c1;
    }

    public void setC1(Club c1) {
        this.c1 = c1;
    }

    public Club getC2() {
        return c2;
    }

    public void setC2(Club c2) {
        this.c2 = c2;
    }

    public ArrayList<Carton> getLes_cartons() {
        return les_cartons;
    }

    public void setLes_cartons(ArrayList<Carton> les_cartons) {
        this.les_cartons = les_cartons;
    }

    public ArrayList<But> getLes_buts() {
        return les_buts;
    }

    public void setLes_buts(ArrayList<But> les_buts) {
        this.les_buts = les_buts;
    }


    public void ajouterCarton(Carton c){
        this.les_cartons.add(c);
    }

    public void ajouterBut(But b){
        this.les_buts.add(b);
    }

    public void ajouterBut2(But b){
        this.les_buts2.add(b);
    }

    public void ajouterRemplacement(Remplacement R){
        this.les_remplacements.add(R);
    }

    // On prépare le match avec un jeu d'essai de joueur et de club

    public void preparerMatch(String codeMatch){
        // Création d'un jeu d'essai
        this.c1 = new Club (1,"Loyk");
        this.c2 = new Club (2,"Guy");

        Joueur J1C1 = new Joueur(1,"dark","souls",true);
        Joueur J2C1 = new Joueur(2,"LeConqurant","Guy",true);
        Joueur J3C1 = new Joueur(3,"Pedro","Pinto",true);
        Joueur J4C1 = new Joueur(4,"Loïc","Vampire",false);
        Joueur J5C1 = new Joueur(5,"El","Cassoulet",false);

        c1.ajouterTitulaire(J1C1);
        c1.ajouterTitulaire(J2C1);
        c1.ajouterTitulaire(J3C1);
        c1.ajouterRemplacant(J4C1);
        c1.ajouterRemplacant(J5C1);

        Joueur J1C2 = new Joueur(6,"Eric","Cartman",false);
        Joueur J2C2 = new Joueur(7,"Butters","Blond",true);
        Joueur J3C2 = new Joueur(8,"Oncle","Ginno",true);
        Joueur J4C2 = new Joueur(9,"Luigi","Elpizzayolo",true);
        Joueur J5C2 = new Joueur(10,"Bruce","Leeberty",false);

        c2.ajouterTitulaire(J1C2);
        c2.ajouterRemplacant(J2C2);
        c2.ajouterTitulaire(J3C2);
        c2.ajouterTitulaire(J4C2);
        c2.ajouterRemplacant(J5C2);
    }





}

package com.sio.arbimatch;

import com.sio.arbimatch.classe.Joueur;

/**
 * Created by Vampire on 15/12/13.
 */
public class ListeJoueurR_T_2 {

    public static String[] versTableau(){
        String[] resu = new String[MatchingActivity.le_match.getC2().getLesTitulaires().size()];
        int i = 0;
        for(Joueur j  : MatchingActivity.le_match.getC2().getLesTitulaires()){
            resu[i] = j.ligneTableau();
            i++;
        }
        return resu;
    }
}

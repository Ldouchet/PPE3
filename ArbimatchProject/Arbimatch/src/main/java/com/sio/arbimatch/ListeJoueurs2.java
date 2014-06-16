package com.sio.arbimatch;

import com.sio.arbimatch.classe.Joueur;

/**
 * Created by jrinquepach on 06/12/13.
 */
public class ListeJoueurs2 {

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

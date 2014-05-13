package com.sio.arbimatch;

import com.sio.arbimatch.classe.Joueur;
import com.sio.arbimatch.classe.Club;
import com.sio.arbimatch.classe.Match;

import java.util.ArrayList;

/**
 * Created by jrinquepach on 06/12/13.
 */
public class ListeJoueurs {

        public static String[] versTableau(){
            String[] resu = new String[MatchingActivity.le_match.getC1().getLesTitulaires().size()];
            int i = 0;
            for(Joueur j  : MatchingActivity.le_match.getC1().getLesTitulaires()){
                resu[i] = j.ligneTableau();
                i++;
            }
            return resu;
        }
    }



package com.sio.arbimatch;

import com.sio.arbimatch.classe.Carton;
import com.sio.arbimatch.classe.Joueur;

/**
 * Created by jrinquepach on 11/12/13.
 */
public class ListeCarton {

    public static String[] versTableau(){
        String[] resu = new String[MatchingActivity.le_match.getLes_cartons().size()];
        int i = 0;
        for(Carton c  : MatchingActivity.le_match.getLes_cartons()){
            resu[i] = c.ligneTableau();
            i++;
        }
        return resu;
    }
}

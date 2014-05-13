package com.sio.arbimatch;

import com.sio.arbimatch.classe.Carton;
import com.sio.arbimatch.classe.Remplacement;

/**
 * Created by Vampire on 15/12/13.
 */
public class ListeRemplacement {
    public static String[] versTableau(){
        String[] resu = new String[MatchingActivity.le_match.getLes_remplacements().size()];
        int i = 0;
        for(Remplacement r  : MatchingActivity.le_match.getLes_remplacements()){
            resu[i] = r.ligneTableau();
            i++;
        }
        return resu;
    }
}

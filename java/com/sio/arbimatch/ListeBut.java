package com.sio.arbimatch;

import com.sio.arbimatch.classe.But;

/**
 * Created by jrinquepach on 11/12/13.
 */
public class ListeBut {

    public static String[] versTableau(){

        String[] resu = new String[MatchingActivity.le_match.getLes_buts().size()+MatchingActivity.le_match.getLes_buts2().size()];
        int i = 0;
        for(But b  : MatchingActivity.le_match.getLes_buts()){
            resu[i] = b.ligneTableau();
            i++;
        }
        i = 0;
        for(But b  : MatchingActivity.le_match.getLes_buts2()){
            resu[i] = b.ligneTableau();
            i++;
        }

        return resu;
    }
}

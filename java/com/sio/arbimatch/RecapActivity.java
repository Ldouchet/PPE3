package com.sio.arbimatch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.sio.arbimatch.classe.But;

import java.util.ArrayList;

/**
 * Created by jrinquepach on 11/12/13.
 */
public class RecapActivity extends Activity {

    private ArrayList<But> lesbuts1;
    private ArrayList<But> lesbuts2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recap);


        TextView nomequipe1 = (TextView) findViewById(R.id.tv_equipe1);
        nomequipe1.setText(MatchingActivity.le_match.getC1().getNom());

        TextView nomequipe2 = (TextView) findViewById(R.id.tv_equipe2);
        nomequipe2.setText(MatchingActivity.le_match.getC2().getNom());

        TextView nombrebut = (TextView) findViewById(R.id.tv_nb_but1);
        lesbuts1 = (MatchingActivity.le_match.getLes_buts());
        nombrebut.setText("Nombre de buts : " + lesbuts1.size());

        TextView nombrebut2 = (TextView) findViewById(R.id.tv_nb_but2);
        lesbuts2 = (MatchingActivity.le_match.getLes_buts2());
        nombrebut2.setText("Nombre de buts : " + lesbuts2.size());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListeBut.versTableau());
        ListView listebut = (ListView) findViewById(R.id.liste_but);
        listebut.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListeCarton.versTableau());
        ListView listecarton = (ListView) findViewById(R.id.liste_carton);
        listecarton.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListeRemplacement.versTableau());
        ListView listeremplacement = (ListView) findViewById(R.id.list_remplacement);
        listeremplacement.setAdapter(adapter2);

    }
}

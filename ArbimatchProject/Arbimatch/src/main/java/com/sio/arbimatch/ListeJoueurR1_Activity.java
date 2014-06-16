package com.sio.arbimatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.sio.arbimatch.classe.But;
import com.sio.arbimatch.classe.Club;
import com.sio.arbimatch.classe.Joueur;
import com.sio.arbimatch.classe.Remplacement;

/**
 * Created by Vampire on 15/12/13.
 */
public class ListeJoueurR1_Activity extends Activity {
    private int positionJ1;
    private int positionJ2;
    Remplacement R1 = new Remplacement();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listejoueurremplacant);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListeJoueurR_T_1.versTableau());
        ListView list = (ListView)findViewById(R.id.liste_joueur);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                positionJ1 = position;
                Joueur leJoueur =  MatchingActivity.le_match.getC1().getLesTitulaires().get(positionJ1);

                R1.setJ1(leJoueur);
                Club C = MatchingActivity.le_match.getC1();
                C.ajouterRemplacant(leJoueur);
                MatchingActivity.le_match.getC1().getLesTitulaires().remove(positionJ1);
            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ListeJoueurR_R_1.versTableau());
        ListView list2 = (ListView)findViewById(R.id.list_joueur_R);
        list2.setAdapter(adapter2);

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                positionJ2 = position;
                Joueur leJoueur2 =  MatchingActivity.le_match.getC1().getLesRemplacants().get(positionJ2);

                R1.setJ2(leJoueur2);
                R1.setTemps(DetailJoueurActivity.temps_actuel);

                Club C = MatchingActivity.le_match.getC1();
                C.ajouterTitulaire(leJoueur2);
                MatchingActivity.le_match.getC1().getLesRemplacants().remove(positionJ2);
            }
        });

        Button Remplacement = (Button) findViewById(R.id.bt_remplacement);

        Remplacement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                MatchingActivity.le_match.ajouterRemplacement(R1);
                ListeJoueurR1_Activity.this.finish();
            }
        });
    }


}

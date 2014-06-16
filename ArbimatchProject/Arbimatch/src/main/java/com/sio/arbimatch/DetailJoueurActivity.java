package com.sio.arbimatch;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sio.arbimatch.classe.But;
import com.sio.arbimatch.classe.Carton;
import com.sio.arbimatch.classe.Joueur;
import com.sio.arbimatch.classe.Match;

import java.util.ArrayList;

/**
 * Created by jrinquepach on 06/12/13.
 */
    public class DetailJoueurActivity extends Activity {
        // le temps actuel est utilisé pour récupérer le temps actuel du chrono
        public static int temps_actuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_joueur);

        // on récupère la position du joueur
        int position = this.getIntent().getIntExtra("positionJoueur",-1);
        final Joueur leJoueur =  MatchingActivity.le_match.getC1().getLesTitulaires().get(position);

        String le_nom = leJoueur.getNom();
        String le_prenom = leJoueur.getPrenom();
        TextView nom_joueur = (TextView) findViewById(R.id.nom_joueur);
        nom_joueur.setText(le_nom + " " + le_prenom , TextView.BufferType.EDITABLE);


        // Bouton pour ajouter un carton jaune

        Button jaune = (Button) findViewById(R.id.b_carton_j);

        jaune.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Carton carton = new Carton();
                carton.setCouleur("jaune");
                carton.setJoueurConcerne(leJoueur);
                carton.setTemps(DetailJoueurActivity.temps_actuel);
                MatchingActivity.le_match.ajouterCarton(carton);
                DetailJoueurActivity.this.finish();
            }
        });

        // Bouton pour ajouter un carton rouge

        Button rouge = (Button) findViewById(R.id.b_carton_r);

            rouge.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Carton carton = new Carton();
                    carton.setCouleur("rouge");
                    carton.setJoueurConcerne(leJoueur);
                    carton.setTemps(DetailJoueurActivity.temps_actuel);
                    MatchingActivity.le_match.ajouterCarton(carton);
                    DetailJoueurActivity.this.finish();
                }
            });

        // Bouton pour ajouter un but

        Button but = (Button) findViewById(R.id.b_but);

        but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                But but = new But();
                but.setJoueurConcerne(leJoueur);
                but.setTemps(DetailJoueurActivity.temps_actuel);
                MatchingActivity.le_match.ajouterBut(but);
                DetailJoueurActivity.this.finish();
            }
        });
    }
}

package com.sio.arbimatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Vampire on 15/12/13.
 */
public class Choix_equipeR extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichageclub);

        // Affichage du nom de la première équipe
        TextView tv_1 = (TextView) findViewById(R.id.textView2);
        tv_1.setText(MatchingActivity.le_match.getC1().getNom());

        // Affichage du nom de la deuxième équipe
        TextView tv_2 = (TextView) findViewById(R.id.textView3);
        tv_2.setText(MatchingActivity.le_match.getC2().getNom());


        // Afficher liste équipe 1 -> la liste de la première équipe
        Button equipe1 = (Button) findViewById(R.id.bt_equipe1);

        equipe1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Choix_equipeR.this, "...", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Choix_equipeR.this, ListeJoueurR1_Activity.class);
                startActivityForResult(i, 1);
                Choix_equipeR.this.finish();
            }
        } );


        // Afficher liste équipe 2 -> la liste de la deuxième équipe
        Button equipe2 = (Button) findViewById(R.id.bt_equipe2);

        equipe2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Choix_equipeR.this, "...", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Choix_equipeR.this, ListeJoueurR2_Activity.class);
                startActivityForResult(i, 1);
                Choix_equipeR.this.finish();
            }
        } );

    }
}

package com.sio.arbimatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sio.arbimatch.classe.Club;
import com.sio.arbimatch.classe.Joueur;
import com.sio.arbimatch.classe.Match;

/**
 * Created by jrinquepach on 27/11/13.
 */
public class SaisirMatchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saisirmatch);


    Button button = (Button) findViewById(R.id.b_valider_equipe);


        // Le code FFF aura pour but au final d'être utiliser avec une base de données

    button.setOnClickListener(new View.OnClickListener()
    {
        public void onClick(View v)
        {
            String numeroMatch =""+((EditText) findViewById(R.id.Et_codeMatch)).getText();

            Match leMatch = new Match();
            leMatch.preparerMatch(numeroMatch);
            MatchingActivity.le_match = leMatch;

            Toast.makeText(SaisirMatchActivity.this, "....", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(SaisirMatchActivity.this, MatchingActivity.class);
            startActivityForResult(i,1);

        }
    });
    }
}

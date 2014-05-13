package com.sio.arbimatch;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.Toast;
import android.media.MediaPlayer;

import com.sio.arbimatch.classe.Joueur;

import java.util.ArrayList;

public class MainActivity extends Activity {

    // On crée un objet MediaPlayer pour le sifflet
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
        //-------------------------Bouton Sifflet
        Button siffle = (Button) findViewById(R.id.sifflet);
        siffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player=MediaPlayer.create(MainActivity.this,R.raw.sifflet);
                player.start();
            }
        });

        //--------------------------Bouton Commencer match pour arriver sur l'activité saisirmatch
        Button button = (Button) findViewById(R.id.commencerM);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, SaisirMatchActivity.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

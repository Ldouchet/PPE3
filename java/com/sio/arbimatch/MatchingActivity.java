package com.sio.arbimatch;

/**
 * Created by jrinquepach on 04/12/13.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.sio.arbimatch.SQL.ButDAO;
import com.sio.arbimatch.SQL.CartonDAO;
import com.sio.arbimatch.SQL.ClubDAO;
import com.sio.arbimatch.SQL.JoueurDAO;
import com.sio.arbimatch.SQL.MatchDAO;
import com.sio.arbimatch.SQL.jouerDAO;
import com.sio.arbimatch.classe.Club;
import com.sio.arbimatch.classe.Joueur;
import com.sio.arbimatch.classe.Match;
import com.sio.arbimatch.classe.But;
import com.sio.arbimatch.classe.Carton;
import com.sio.arbimatch.classe.Remplacement;

public class MatchingActivity extends Activity implements Chronometer.OnChronometerTickListener {

    public static Match le_match;
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debutrencontre);

        //----------------------------------Bouton Sifflet
        Button siffle = (Button) findViewById(R.id.sifflet);
        siffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player=MediaPlayer.create(MatchingActivity.this,R.raw.sifflet);
                player.start();
            }
        });


        TextView tv_oppo = (TextView) findViewById(R.id.tv_versus);
        tv_oppo.setText(MatchingActivity.le_match.getC1().getNom() + " VS " + MatchingActivity.le_match.getC2().getNom());

        //--------------------------------- Bouton Donner carton
        Button Carton = (Button) findViewById(R.id.donnercarton);

        Carton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Chronometer c = ((Chronometer) findViewById(R.id.chronometer));
                DetailJoueurActivity.temps_actuel = (Integer.parseInt(c.getText().toString().substring(0,2)));
                Log.i("INFO ********************************", ""+DetailJoueurActivity.temps_actuel);
                Toast.makeText(MatchingActivity.this, "...", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MatchingActivity.this, AffichageClubActivity.class);
                startActivityForResult(i, 1);
            }
        });


        // ------------------------------- Bouton Attribuer But
        Button But = (Button) findViewById(R.id.attribuerbut);

        But.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(MatchingActivity.this, "...", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MatchingActivity.this, AffichageClubActivity.class);
                startActivityForResult(i, 1);
            }
        });




        // ----------------------------- Démarrer le chronomètre
        Button button = (Button) findViewById(R.id.bt_start_chrono);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(MatchingActivity.this, "Début mi-temps", Toast.LENGTH_SHORT).show();
                MatchingActivity.this.startChronometer(null);
            }
        });


        //------------------------------ Démarrer la seconde mi temps
        Button button2nd = (Button) findViewById(R.id.bt_start_2nd);

        button2nd.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(MatchingActivity.this, "Début 2nd mi-temps", Toast.LENGTH_SHORT).show();
                MatchingActivity.this.startChronometer2nd(null);
            }
        });


        //------------------------------- Stopper le chrono ( à la fin de la deuxième mi temps )
        Button stopchrono = (Button) findViewById(R.id.stopchrono);

        stopchrono.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(MatchingActivity.this, "Chrono Stopper", Toast.LENGTH_SHORT).show();
                MatchingActivity.this.stopChronometer(null);
            }
        });

        // ----------------------------- Fin du match -> Récapitulatif
        Button Fin = (Button) findViewById(R.id.bt_fin);

        Fin.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {


                for(Joueur j  : MatchingActivity.le_match.getC1().getLesTitulaires()){
                    Club C1 = MatchingActivity.le_match.getC1();
                    JoueurDAO lesJDao = new JoueurDAO(MatchingActivity.this);
                    jouerDAO LesJDAO = new jouerDAO(MatchingActivity.this);
                    lesJDao.createJoueur(j);
                    LesJDAO.createjouerDAO(j,C1);
                }
                for(Joueur j  : MatchingActivity.le_match.getC1().getLesRemplacants()){
                    JoueurDAO lesJDao = new JoueurDAO(MatchingActivity.this);
                    lesJDao.createJoueur(j);
                    Club C1 = MatchingActivity.le_match.getC1();
                    jouerDAO LesJDAO = new jouerDAO(MatchingActivity.this);
                    LesJDAO.createjouerDAO(j,C1);
                }
                for(Joueur j  : MatchingActivity.le_match.getC2().getLesTitulaires()){
                    JoueurDAO lesJDao = new JoueurDAO(MatchingActivity.this);
                    lesJDao.createJoueur(j);
                    Club C2 = MatchingActivity.le_match.getC2();
                    jouerDAO LesJDAO = new jouerDAO(MatchingActivity.this);
                    LesJDAO.createjouerDAO(j,C2);
                }
                for(Joueur j  : MatchingActivity.le_match.getC2().getLesRemplacants()){
                    JoueurDAO lesJDao = new JoueurDAO(MatchingActivity.this);
                    lesJDao.createJoueur(j);
                    Club C2 = MatchingActivity.le_match.getC2();
                    jouerDAO LesJDAO = new jouerDAO(MatchingActivity.this);
                    LesJDAO.createjouerDAO(j,C2);
                }

                Club c1 = MatchingActivity.le_match.getC1();
                    ClubDAO lesJDao = new ClubDAO(MatchingActivity.this);
                    lesJDao.createClub(c1);

                Club c2 = MatchingActivity.le_match.getC2();
                    lesJDao = new ClubDAO(MatchingActivity.this);
                    lesJDao.createClub(c2);

                Match m = MatchingActivity.le_match;
                MatchDAO lesJDAO = new MatchDAO(MatchingActivity.this);
                lesJDAO.createMatch(m);

                for(But b  : MatchingActivity.le_match.getLes_buts()){
                    ButDAO lesJDao2 = new ButDAO(MatchingActivity.this);
                    lesJDao2.createBut(b);
                }

                for(Carton c  : MatchingActivity.le_match.getLes_cartons()){
                    CartonDAO lesJDao2 = new CartonDAO(MatchingActivity.this);
                    lesJDao2.createCarton(c);
                }




                MatchingActivity.this.stopChronometer(null);

                Toast.makeText(MatchingActivity.this, "Fin du match", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MatchingActivity.this, RecapActivity.class);
                startActivityForResult(i,1);
            }
        });

        // -----------------------------  Bouton remplacement
        Button Remplacement = (Button) findViewById(R.id.bt_remplacement);

        Remplacement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Chronometer c = ((Chronometer) findViewById(R.id.chronometer));
                DetailJoueurActivity.temps_actuel = (Integer.parseInt(c.getText().toString().substring(0, 2)));
                Log.i("INFO ********************************", "" + DetailJoueurActivity.temps_actuel);
                Intent i = new Intent(MatchingActivity.this, Choix_equipeR.class);
                startActivityForResult(i, 1);
            }
        });
    }

       //------------------------------ Méthode démarrer chrono
    public void startChronometer(View view) {
        Chronometer chrono = ((Chronometer) findViewById(R.id.chronometer));
        chrono.setBase(SystemClock.elapsedRealtime());
        chrono.setOnChronometerTickListener(this);
        ((Chronometer) findViewById(R.id.chronometer)).start();
    }

      //-------------------------------- Méthode Démarrer seconde mi temps
    public void startChronometer2nd(View view) {
        Chronometer chrono = ((Chronometer) findViewById(R.id.chronometer));
        //chrono.setFormat("MM:SS");
        chrono.setBase(SystemClock.elapsedRealtime() - (2700 * 1000));
        chrono.setOnChronometerTickListener(this);
        //chrono.setOnChronometerTickListener(this);
        ((Chronometer) findViewById(R.id.chronometer)).start();
    }

        //------------------------------ Méthode Stopper le chrono
    public void stopChronometer(View view) {
        ((Chronometer) findViewById(R.id.chronometer)).stop();
    }


    @Override
    public void onChronometerTick(Chronometer chronometer) {
        long t = SystemClock.elapsedRealtime() - chronometer.getBase();
        int h   = (int)(t/3600000);
        int m = (int)(t - h*3600000)/60000;
        int s= (int)(t - h*3600000- m*60000)/1000 ;

        m = m + (h*60);
        String hh = h < 10 ? "0"+h: h+"";
        String mm = m < 10 ? "0"+m: m+"";
        String ss = s < 10 ? "0"+s: s+"";
        chronometer.setText(mm +":"+ss);

    }
}


package com.sio.arbimatch.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.sio.arbimatch.classe.Carton;

/**
 * Created by jrinquepach on 18/12/13.
 */
public class CartonDAO {
    private SQLiteDatabase db;
    private JoueurSQLiteHelper dbHelper;

    public CartonDAO(Context context){
        dbHelper = new JoueurSQLiteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void createCarton(Carton c){
        ContentValues contentValues = new ContentValues();
        contentValues.put("_Joueur", String.valueOf(c.getJoueurConcerne()));
        contentValues.put("_Couleur", String.valueOf(c.getCouleur()));
        contentValues.put("_temps", String.valueOf(c.getTemps()));

        // Insert into DB
        db.insert("Carton", null, contentValues);
    }
}

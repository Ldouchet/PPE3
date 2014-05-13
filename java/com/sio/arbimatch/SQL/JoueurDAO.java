package com.sio.arbimatch.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sio.arbimatch.classe.Joueur;

import java.util.ArrayList;

/**
 * Created by jrinquepach on 18/12/13.
 */
public class JoueurDAO {
    private SQLiteDatabase db;
    private JoueurSQLiteHelper dbHelper;

    public JoueurDAO(Context context){
        dbHelper = new JoueurSQLiteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    /**
     * Create new Joueur object
     * @param j le joueur à créer
     */
    public void createJoueur(Joueur j){
        ContentValues contentValues = new ContentValues();
        contentValues.put("_nom",j.getNom());
        contentValues.put("_prenom",j.getPrenom());
        contentValues.put("_titre",j.getTitre());
        contentValues.put("_id",j.getId());

        // Insert into DB
        db.insert("joueurs", null, contentValues);
    }


}

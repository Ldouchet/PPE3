package com.sio.arbimatch.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.sio.arbimatch.classe.Club;
import com.sio.arbimatch.classe.Joueur;

/**
 * Created by jrinquepach on 18/12/13.
 */
public class jouerDAO {
    private SQLiteDatabase db;
    private JoueurSQLiteHelper dbHelper;

    public jouerDAO(Context context){
        dbHelper = new JoueurSQLiteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    /**
     * Create new Joueur object
     * @param j le joueur à créer
     */
    public void createjouerDAO(Joueur j, Club c){
        ContentValues contentValues = new ContentValues();
        contentValues.put("_idJoueur",j.getId());
        contentValues.put("_idClub",c.getId());
        contentValues.put("_status",j.getTitre());

        // Insert into DB
        db.insert("jouer", null, contentValues);
    }
}

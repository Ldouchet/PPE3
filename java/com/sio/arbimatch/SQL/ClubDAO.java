package com.sio.arbimatch.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.sio.arbimatch.classe.Club;
import com.sio.arbimatch.classe.Joueur;

/**
 * Created by jrinquepach on 18/12/13.
 */
public class ClubDAO {

    private SQLiteDatabase db;
    private JoueurSQLiteHelper dbHelper;

    public ClubDAO(Context context){
        dbHelper = new JoueurSQLiteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void createClub(Club c){
        ContentValues contentValues = new ContentValues();
        contentValues.put("_nom", c.getNom());
        contentValues.put("_id", c.getId());


        // Insert into DB
        db.insert("Club", null, contentValues);
    }
}

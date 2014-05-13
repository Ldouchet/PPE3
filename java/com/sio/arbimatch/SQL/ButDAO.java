package com.sio.arbimatch.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.sio.arbimatch.classe.But;
import com.sio.arbimatch.classe.Carton;

/**
 * Created by jrinquepach on 18/12/13.
 */
public class ButDAO {
    private SQLiteDatabase db;
    private JoueurSQLiteHelper dbHelper;

    public ButDAO(Context context){
        dbHelper = new JoueurSQLiteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void createBut(But b){
        ContentValues contentValues = new ContentValues();
        contentValues.put("_Joueur", String.valueOf(b.getJoueurConcerne()));
        contentValues.put("_temps", String.valueOf(b.getTemps()));

        // Insert into DB
        db.insert("But", null, contentValues);
    }
}

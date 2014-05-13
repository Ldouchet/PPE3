package com.sio.arbimatch.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.sio.arbimatch.classe.Club;
import com.sio.arbimatch.classe.Remplacement;

/**
 * Created by jrinquepach on 18/12/13.
 */
public class RemplacementDAO {
    private SQLiteDatabase db;
    private JoueurSQLiteHelper dbHelper;

    public RemplacementDAO(Context context){
        dbHelper = new JoueurSQLiteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void createRemplacement(Remplacement r){
        ContentValues contentValues = new ContentValues();
        contentValues.put("_j1", String.valueOf(r.getJ1()));
        contentValues.put("_j2", String.valueOf(r.getJ2()));
        contentValues.put("_temps", String.valueOf(r.getTemps()));


        // Insert into DB
        db.insert("Remplacement", null, contentValues);
    }
}

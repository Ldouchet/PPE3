package com.sio.arbimatch.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.sio.arbimatch.classe.*;

/**
 * Created by jrinquepach on 18/12/13.
 */
public class MatchDAO {
    private SQLiteDatabase db;
    private JoueurSQLiteHelper dbHelper;

    public MatchDAO(Context context){
        dbHelper = new JoueurSQLiteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void createMatch(Match m){
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id",m.getId());
        contentValues.put("_Date",m.getDate());


        // Insert into DB
        db.insert("Match", null, contentValues);

    }

}

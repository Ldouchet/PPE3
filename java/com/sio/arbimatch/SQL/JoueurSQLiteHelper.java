package com.sio.arbimatch.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jrinquepach on 18/12/13.
 */
public class JoueurSQLiteHelper extends SQLiteOpenHelper {


    static final int DB_VERSION = 3;
    static final String DB_NAME = "joueurs db";

    public JoueurSQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Execute create table SQL
        db.execSQL("CREATE TABLE joueurs (_id INTEGER PRIMARY KEY AUTOINCREMENT, _nom TEXT NOT NULL, _prenom TEXT NOT NULL, _titre TEXT NOT NULL, _idClub INTEGER )");
        db.execSQL("CREATE TABLE jouer (_idJoueur INTEGER , _idClub INTEGER, _status TEXT NOT NULL, PRIMARY KEY(_idJoueur, _idClub))");
        db.execSQL("CREATE TABLE Club (_id INTEGER PRIMARY KEY , _nom TEXT NOT NULL, _idMatch INTEGER )");
        db.execSQL("CREATE TABLE Carton (_id INTEGER PRIMARY KEY AUTOINCREMENT, _temps INTEGER NOT NULL, _Joueur TEXT NOT NULL, _couleur INTEGER, _idMatch INTEGER )");
        db.execSQL("CREATE TABLE But (_id INTEGER PRIMARY KEY AUTOINCREMENT, _temps INTEGER NOT NULL, _Joueur TEXT NOT NULL, _idMatch )");
        db.execSQL("CREATE TABLE Match (_id INTEGER PRIMARY KEY AUTOINCREMENT, _Date INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE Remplacement (_id INTEGER PRIMARY KEY AUTOINCREMENT, _Temps TEXT NOT NULL, _idMatch INTEGER, _j1 TEXT, _j2 TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer ) {
        // DROP table
        db.execSQL("DROP TABLE IF EXISTS joueurs");
        db.execSQL("DROP TABLE IF EXISTS jouer");
        db.execSQL("DROP TABLE IF EXISTS Club");
        db.execSQL("DROP TABLE IF EXISTS Carton");
        db.execSQL("DROP TABLE IF EXISTS But");
        db.execSQL("DROP TABLE IF EXISTS Match");
        db.execSQL("DROP TABLE IF EXISTS Remplacement");
        // Recreate table
        onCreate(db);
    }
}

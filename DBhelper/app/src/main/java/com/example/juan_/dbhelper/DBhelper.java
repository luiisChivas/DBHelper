package com.example.juan_.dbhelper;

/**
 * Created by juan- on 28/02/2017.
 */


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
public class DBhelper extends SQLiteOpenHelper {
    //Información de la tabla
    public static final String TABLE_MEMBER = "miembros";
    public static final String MIEMBRO_ID = "_id";
    public static final String MIEMBRO_NOMBRE = "nombre";

    //Informacion de la Base de Datos
    static final String DB_NAME = "DBMIEMBRO";
    static final int DB_VERSION = 1;

    //Informacón de la base de datos
    private static final String CREATE_TABLE = "create table"+ TABLE_MEMBER + " ("+ MIEMBRO_ID +" INTEGER PRIMARY KEY AUTOINCREMENTABLE, "
            +MIEMBRO_NOMBRE+ " TEXT NOT NULL);";

    public DBhelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_MEMBER);
        onCreate(db);
    }
}

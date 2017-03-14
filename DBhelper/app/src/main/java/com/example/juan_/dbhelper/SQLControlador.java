package com.example.juan_.dbhelper;


/**
 * Created by juan- on 28/02/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class SQLControlador {
    private DBhelper dbHelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControlador (Context ourcontext){
        this.ourcontext = ourcontext;
    }

    public SQLControlador abrirBaseDeDatos()throws SQLException{
        dbHelper = new DBhelper(ourcontext);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void cerrar(){
        dbHelper.close();
    }

    public void insertarDatos(String name){
        ContentValues cv = new ContentValues();
        cv.put(DBhelper.MIEMBRO_NOMBRE, name);
        database.insert(DBhelper.TABLE_MEMBER, null, cv);
    }
    public void deleteData (long memberID){
        database.delete(DBhelper.TABLE_MEMBER, DBhelper.MIEMBRO_ID+"="+memberID,null);
    }

    public int actualizarDatos(long memberID, String memberName){
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelper.MIEMBRO_NOMBRE, memberName);
        int i = database.update(DBhelper.TABLE_MEMBER, cvActualizar,DBhelper.MIEMBRO_ID + " = " + memberID, null);
        return i;
    }
    public Cursor leerDatos(){
        String[] todasLasColumnas = new String[]{
                DBhelper.MIEMBRO_ID,
                DBhelper.MIEMBRO_NOMBRE
        };
        Cursor c = database.query(DBhelper.TABLE_MEMBER, todasLasColumnas,null,null,null,null,null);
        if (c!=null){
            c.moveToFirst();
        }
        return c;
    }
}

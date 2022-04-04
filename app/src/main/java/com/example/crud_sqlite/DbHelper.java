package com.example.crud_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NOMBRE = "baseCliente.db";
    private static final int DATABASE_VERSION =2;


    public DbHelper(@Nullable Context context, String baseCliente, Object o, int i) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Base.CREAR_TABLA_CLIENTE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Base.TABLA_CLIENTE);
        onCreate(sqLiteDatabase);
    }

    protected void noQuery(String nsql ){
        this.getWritableDatabase().execSQL(nsql);
    }

    protected Cursor query(String sql){
        return this.getReadableDatabase().rawQuery(sql, null);
    }


}

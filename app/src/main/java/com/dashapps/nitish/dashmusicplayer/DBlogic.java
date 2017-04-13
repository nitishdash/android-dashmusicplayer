package com.dashapps.nitish.dashmusicplayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.dashapps.nitish.dashmusicplayer.TableData.TableInfo;

/**
 * Created by Nitish on 2/8/2016.
 *
 */
public class DBlogic extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION =1;
    public String CREATE_QUERY = "CREATE TABLE "+TableInfo.TABLE_NAME+"("+TableInfo.SONG_NAME+" TEXT,"+TableInfo.URI_PATH+" TEXT );";


    public DBlogic(Context context){
        super(context, TableInfo.DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operations", "Database Created!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database Operations", "Table Created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void putInfo(DBlogic dbl, String sname, String ur){
        SQLiteDatabase SQ = dbl.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableInfo.SONG_NAME, sname);
        cv.put(TableInfo.URI_PATH, ur);
        long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);
        Log.d("DATABASE OPERATION", "One row inserted");
    }
    public Cursor getInfo(DBlogic dBlog){
        SQLiteDatabase SQ = dBlog.getReadableDatabase();
        String[] columns = {TableInfo.SONG_NAME, TableInfo.URI_PATH};
        Cursor CR=SQ.query(TableInfo.TABLE_NAME, columns, null, null, null, null, null);

        return CR;
    }
}





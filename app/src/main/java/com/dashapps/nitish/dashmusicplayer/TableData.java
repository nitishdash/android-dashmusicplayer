package com.dashapps.nitish.dashmusicplayer;

import android.provider.BaseColumns;

/**
 * Created by Nitish on 2/8/2016.
 */
public class TableData {

    public TableData(){

    }

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String DATABASE_NAME = "songs.db";
        public static final String SONG_NAME = "song_names";
        public static final String URI_PATH = "URI";
        public static final String TABLE_NAME = "tb_names";

    }

}

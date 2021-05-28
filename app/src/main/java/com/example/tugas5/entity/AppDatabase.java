package com.example.tugas5.entity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataPinjaman.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract  DataPinjamanDAO dao();
    private static AppDatabase appDatabase;

    public static AppDatabase inidb(Context context){
        if(appDatabase==null) appDatabase = Room.databaseBuilder(context,AppDatabase.class,"dbPinjaman").allowMainThreadQueries().build();
        return appDatabase;
    }
}
package com.huynhnamvu.weatherapp;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Data.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract DataDAO dataDao();

    private static volatile MyAppDatabase INSTANCE;

    public static MyAppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MyAppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MyAppDatabase.class, "mix_test_database")
                            .build();
                }
                else {
                }
            }
        }
        return INSTANCE;
    }
}

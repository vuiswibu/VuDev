package com.huynhnamvu.weatherapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import androidx.lifecycle.LiveData;

import java.util.List;

@Dao
public interface DataDAO {
    @Query("SELECT * FROM Data")
    LiveData<List<Data>> getAllData();

    @Insert
    void insertUser(Data data);

    @Delete
    void deleteUser(Data data);

    @Query("DELETE FROM Data WHERE name = :name")
    void deleteUserByName(String name);
}
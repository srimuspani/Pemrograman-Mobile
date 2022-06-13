package com.example.laundryapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.laundryapp.database.dao.LaundryDao;
import com.example.laundryapp.model.ModelLaundry;

public class AppDatabase {
    @Database(entities = {ModelLaundry.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract LaundryDao laundryDao();
    }
}

package com.kadircetin.travelpins.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kadircetin.travelpins.model.Place

@Database(entities = [Place::class], version = 1)
abstract class PlaceDatabase : RoomDatabase() {
    abstract fun placeDao(): PlaceDao
}
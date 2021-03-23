package com.example.seng440assignment1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RatingEntry::class], version = 1, exportSchema = false)
abstract class RatingEntryDatabase: RoomDatabase() {

    abstract fun ratingEntryDao(): RatingEntryDao

    companion object{
        @Volatile
        private var INSTANCE: RatingEntryDatabase? = null

        fun getDatabase(context: Context): RatingEntryDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RatingEntryDatabase::class.java,
                    "rating_entry_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
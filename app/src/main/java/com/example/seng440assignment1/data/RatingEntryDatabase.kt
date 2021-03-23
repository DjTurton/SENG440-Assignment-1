package com.example.seng440assignment1.data

import android.content.Context
import androidx.room.*
import java.util.*

@Database(entities = [RatingEntry::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
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

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}
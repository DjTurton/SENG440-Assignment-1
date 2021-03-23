package com.example.seng440assignment1.data

import androidx.lifecycle.LiveData

class RatingEntryRepository(private val ratingEntryDao: RatingEntryDao) {

    val readAllData: LiveData<List<RatingEntry>> = ratingEntryDao.readAllData()

    suspend fun addEntry(ratingEntry: RatingEntry){
        ratingEntryDao.addEntry(ratingEntry)
    }

}
package com.example.seng440assignment1.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RatingEntryViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<RatingEntry>>
    private val repository: RatingEntryRepository

    init {
        val ratingEntryDao = RatingEntryDatabase.getDatabase(application).ratingEntryDao()
        repository = RatingEntryRepository(ratingEntryDao)
        readAllData = repository.readAllData
    }

    fun addEntry(ratingEntry: RatingEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addEntry(ratingEntry)
        }
    }
}
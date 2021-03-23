package com.example.seng440assignment1.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.util.*

@Entity(tableName = "user_table")
data class RatingEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val date: Long?,
    val rating: Int,
    val tags: String
)
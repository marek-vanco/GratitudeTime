package com.stellisee.gratitudetime.data.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stellisee.gratitudetime.data.model.Citation

@Database(entities = [Citation::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun citationDao(): CitationDao

    }
}
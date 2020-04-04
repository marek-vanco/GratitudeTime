package com.stellisee.gratitudetime.data.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stellisee.gratitudetime.data.model.Citation
import com.stellisee.gratitudetime.utilities.DATABASE_NAME

@Database(entities = [Citation::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun citationDao(): CitationDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = createNewInstance(context)
                }
                return INSTANCE!!
            }
        }

        private fun createNewInstance(context: Context): AppDatabase?  =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME)
                .createFromAsset("GratitudeTime.db")
                .fallbackToDestructiveMigration()
                .build()
    }

}
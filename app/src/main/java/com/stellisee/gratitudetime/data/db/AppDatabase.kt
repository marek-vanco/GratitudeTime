package com.stellisee.gratitudetime.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stellisee.gratitudetime.data.db.model.Citation
import com.stellisee.gratitudetime.internal.DATABASE_NAME

@Database(entities = [Citation::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun citationDao(): CitationDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME)
                .createFromAsset("GratitudeTime.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}
package com.stellisee.gratitudetime.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stellisee.gratitudetime.data.db.model.Citation
import com.stellisee.gratitudetime.internal.DATABASE_NAME
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import timber.log.Timber

@Database(entities = [Citation::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun citationDao(): CitationDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        @InternalCoroutinesApi
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
                Timber.d("database created it: ${instance}")
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            val database = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME)
                .createFromAsset("databases/GratitudeTime.db")
                .fallbackToDestructiveMigration()
                .build()
            Timber.d("database: ${database}")

            return database
        }
    }
}
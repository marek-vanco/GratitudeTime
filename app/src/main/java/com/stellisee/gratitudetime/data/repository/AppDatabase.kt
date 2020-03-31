package com.stellisee.gratitudetime.data.repository

import android.content.Context
import androidx.lifecycle.Transformations.map
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.stellisee.gratitudetime.R
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
                .allowMainThreadQueries()
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Thread(Runnable { prepopulateDb(context, getInstance(context)) }).start()
                    }
                })
                .fallbackToDestructiveMigration()
                .build()

        private fun prepopulateDb(context: Context, db: AppDatabase) {
            val citations = context.resources.getStringArray(R.array.citations)
                .map { Citation(it.split("|")[0], it.split("|")[1]) }
            db.citationDao().insertCitation(citations)
        }
    }

}
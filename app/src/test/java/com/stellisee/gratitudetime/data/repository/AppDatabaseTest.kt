package com.stellisee.gratitudetime.data.repository

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.stellisee.gratitudetime.data.model.Citation
import org.hamcrest.core.IsEqual.equalTo
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

        private lateinit var citationDao: CitationDao
        private lateinit var db: AppDatabase

        @Before
        fun createDb() {
            val context = ApplicationProvider.getApplicationContext<Context>()
            db = Room.inMemoryDatabaseBuilder(
                context, AppDatabase::class.java).build()
            citationDao = db.citationDao()
        }

        @After
        @Throws(IOException::class)
        fun closeDb() {
            db.close()
        }

        @Test
        @Throws(Exception::class)
        fun writeUserAndReadInList() {
            val citation: Citation()
            citation.phrase = "Citation phrase"


            citationDao.insertCitation(citation)

            val byName = citationDao.findUsersByName("george")
            assertThat(byName.get(0), equalTo(user))
        }
    }
}

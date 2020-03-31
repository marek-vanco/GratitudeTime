package com.stellisee.gratitudetime

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.stellisee.gratitudetime.data.model.Citation
import com.stellisee.gratitudetime.data.repository.AppDatabase
import com.stellisee.gratitudetime.data.repository.CitationDao
import org.hamcrest.core.IsEqual
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class AppInstrumentedTest {

    private lateinit var citationDao: CitationDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        citationDao = db.citationDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.stellisee.gratitudetime.debug", appContext.packageName)
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val citation = Citation("Citation phrase", "Author phrase",10)

        citationDao.insertCitation(citation)

        val citationFromDatabase = citationDao.selectCitation(10)
        assertThat(citationFromDatabase, IsEqual.equalTo(citation))
    }
}


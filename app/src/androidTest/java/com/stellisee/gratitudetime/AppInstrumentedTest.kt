package com.stellisee.gratitudetime

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.stellisee.gratitudetime.data.db.AppDatabase
import com.stellisee.gratitudetime.data.db.CitationDao
import org.hamcrest.core.IsEqual
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
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
    private val TAG : String = "AppInstrumentTest"

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
    @Ignore
    @Throws(Exception::class)
    fun readAllCitations() {

        val listCitations = citationDao.getAllCitations()

        for (citation in listCitations) {
            Log.d(TAG, citation.toString())
        }
        assertThat(listCitations.size , IsEqual.equalTo(3))
    }
}


package com.stellisee.gratitudetime.data.repository

import com.stellisee.gratitudetime.data.db.CitationDao
import com.stellisee.gratitudetime.data.repository.CitationsRepositoryImpl.Companion.destroyInstance
import org.junit.After
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CitationsRepositoryTest {

    private lateinit var citationsRepository: CitationsRepository

    @Mock
    private lateinit var citationDao: CitationDao


    @Before
    fun setupCitationRepository() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this)

        // Get a reference to the class under test
        citationsRepository = CitationsRepositoryImpl.getInstance(citationDao)
    }

    @After
    fun destroyRepositoryInstance() {
        destroyInstance()
    }

//    @Test
//    fun getCitationTest() {
//        withContext(Dispatchers.IO) {
//            var citation = citationDao.getCitation(1)
//            return@withContext citation
//        }
//    }
}

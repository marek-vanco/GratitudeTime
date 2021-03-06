package com.stellisee.gratitudetime

import android.app.Application
import com.stellisee.gratitudetime.data.db.AppDatabase
import com.stellisee.gratitudetime.data.repository.CitationsRepository
import com.stellisee.gratitudetime.data.repository.CitationsRepositoryImpl
import com.stellisee.gratitudetime.viewmodel.CitationViewModelFactory
import kotlinx.coroutines.InternalCoroutinesApi
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidCoreModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class GratitudeTimeApplication : Application(), KodeinAware {

    @InternalCoroutinesApi
    override val kodein = Kodein.lazy {
        import(androidCoreModule(this@GratitudeTimeApplication))

        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { instance<AppDatabase>().citationDao() }
        bind<CitationsRepository>() with singleton { CitationsRepositoryImpl(instance()) }
        bind() from provider { CitationViewModelFactory(instance()) }
    }
}
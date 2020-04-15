package com.stellisee.gratitudetime

import android.app.Application
import androidx.room.Database
import com.stellisee.gratitudetime.data.db.AppDatabase
import com.stellisee.gratitudetime.data.db.CitationDao
import com.stellisee.gratitudetime.data.repository.CitationsRepository
import com.stellisee.gratitudetime.data.repository.CitationsRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidCoreModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class GratitudeTimeApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidCoreModule(this@GratitudeTimeApplication))

        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { instance<AppDatabase>().citationDao() }
        bind<CitationsRepository>() with singleton { CitationsRepositoryImpl(instance())}
    }
}
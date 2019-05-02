package com.computersquid.razipoints.dependency.module

import android.content.Context
import androidx.room.Room
import com.computersquid.razipoints.application.MainApplication
import com.computersquid.razipoints.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module()
object AppModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideContext(application: MainApplication): Context {
        return application
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideRoomDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app-database")
                .allowMainThreadQueries()
                .build()
    }
}



package com.computersquid.razipoints.application

import android.content.Context
import com.computersquid.razipoints.model.MyObjectBox
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
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
    fun provideBoxStore(context: Context): BoxStore {
        return MyObjectBox.builder().androidContext(context).build()
    }
}
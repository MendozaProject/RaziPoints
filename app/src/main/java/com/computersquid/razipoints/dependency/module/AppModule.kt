package com.computersquid.razipoints.dependency.module

import android.content.Context
import com.computersquid.razipoints.application.MainApplication
import com.computersquid.razipoints.data.model.MyObjectBox
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
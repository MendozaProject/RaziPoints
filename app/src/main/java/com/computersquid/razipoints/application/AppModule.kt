package com.computersquid.razipoints.application

import android.content.Context
import com.computersquid.razipoints.ui.model.MyObjectBox
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import javax.inject.Singleton

@Module()
object AppModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideContext(application: MainApplication): Context = application

    @Provides
    @Singleton
    @JvmStatic
    fun provideBoxStore(context: Context): BoxStore = MyObjectBox.builder().androidContext(context).build()
}
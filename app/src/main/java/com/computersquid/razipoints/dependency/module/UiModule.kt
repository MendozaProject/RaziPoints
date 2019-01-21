package com.computersquid.razipoints.dependency.module

import androidx.lifecycle.ViewModelProvider
import com.computersquid.razipoints.dependency.ViewModelFactory
import com.computersquid.razipoints.view.activity.TheWillOfGod
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class UiModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    internal abstract fun contributeMainActivity(): TheWillOfGod
}
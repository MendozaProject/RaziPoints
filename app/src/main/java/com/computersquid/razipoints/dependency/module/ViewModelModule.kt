package com.computersquid.razipoints.dependency.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.computersquid.razipoints.dependency.ViewModelFactory
import com.computersquid.razipoints.ui.viewmodel.*
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
internal abstract class ViewModelModule {

    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(TaskCreatorViewModel::class)
    abstract fun bindTaskCreatorViewModel(viewModel: TaskCreatorViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(TaskInputDifficultyViewModel::class)
    abstract fun bindTaskInputDifficultyViewModel(viewModel: TaskInputDifficultyViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(TaskInputInfoViewModel::class)
    abstract fun bindTaskInputInfoViewModel(viewModel: TaskInputInfoViewModel): ViewModel
}
package com.computersquid.razipoints.dependency.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.computersquid.razipoints.dependency.ViewModelFactory
import com.computersquid.razipoints.ui.viewmodel.HomeViewModelImpl
import com.computersquid.razipoints.ui.viewmodel.TaskCreatorViewModelImpl
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
    @ViewModelKey(HomeViewModelImpl::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModelImpl): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(TaskCreatorViewModelImpl::class)
    abstract fun bindTaskCreatorViewModel(viewModel: TaskCreatorViewModelImpl): ViewModel
}
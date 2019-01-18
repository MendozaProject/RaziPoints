package com.computersquid.razipoints.dependency.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.computersquid.razipoints.mvvm.ViewModelFactory
import com.computersquid.razipoints.mvvm.ViewModelKey
import com.computersquid.razipoints.viewmodel.HomeViewModelImpl
import com.computersquid.razipoints.viewmodel.TaskCreationViewModelImpl
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass


@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModelImpl::class)
    internal abstract fun homeViewModel(viewModel: HomeViewModelImpl): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TaskCreationViewModelImpl::class)
    internal abstract fun taskCreationViewModel(viewModel: TaskCreationViewModelImpl): ViewModel



    //Add more ViewModels here
}
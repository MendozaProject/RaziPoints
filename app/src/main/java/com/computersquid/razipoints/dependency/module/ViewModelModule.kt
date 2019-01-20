package com.computersquid.razipoints.dependency.module

import androidx.lifecycle.ViewModel
import com.computersquid.razipoints.data.repository.TaskRepository
import com.computersquid.razipoints.mvvm.ViewModelFactory
import com.computersquid.razipoints.viewmodel.HomeViewModelImpl
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider
import kotlin.reflect.KClass


@Module
abstract class ViewModelModule {

    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

    @Provides
    fun viewModelFactory(providerMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelFactory {
        return ViewModelFactory(providerMap)
    }

    @Provides
    @IntoMap
    @ViewModelKey(HomeViewModelImpl::class)
    fun homeViewModel(taskRepository: TaskRepository): ViewModel {
        return HomeViewModelImpl(taskRepository)
    }

    //Different Implementation? https://stackoverflow.com/questions/50673266/viewmodelproviders-with-dagger-2-not-able-to-grasp-the-concept/50681021#50681021

    //TODO: Add more ViewModels here
}
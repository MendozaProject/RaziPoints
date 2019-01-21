package com.computersquid.razipoints.dependency.component

import com.computersquid.razipoints.application.MainApplication
import com.computersquid.razipoints.dependency.module.FragmentBindingModule
import com.computersquid.razipoints.dependency.module.AppModule
import com.computersquid.razipoints.dependency.module.RepositoryModule
import com.computersquid.razipoints.dependency.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules= [
    AppModule::class,
    AndroidSupportInjectionModule::class,
    FragmentBindingModule::class,
    ViewModelModule::class,
    RepositoryModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(application: MainApplication): Builder

        fun build(): AppComponent
    }

    fun inject(application: MainApplication)
}
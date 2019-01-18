package com.computersquid.razipoints.application

import com.computersquid.razipoints.dependency.module.FragmentBindingModule
import com.computersquid.razipoints.dependency.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules=arrayOf(AppModule::class, AndroidSupportInjectionModule::class, FragmentBindingModule::class))
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
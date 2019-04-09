package com.computersquid.razipoints.dependency.component

import com.computersquid.razipoints.application.MainApplication
import com.computersquid.razipoints.dependency.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules= [
    AppModule::class,
    AndroidSupportInjectionModule::class,
    RoomModule::class,
    FragmentBindingModule::class,
    ViewModelModule::class
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
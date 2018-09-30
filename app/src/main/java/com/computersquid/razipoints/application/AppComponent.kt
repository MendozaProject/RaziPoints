package com.computersquid.razipoints.application

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules=arrayOf(AppModule::class, AndroidInjectionModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder
    {
        @BindsInstance
        fun application(application: MainApplication): Builder

        fun build(): AppComponent
    }
}
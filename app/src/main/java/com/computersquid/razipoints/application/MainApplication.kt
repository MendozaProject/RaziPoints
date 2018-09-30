package com.computersquid.razipoints.application

import android.app.Application
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainApplication: Application(), HasSupportFragmentInjector {

    @Inject
    lateinit var supportFragmentInjector : DispatchingAndroidInjector<Fragment>

    lateinit var mAppComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        mAppComponent = DaggerAppComponent.builder().application(this).build()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = supportFragmentInjector

    public fun getAppComponent(): AppComponent {
        return mAppComponent
    }
}
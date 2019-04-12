package com.computersquid.razipoints.application

import android.app.Application
import androidx.fragment.app.Fragment
import com.computersquid.razipoints.R
import com.computersquid.razipoints.dependency.component.AppComponent
import com.computersquid.razipoints.dependency.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import javax.inject.Inject


class MainApplication: Application(), HasSupportFragmentInjector {

    @Inject
    lateinit var supportFragmentInjector : DispatchingAndroidInjector<Fragment>

    lateinit var mAppComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        mAppComponent = DaggerAppComponent.builder().application(this).build()
        mAppComponent.inject(this)

        ViewPump.init(ViewPump.builder().addInterceptor(
                CalligraphyInterceptor(CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Roboto-RobotoRegular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build())).build())
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = supportFragmentInjector

    public fun getAppComponent(): AppComponent {
        return mAppComponent
    }
}
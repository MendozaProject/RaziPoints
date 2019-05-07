package com.computersquid.razipoints.dependency.module

import com.computersquid.razipoints.ui.fragments.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun bindTaskInputDifficultyFragment(): TaskInputDifficultyFragment

    @ContributesAndroidInjector
    abstract fun bindTaskInputInfoFragment(): TaskInputInfoFragment
}
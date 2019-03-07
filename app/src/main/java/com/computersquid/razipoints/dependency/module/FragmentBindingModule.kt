package com.computersquid.razipoints.dependency.module

import com.computersquid.razipoints.ui.fragments.HomeFragment
import com.computersquid.razipoints.ui.fragments.TaskCreatorFragment
import com.computersquid.razipoints.ui.fragments.TaskInputDifficultyFragment
import com.computersquid.razipoints.ui.fragments.TaskInputInfoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun bindTaskCreatorFragment(): TaskCreatorFragment

    @ContributesAndroidInjector
    abstract fun bindTaskInputDifficultyFragment(): TaskInputDifficultyFragment

    @ContributesAndroidInjector
    abstract fun bindTaskInputInfoFragment(): TaskInputInfoFragment
}
package com.computersquid.razipoints.dependency.module

import com.computersquid.razipoints.view.fragments.HomeFragment
import com.computersquid.razipoints.view.fragments.TaskCreationDialogFragment
import com.computersquid.razipoints.view.fragments.TaskCreatorFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun bindTaskCreatorFragment(): TaskCreatorFragment
}
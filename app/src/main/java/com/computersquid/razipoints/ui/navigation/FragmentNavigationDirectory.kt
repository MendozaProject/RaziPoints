package com.computersquid.razipoints.ui.navigation

import com.computersquid.razipoints.data.model.Task

interface FragmentNavigationDirectory {
    fun showHomeFragment()
    fun showTaskCreationFragment(task: Task)
}
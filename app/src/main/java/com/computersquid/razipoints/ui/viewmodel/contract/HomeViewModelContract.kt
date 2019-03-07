package com.computersquid.razipoints.ui.viewmodel.contract

import androidx.fragment.app.FragmentManager
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User
import com.computersquid.razipoints.ui.mvvm.BaseViewModel
import io.objectbox.android.ObjectBoxLiveData

interface HomeViewModelContract {

    val userLiveData: ObjectBoxLiveData<User>
    val tasksLiveData: ObjectBoxLiveData<Task>
    val user: User
    val tasks: List<Task>

    fun startTaskCreationFragment(fragmentManager: FragmentManager, actionId: Long)
    fun markTaskAsDone(task: Task)
    fun addTestTask(task:Task) : Long
}

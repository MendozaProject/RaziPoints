package com.computersquid.razipoints.viewmodel

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User
import io.objectbox.android.ObjectBoxLiveData

interface HomeViewModel {
    var userLiveData: ObjectBoxLiveData<User>
    var tasksLiveData: ObjectBoxLiveData<Task>

    fun getTasks() : List<Task>
    fun showActionDialog(fragmentManager: FragmentManager, actionId: Long)
    fun markTaskAsDone(task: Task)
    fun addTestTask(task:Task) : Long
}

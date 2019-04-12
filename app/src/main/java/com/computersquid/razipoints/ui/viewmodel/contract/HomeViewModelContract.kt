package com.computersquid.razipoints.ui.viewmodel.contract

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User

interface HomeViewModelContract {

    val userLiveData: LiveData<User>
    val tasksLiveData: LiveData<List<Task>>

    fun markTaskAsDone(task: Task)
    fun addTestTask(task:Task)
}

package com.computersquid.razipoints.ui.viewmodel

import androidx.lifecycle.LiveData
import com.computersquid.razipoints.data.repository.TaskRepository
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User
import com.computersquid.razipoints.data.repository.UserRepository
import com.computersquid.razipoints.ui.mvvm.BaseViewModel
import com.computersquid.razipoints.ui.viewmodel.contract.HomeViewModelContract
import javax.inject.Inject


class HomeViewModel
@Inject
constructor(
        private val taskRepository: TaskRepository,
        private val userRepository: UserRepository
) : HomeViewModelContract, BaseViewModel()  {

    override val userLiveData: LiveData<User> = userRepository.getUser()
    override val tasksLiveData: LiveData<List<Task>> = taskRepository.getAll()

    override fun markTaskAsDone(task: Task) {

    }

    override fun addTestTask(task: Task) {
        taskRepository.add(task)
    }
}
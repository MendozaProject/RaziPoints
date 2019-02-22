package com.computersquid.razipoints.ui.viewmodel

import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.repository.TaskRepository
import com.computersquid.razipoints.ui.mvvm.BaseViewModel
import javax.inject.Inject

class TaskCreatorViewModelImpl
@Inject
constructor(
        private val taskRepository: TaskRepository
) : TaskCreatorViewModel, BaseViewModel() {

    override lateinit var taskLiveData: Task
    override var currentPage: Int = 0


    override fun nextButtonClick() {
        currentPage++
    }


    override fun backButtonClick() {
        currentPage--
    }
}
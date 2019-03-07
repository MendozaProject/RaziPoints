package com.computersquid.razipoints.ui.viewmodel

import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.repository.TaskRepository
import com.computersquid.razipoints.ui.mvvm.BaseViewModel
import com.computersquid.razipoints.ui.viewmodel.contract.TaskCreatorViewModelContract
import javax.inject.Inject

class TaskCreatorViewModel
@Inject
constructor(private val taskRepository: TaskRepository)
    : TaskCreatorViewModelContract, BaseViewModel() {

    override lateinit var task: Task
    override var currentPage: Int = 0


    override fun nextButtonClick() {
        currentPage++
    }


    override fun backButtonClick() {
        currentPage--
    }
}
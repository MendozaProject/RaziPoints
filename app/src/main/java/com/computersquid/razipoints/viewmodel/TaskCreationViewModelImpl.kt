package com.computersquid.razipoints.viewmodel

import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.repository.TaskRepository
import com.computersquid.razipoints.mvvm.BaseViewModel
import javax.inject.Inject


class TaskCreationViewModelImpl
@Inject
constructor(
        private val taskRepository: TaskRepository
) : TaskCreationViewModel, BaseViewModel() {

    val task : Task = Task()


}

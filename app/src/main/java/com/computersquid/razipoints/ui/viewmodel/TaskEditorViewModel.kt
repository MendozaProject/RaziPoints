package com.computersquid.razipoints.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.repository.TaskRepository
import com.computersquid.razipoints.ui.mvvm.BaseViewModel
import com.computersquid.razipoints.ui.viewmodel.contract.TaskEditorViewModelContract
import javax.inject.Inject

class TaskEditorViewModel @Inject constructor(
        private val taskRepository: TaskRepository
) : BaseViewModel(), TaskEditorViewModelContract {

    override val taskLiveData: MutableLiveData<Task> by lazy {
        MutableLiveData<Task>()
    }

    override fun saveTask(){
        taskRepository.add(taskLiveData.value!!)
    }
}
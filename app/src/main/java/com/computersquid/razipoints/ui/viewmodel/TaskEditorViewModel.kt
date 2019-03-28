package com.computersquid.razipoints.ui.viewmodel

import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.ui.mvvm.BaseViewModel
import com.computersquid.razipoints.ui.viewmodel.contract.TaskEditorViewModelContract
import javax.inject.Inject

class TaskEditorViewModel @Inject constructor()
    : BaseViewModel(), TaskEditorViewModelContract {

    override var task: Task = Task()

    override fun saveTask(){

    }
}
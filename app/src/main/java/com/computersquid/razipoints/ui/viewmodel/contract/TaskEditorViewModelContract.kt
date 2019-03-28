package com.computersquid.razipoints.ui.viewmodel.contract

import com.computersquid.razipoints.data.model.Task

interface TaskEditorViewModelContract {
    var task: Task
    fun saveTask()
}
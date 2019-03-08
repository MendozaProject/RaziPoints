package com.computersquid.razipoints.ui.viewmodel

import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.ui.mvvm.BaseViewModel
import com.computersquid.razipoints.ui.viewmodel.contract.TaskInputInfoViewModelContract
import javax.inject.Inject

class TaskInputInfoViewModel
    @Inject constructor()
    : BaseViewModel(), TaskInputInfoViewModelContract {
    override var task: Task = Task()
}
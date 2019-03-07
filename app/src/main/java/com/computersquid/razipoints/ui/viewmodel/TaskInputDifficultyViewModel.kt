package com.computersquid.razipoints.ui.viewmodel

import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.ui.mvvm.BaseViewModel
import com.computersquid.razipoints.ui.viewmodel.contract.TaskInputDifficultyViewModelContract
import javax.inject.Inject

class TaskInputDifficultyViewModel
    @Inject constructor()
    : BaseViewModel(), TaskInputDifficultyViewModelContract {
    override val task: Task = Task()
}
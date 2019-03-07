package com.computersquid.razipoints.ui.viewmodel.contract

import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.ui.mvvm.BaseViewModel

interface TaskCreatorViewModelContract {
    val task: Task
    val currentPage: Int

    fun nextButtonClick()
    fun backButtonClick()
}
package com.computersquid.razipoints.viewmodel

import com.computersquid.razipoints.data.model.Task

interface TaskCreatorViewModel {
    val taskLiveData: Task
    val currentPage: Int

    fun nextButtonClick()
    fun backButtonClick()
}
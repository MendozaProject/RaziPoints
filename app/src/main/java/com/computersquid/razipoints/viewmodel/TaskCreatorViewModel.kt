package com.computersquid.razipoints.viewmodel

import androidx.lifecycle.LiveData
import com.computersquid.razipoints.data.model.Task

interface TaskCreatorViewModel {
    val taskLiveData: LiveData<Task>
    val currentPage: Int

    fun nextButtonClick()
    fun backButtonClick()
}
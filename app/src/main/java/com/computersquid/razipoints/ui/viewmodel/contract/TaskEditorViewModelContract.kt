package com.computersquid.razipoints.ui.viewmodel.contract

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.computersquid.razipoints.data.model.Task

interface TaskEditorViewModelContract {
    val taskLiveData: MutableLiveData<Task>
    fun saveTask()
}
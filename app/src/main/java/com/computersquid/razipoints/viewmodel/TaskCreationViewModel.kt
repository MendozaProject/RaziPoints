package com.computersquid.razipoints.viewmodel

import androidx.lifecycle.MutableLiveData
import com.computersquid.razipoints.model.Task
import com.computersquid.razipoints.mvvm.BaseViewModel

interface TaskCreationViewModel {
    var task: MutableLiveData<Task>
}
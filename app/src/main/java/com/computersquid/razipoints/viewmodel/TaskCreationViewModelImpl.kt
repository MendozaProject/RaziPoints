package com.computersquid.razipoints.viewmodel

import androidx.lifecycle.MutableLiveData
import com.computersquid.razipoints.model.Task
import com.computersquid.razipoints.mvvm.BaseViewModel


class TaskCreationViewModelImpl(override var task: MutableLiveData<Task>)
    : TaskCreationViewModel, BaseViewModel() {

}

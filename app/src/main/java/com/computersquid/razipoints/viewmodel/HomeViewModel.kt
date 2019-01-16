package com.computersquid.razipoints.viewmodel

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import com.computersquid.razipoints.data.TaskRepository
import com.computersquid.razipoints.data.UserRepository
import com.computersquid.razipoints.model.Task
import com.computersquid.razipoints.model.User
import com.computersquid.razipoints.view.fragments.TaskCreationDialogFragment
import com.computersquid.razipoints.mvvm.BaseViewModel
import javax.inject.Inject

interface HomeViewModel {
    var user: MutableLiveData<User>
    var actions: MutableLiveData<List<Task>>
    fun showActionDialog(fragmentManager: FragmentManager, actionId: Long)
}

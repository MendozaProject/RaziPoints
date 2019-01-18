package com.computersquid.razipoints.viewmodel

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User
import io.objectbox.android.ObjectBoxLiveData

interface HomeViewModel {
    var user: ObjectBoxLiveData<User>
    var tasks: ObjectBoxLiveData<Task>
    fun showActionDialog(fragmentManager: FragmentManager, actionId: Long)
}

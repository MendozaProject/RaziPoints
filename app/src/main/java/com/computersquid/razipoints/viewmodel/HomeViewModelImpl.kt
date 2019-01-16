package com.computersquid.razipoints.viewmodel

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import com.computersquid.razipoints.data.TaskRepository
import com.computersquid.razipoints.data.UserRepository
import com.computersquid.razipoints.model.Task
import com.computersquid.razipoints.model.User
import com.computersquid.razipoints.mvvm.BaseViewModel
import com.computersquid.razipoints.view.fragments.TaskCreationDialogFragment
import javax.inject.Inject


class HomeViewModelImpl @Inject constructor(
        userRepository: UserRepository,
        taskRepository: TaskRepository) : HomeViewModel, BaseViewModel() {

    @Inject
    private lateinit var userRepository: UserRepository

    @Inject
    private lateinit var taskRepository: TaskRepository

    override var user: MutableLiveData<User> = MutableLiveData()
    override var actions: MutableLiveData<List<Task>> = MutableLiveData()


    override fun showActionDialog(fragmentManager: FragmentManager, actionId: Long){
        val fragmentTransaction = fragmentManager.beginTransaction()
        val previousFragment = fragmentManager.findFragmentByTag(TaskCreationDialogFragment.TAG)

        if (previousFragment != null) {
            fragmentTransaction.remove(previousFragment)
        }
        fragmentTransaction.addToBackStack(null)

        val actionDialog = TaskCreationDialogFragment.newInstance(0)
        actionDialog.show(fragmentManager, TaskCreationDialogFragment.TAG)
    }


    companion object {
        @JvmStatic val TAG: String = this::class.java.simpleName
    }
}
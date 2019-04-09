package com.computersquid.razipoints.ui.viewmodel

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import com.computersquid.razipoints.data.repository.TaskRepository
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User
import com.computersquid.razipoints.data.repository.UserRepository
import com.computersquid.razipoints.ui.mvvm.BaseViewModel
import com.computersquid.razipoints.ui.fragments.TaskCreationDialogFragment
import com.computersquid.razipoints.ui.viewmodel.contract.HomeViewModelContract
import javax.inject.Inject


class HomeViewModel
@Inject
constructor(
        private val taskRepository: TaskRepository,
        private val userRepository: UserRepository
) : HomeViewModelContract, BaseViewModel()  {

    override val userLiveData: LiveData<User> = userRepository.getById(1)
    override val tasksLiveData: LiveData<List<Task>> = taskRepository.getAll()

    init {
        //userRepository.add(User(points = 2, name = "Zoe LeClair"))
    }

    override fun startTaskCreationFragment(fragmentManager: FragmentManager, actionId: Long){
        val fragmentTransaction = fragmentManager.beginTransaction()
        val previousFragment = fragmentManager.findFragmentByTag(TaskCreationDialogFragment.TAG)

        if (previousFragment != null) {
            fragmentTransaction.remove(previousFragment)
        }
        fragmentTransaction.addToBackStack(null)

        val actionDialog = TaskCreationDialogFragment.newInstance(0)
        actionDialog.show(fragmentManager, TaskCreationDialogFragment.TAG)
    }


    override fun markTaskAsDone(task: Task) {

    }

    override fun addTestTask(task: Task) {
        taskRepository.add(task)
    }


    companion object {
        @JvmStatic val TAG: String = this::class.java.simpleName
    }
}
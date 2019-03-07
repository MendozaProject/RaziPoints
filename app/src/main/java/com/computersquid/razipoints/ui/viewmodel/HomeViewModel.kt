package com.computersquid.razipoints.ui.viewmodel

import androidx.fragment.app.FragmentManager
import com.computersquid.razipoints.data.repository.TaskRepository
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User
import com.computersquid.razipoints.data.repository.UserRepository
import com.computersquid.razipoints.ui.mvvm.BaseViewModel
import com.computersquid.razipoints.ui.fragments.TaskCreationDialogFragment
import com.computersquid.razipoints.ui.viewmodel.contract.HomeViewModelContract
import io.objectbox.android.ObjectBoxLiveData
import javax.inject.Inject


class HomeViewModel
@Inject
constructor(
        private val taskRepository: TaskRepository,
        private val userRepository: UserRepository
) : HomeViewModelContract, BaseViewModel()  {

    override val userLiveData: ObjectBoxLiveData<User> = userRepository.getUserLiveData(1)
    override val tasksLiveData: ObjectBoxLiveData<Task> = taskRepository.getAllLiveData()
    override val user: User
        get() = userRepository.getById(1)
    override val tasks: List<Task>
        get() = taskRepository.getAll()


    init {

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


    override fun addTestTask(task: Task): Long {
        val ret = taskRepository.add(task)
        assert(ret > 0)
        return ret
    }


    companion object {
        @JvmStatic val TAG: String = this::class.java.simpleName
    }
}
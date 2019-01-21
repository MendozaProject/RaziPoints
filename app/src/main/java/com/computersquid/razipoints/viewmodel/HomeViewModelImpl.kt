package com.computersquid.razipoints.viewmodel

import androidx.fragment.app.FragmentManager
import com.computersquid.razipoints.data.repository.TaskRepository
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User
import com.computersquid.razipoints.mvvm.BaseViewModel
import com.computersquid.razipoints.view.fragments.TaskCreationDialogFragment
import io.objectbox.android.ObjectBoxLiveData
import javax.inject.Inject


class HomeViewModelImpl
@Inject
constructor(private val taskRepository: TaskRepository) : HomeViewModel, BaseViewModel() {

    override lateinit var userLiveData: ObjectBoxLiveData<User>
    override lateinit var tasksLiveData: ObjectBoxLiveData<Task>


    init {
        addTestTask(Task(0, "Task", 12, false))
        tasksLiveData = taskRepository.getAllLiveData()
    }


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


    override fun getTasks() : List<Task> {
        return taskRepository.getAll()
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
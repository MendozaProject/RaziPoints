package com.computersquid.razipoints.viewmodel

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import com.computersquid.razipoints.data.repository.TaskRepository
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User
import com.computersquid.razipoints.mvvm.BaseViewModel
import com.computersquid.razipoints.view.fragments.TaskCreationDialogFragment
import io.objectbox.android.ObjectBoxLiveData
import javax.inject.Inject


class HomeViewModelImpl
@Inject
constructor(val taskRepository: TaskRepository) : HomeViewModel, BaseViewModel() {

    override lateinit var user: ObjectBoxLiveData<User>
    override lateinit var tasks: ObjectBoxLiveData<Task>

    init {
        var ret = taskRepository.add(Task(0, "Task", 12, false))
        assert(ret > 0)
        ret = taskRepository.add(Task(0, "Task", 12, false))
        assert(ret > 0)
        ret = taskRepository.add(Task(0, "Task", 12, false))
        assert(ret > 0)

        tasks = taskRepository.getAll()

        print(tasks)
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


    override fun markTaskAsDone(task: Task) {

    }


    companion object {
        @JvmStatic val TAG: String = this::class.java.simpleName
    }
}
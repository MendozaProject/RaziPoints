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
    override var tasks: ObjectBoxLiveData<Task> = taskRepository.getAll()

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
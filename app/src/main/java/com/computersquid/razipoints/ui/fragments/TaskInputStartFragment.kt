package com.computersquid.razipoints.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.computersquid.razipoints.R
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.ui.viewmodel.TaskEditorViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class TaskInputStartFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        var viewModel = ViewModelProviders.of(activity!!, viewModelFactory)
                .get(TaskEditorViewModel::class.java)
        val task = TaskInputInfoFragmentArgs.fromBundle(this.arguments!!).editTask!!
        viewModel.taskLiveData.value = task
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View(activity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val action = TaskInputStartFragmentDirections
                .actionTaskInputStartFragmentToTaskInputInfoFragment (Task())
        view.findNavController().navigate(action)
    }
}

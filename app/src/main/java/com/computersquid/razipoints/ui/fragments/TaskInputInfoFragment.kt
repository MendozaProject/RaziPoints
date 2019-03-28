package com.computersquid.razipoints.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController

import com.computersquid.razipoints.R
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.ui.viewmodel.TaskEditorViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.controls_task_wizard.*
import javax.inject.Inject

class TaskInputInfoFragment : Fragment() {

    private lateinit var viewModel: TaskEditorViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(activity!!, viewModelFactory)
                .get(TaskEditorViewModel::class.java)

        val task = TaskInputInfoFragmentArgs.fromBundle(this.arguments!!).editTask!!
        viewModel.task = task
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_input_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        taskWizardBack.visibility = View.VISIBLE
        taskWizardNext.visibility = View.GONE
        taskWizardDone.visibility = View.VISIBLE
        taskWizardDone.setOnClickListener {
            val action = TaskInputInfoFragmentDirections.actionTaskInputInfoFragmentToTaskInputDifficultyFragment (viewModel.task)
            view.findNavController().navigate(action)
        }
    }

    companion object {
        @JvmStatic
        val TAG: String = this::class.java.simpleName
    }
}

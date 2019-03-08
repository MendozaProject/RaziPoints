package com.computersquid.razipoints.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.computersquid.razipoints.R
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.ui.viewmodel.TaskInputInfoViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class TaskInputInfoFragment : Fragment() {

    private lateinit var viewModel: TaskInputInfoViewModel
    val TASK_ARG = "task_arg"

    @Inject
    lateinit var viewModeFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModeFactory)
                .get(TaskInputInfoViewModel::class.java)

        arguments?.let { viewModel.task = it.getParcelable(TASK_ARG)!! }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_input_info, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


    companion object {
        @JvmStatic
        val TAG: String = this::class.java.simpleName

        @JvmStatic
        fun newInstance(task: Task) = TaskInputInfoFragment().apply {
            arguments = Bundle().apply {
                putParcelable(TASK_ARG, task)
            }
        }
    }
}

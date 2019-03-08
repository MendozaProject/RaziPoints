package com.computersquid.razipoints.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.computersquid.razipoints.R
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.ui.mvvm.BaseFragment
import com.computersquid.razipoints.ui.viewmodel.TaskInputDifficultyViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class TaskInputDifficultyFragment : BaseFragment() {

    private lateinit var viewModel: TaskInputDifficultyViewModel
    val TASK_ARG = "task_arg"

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(TaskInputDifficultyViewModel::class.java)

        arguments?.let { viewModel.task = it.getParcelable(TASK_ARG)!! }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_input_difficulty, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


    companion object {
        @JvmStatic
        val TAG: String = this::class.java.simpleName

        @JvmStatic
        fun newInstance(task: Task) = TaskInputDifficultyFragment().apply {
            arguments = Bundle().apply {
                putParcelable (TASK_ARG, task)
            }
        }
    }
}

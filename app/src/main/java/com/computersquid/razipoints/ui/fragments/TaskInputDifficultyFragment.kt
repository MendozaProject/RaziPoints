package com.computersquid.razipoints.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.computersquid.razipoints.R
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.ui.mvvm.BaseFragment

const val TASK_ARG = "taskArg"

class TaskInputDifficultyFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_input_difficulty, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(task: Task) =
                TaskInputDifficultyFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable (TASK_ARG, task)
                    }
                }
    }
}

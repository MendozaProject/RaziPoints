package com.computersquid.razipoints.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.computersquid.razipoints.R
import com.computersquid.razipoints.ui.mvvm.BaseFragment
import com.computersquid.razipoints.ui.viewmodel.TaskEditorViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.controls_task_wizard.*
import kotlinx.android.synthetic.main.fragment_task_creator.view.*
import javax.inject.Inject


class TaskInputDifficultyFragment : BaseFragment() {

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
        return inflater.inflate(R.layout.fragment_task_input_difficulty, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        taskWizardBack.visibility = View.VISIBLE
        taskWizardNext.visibility = View.GONE
        taskWizardDone.visibility = View.VISIBLE
        taskWizardDone.setOnClickListener {
            view.findNavController().popBackStack(R.id.homeFragment, false)
        }
        taskWizardBack.setOnClickListener {
            view.findNavController().popBackStack()
        }
    }
}

package com.computersquid.razipoints.ui.fragments


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.computersquid.razipoints.R
import com.computersquid.razipoints.ui.viewmodel.TaskEditorViewModel
import com.computersquid.razipoints.ui.viewmodel.contract.TaskEditorViewModelContract
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.controls_task_wizard.*
import kotlinx.android.synthetic.main.fragment_task_input_info.*
import javax.inject.Inject

class TaskInputInfoFragment : Fragment() {

    private lateinit var viewModel: TaskEditorViewModelContract

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(activity!!, viewModelFactory)
                .get(TaskEditorViewModel::class.java)

//        val task = TaskInputInfoFragmentArgs.fromBundle(this.arguments!!).editTask!!
//        viewModel.taskLiveData.value = task
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_input_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        taskWizardBack.visibility = View.VISIBLE
        taskWizardNext.visibility = View.VISIBLE
        taskWizardDone.visibility = View.GONE
        taskDescriptionLayout.visibility = View.GONE

        taskWizardNext.setOnClickListener {
            val action = TaskInputInfoFragmentDirections.actionTaskInputInfoFragmentToTaskInputDifficultyFragment (viewModel.taskLiveData.value)
            view.findNavController().navigate(action)
        }
        taskWizardBack.setOnClickListener {
            view.findNavController().popBackStack()
        }
        taskDescriptionAddButton.setOnClickListener {
            taskDescriptionLayout.visibility = View.VISIBLE
            taskDescriptionAddButton.visibility = View.GONE
        }
        taskDescriptionCancelButton.setOnClickListener{
            taskDescriptionLayout.visibility = View.GONE
            taskDescriptionAddButton.visibility = View.VISIBLE
        }
        taskNameTextInputField.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                viewModel.taskLiveData.value!!.name = s.toString()
            }
        })
        taskDescriptionTextInputField.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                viewModel.taskLiveData.value!!.description = s.toString()
            }
        })
    }
}

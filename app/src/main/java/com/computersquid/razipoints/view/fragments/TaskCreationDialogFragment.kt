package com.computersquid.razipoints.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.DialogFragment

import com.computersquid.razipoints.R
import com.computersquid.razipoints.data.model.Task
import kotlinx.android.synthetic.main.fragment_action_dialog.*


class TaskCreationDialogFragment : DialogFragment() {

    private var _actionId: Long = 0
    private lateinit var _task: Task

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _actionId = it.getLong(ACTION_ID)
            // TODO: Get Task from Repository
        }
        if (_actionId == 0L) {
            _task = Task(0, "New Task", 0)
        } else {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_action_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pointsValueText.text = _task.value.toString()
        actionNameTextInput.setText(_task.name)
        decrementPoints.setOnClickListener {
            _task.value--
        }
        incrementPoints.setOnClickListener {
            _task.value++
        }
        confirmButton.setOnClickListener {
            dismiss()
        }
        cancelButton.setOnClickListener {
            dismiss()
        }
        pointsValueSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {

        const val ACTION_ID = "action_id"

        @JvmStatic
        val TAG: String = this::class.java.simpleName

        @JvmStatic
        fun newInstance(actionId: Long) =
                TaskCreationDialogFragment().apply {
                    arguments = Bundle().apply {
                        putLong(ACTION_ID, actionId)
                    }
                }
    }
}

package com.computersquid.razipoints.ui.views.action

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.SeekBar
import androidx.fragment.app.DialogFragment

import com.computersquid.razipoints.R
import com.computersquid.razipoints.model.Action
import kotlinx.android.synthetic.main.fragment_action_dialog.*

private const val ACTION_ID = "action_id"


class ActionDialogFragment : DialogFragment() {

    private var _actionId: Long = 0
    private lateinit var _action: Action

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _actionId = it.getLong(ACTION_ID)
            // TODO: Get Action from Repository
        }
        if (_actionId == 0L) {
            _action = Action(0, "New Action", 0)
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
        pointsValueText.text = _action.value.toString()
        actionNameTextInput.setText(_action.name)
        decrementPoints.setOnClickListener {
            _action.value--
        }
        incrementPoints.setOnClickListener {
            _action.value++
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
        @JvmStatic
        val TAG: String = this::class.java.simpleName

        @JvmStatic
        fun newInstance(actionId: Long) =
                ActionDialogFragment().apply {
                    arguments = Bundle().apply {
                        putLong(ACTION_ID, actionId)
                    }
                }
    }
}

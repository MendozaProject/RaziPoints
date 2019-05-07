package com.computersquid.razipoints.ui.viewholder

import android.content.Context
import android.opengl.Visibility
import android.view.View
import android.widget.CompoundButton
import androidx.core.content.ContextCompat

import androidx.recyclerview.widget.RecyclerView
import com.computersquid.razipoints.R
import com.computersquid.razipoints.data.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bindView(context: Context, task: Task){
        itemView.actionText.text = task.name
        itemView.pointsValueText.text = task.value.toString()
        itemView.warningIndicator.visibility = View.GONE
        itemView.dueDateText.visibility = View.GONE
        itemView.doneCheckBox.setOnCheckedChangeListener { compoundButton: CompoundButton, b: Boolean ->
            task.done = b
            // TODO: logic for on check
            if (b) {
                // add to total points
            } else {
                // subtract total points
            }

        }
    }
}
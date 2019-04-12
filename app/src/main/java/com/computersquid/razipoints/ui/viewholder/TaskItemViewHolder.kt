package com.computersquid.razipoints.ui.viewholder

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat

import androidx.recyclerview.widget.RecyclerView
import com.computersquid.razipoints.R
import com.computersquid.razipoints.data.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bindView(context: Context, task: Task){

        var colorRes = 0

        when {
            task.value > 0 -> {
                colorRes = R.color.pointsPositive
            }
            task.value < 0 -> {
                colorRes = R.color.pointsNegative
            }
            else -> {
                colorRes = R.color.defaultTextColor
            }
        }

        itemView.actionText.text = task.name
        itemView.pointsValueText.setTextColor(ContextCompat.getColor(context,colorRes))
        itemView.pointsValueText.text = task.value.toString()
        itemView.pointsIcon.setColorFilter(ContextCompat.getColor(context,colorRes))
    }
}
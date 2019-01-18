package com.computersquid.razipoints.view.viewholder

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat

import androidx.recyclerview.widget.RecyclerView
import com.computersquid.razipoints.R
import com.computersquid.razipoints.data.model.Task
import kotlinx.android.synthetic.main.item_action.view.*

class TaskItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bindAction(context: Context, task: Task){

        var iconRes = 0
        var colorRes = 0

        if (task.value > 0) {
            iconRes = R.mipmap.baseline_add_circle_white_18
            colorRes = R.color.pointsPositive
        } else if (task.value < 0){
            iconRes = R.mipmap.baseline_remove_circle_white_18
            colorRes = R.color.pointsNegative
        } else {

        }
        itemView.actionText.text = task.name
        itemView.pointsValueText.setTextColor(ContextCompat.getColor(context,colorRes))
        itemView.pointsValueText.text = task.value.toString()
        itemView.pointsIcon.setImageDrawable(ContextCompat.getDrawable(context, iconRes))
        itemView.pointsIcon.setColorFilter(ContextCompat.getColor(context,colorRes))
    }
}
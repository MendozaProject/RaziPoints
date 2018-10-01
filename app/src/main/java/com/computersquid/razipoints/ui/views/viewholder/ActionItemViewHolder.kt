package com.computersquid.razipoints.ui.views.viewholder

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat

import androidx.recyclerview.widget.RecyclerView
import com.computersquid.razipoints.R
import com.computersquid.razipoints.model.Action
import kotlinx.android.synthetic.main.item_action.view.*

class ActionItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bindAction(context: Context, action: Action){

        var iconRes = 0
        var colorRes = 0

        if (action.value > 0) {
            iconRes = R.mipmap.baseline_add_circle_white_18
            colorRes = R.color.pointsPositive
        } else if (action.value < 0){
            iconRes = R.mipmap.baseline_remove_circle_white_18
            colorRes = R.color.pointsNegative
        } else {

        }
        itemView.actionText.text = action.name
        itemView.pointsValueText.setTextColor(ContextCompat.getColor(context,colorRes))
        itemView.pointsValueText.text = action.value.toString()
        itemView.pointsIcon.setImageDrawable(ContextCompat.getDrawable(context, iconRes))
        itemView.pointsIcon.setColorFilter(ContextCompat.getColor(context,colorRes))
    }
}
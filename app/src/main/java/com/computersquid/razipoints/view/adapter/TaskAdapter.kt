package com.computersquid.razipoints.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.view.viewholder.TaskItemViewHolder

class TaskAdapter(
        private var context: Context,
        itemView:Int,
        var tasks: MutableList<Task>)
    : RecyclerView.Adapter<TaskItemViewHolder>() {

    private var view: Int = itemView


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(view, parent, false) as View

        return TaskItemViewHolder(view)
    }


    override fun getItemCount(): Int {
        return tasks.size
    }


    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        holder.bindAction(context, tasks[position])
    }
}
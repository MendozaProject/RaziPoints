package com.computersquid.razipoints.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.view.viewholder.TaskItemViewHolder

class TaskAdapter(context: Context, itemView:Int, tasks: List<Task>)
    : RecyclerView.Adapter<TaskItemViewHolder>() {

    private var _tasks: List<Task> = tasks
    private var _context: Context = context
    private var _view: Int = itemView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(_view, parent, false) as View

        return TaskItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return _tasks.size
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        holder.bindAction(_context, _tasks[position])
    }
}
package com.computersquid.razipoints.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.computersquid.razipoints.model.Action
import com.computersquid.razipoints.ui.views.viewholder.ActionItemViewHolder

class ActionsAdapter(context: Context, itemView:Int, actions: List<Action>)
    : RecyclerView.Adapter<ActionItemViewHolder>() {

    private var _actions: List<Action> = actions
    private var _context: Context = context
    private var _view: Int = itemView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionItemViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(_view, parent, false) as View

        return ActionItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return _actions.size
    }

    override fun onBindViewHolder(holder: ActionItemViewHolder, position: Int) {
        holder.bindAction(_context, _actions[position])
    }
}
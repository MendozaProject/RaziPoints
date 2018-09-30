package com.computersquid.razipoints.ui.views.home

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.computersquid.razipoints.ui.adapter.ActionsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

interface HomeViewModel {
    val totalPoints: Int
    fun showActionsDialog()
}
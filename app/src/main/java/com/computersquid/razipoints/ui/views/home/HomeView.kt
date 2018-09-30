package com.computersquid.razipoints.ui.views.home

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

interface HomeView {

    val pointsTextView: TextView
    val actionsRecyclerView: RecyclerView
    val addNewActionButton: FloatingActionButton

}
package com.computersquid.razipoints.ui.views.home

import android.view.View
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.computersquid.razipoints.model.Action
import com.computersquid.razipoints.model.User
import com.computersquid.razipoints.ui.adapter.ActionsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

public interface HomeViewModel {
    var user: MutableLiveData<User>
    var actions: MutableLiveData<List<Action>>
}
package com.computersquid.razipoints.view.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.computersquid.razipoints.R
import com.computersquid.razipoints.mvvm.BaseFragment


class TaskCreatorFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_creator, container, false)
    }



}

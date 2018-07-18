package com.computersquid.razipoints.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.computersquid.razipoints.R
import kotlinx.android.synthetic.main.activity_main.*

class TheWillOfGod : AppCompatActivity() {

    //backstack
    //fragment management


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentContainer
    }
}

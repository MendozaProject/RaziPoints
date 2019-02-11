package com.computersquid.razipoints.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.computersquid.razipoints.R
import com.computersquid.razipoints.ui.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import io.github.inflationx.viewpump.ViewPumpContextWrapper



class TheWillOfGod : AppCompatActivity() {

    private var fragmentManager = supportFragmentManager
    private var homeFragment: HomeFragment? = HomeFragment.newInstance()


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment()
    }


    private fun showFragment () {
        if (null == homeFragment) homeFragment = HomeFragment.newInstance()

        fragmentManager.beginTransaction()
                .replace(this.rootContainer.id, homeFragment!!, HomeFragment.TAG)
                .commit()
    }
}

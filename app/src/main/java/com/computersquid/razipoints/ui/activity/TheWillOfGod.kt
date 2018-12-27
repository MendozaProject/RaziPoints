package com.computersquid.razipoints.ui.activity

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.computersquid.razipoints.R
import com.computersquid.razipoints.ui.views.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import io.github.inflationx.viewpump.ViewPumpContextWrapper



class TheWillOfGod : AppCompatActivity(), HomeFragment.HomeFragmentContract {

    //region Properties
    private var fragmentManager = supportFragmentManager
    private var homeFragment: HomeFragment? = HomeFragment.newInstance()

    //endregion

    //region Life Cycle Methods

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment()
    }

    //endregion


    //region Fragment Methods

    private fun showFragment () {


        if (null == homeFragment) homeFragment = HomeFragment.newInstance()

        fragmentManager.beginTransaction()
                .replace(this.rootContainer.id, homeFragment!!, HomeFragment.TAG)
                .commit()
    }

    //endregion


    //region Fragment Contracts

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //endregion

}

package com.computersquid.razipoints.view.activity

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.computersquid.razipoints.R
import com.computersquid.razipoints.view.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import io.github.inflationx.viewpump.ViewPumpContextWrapper



class TheWillOfGod : AppCompatActivity() {

    private var fragmentManager = supportFragmentManager

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFragment("TAGGG")
        showFragment("TAWWWGGG")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun showFragment (tag: String) {
        fragmentManager.beginTransaction()
                .replace(this.rootContainer.id, HomeFragment.newInstance(), tag)
                .addToBackStack(null)
                .commit()
    }
}

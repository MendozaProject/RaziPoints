package com.computersquid.razipoints.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.computersquid.razipoints.R
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.ui.fragments.HomeFragment
import com.computersquid.razipoints.ui.fragments.TaskCreatorFragment
import com.computersquid.razipoints.ui.navigation.FragmentNavigationDirectory
import kotlinx.android.synthetic.main.activity_main.*
import io.github.inflationx.viewpump.ViewPumpContextWrapper


class TheWillOfGod : AppCompatActivity(), FragmentNavigationDirectory {

    private var fragmentManager = supportFragmentManager
    private var homeFragment: HomeFragment? = null
    private var taskCreatorFragment: TaskCreatorFragment? = null

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showHomeFragment()
    }


    private fun showFragment (fragment : Fragment?, tag: String) {
        fragmentManager.beginTransaction()
                .replace(this.rootContainer.id, fragment!!, tag)
                .commit()
    }


    override fun showHomeFragment() {
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance()
        }
        showFragment(homeFragment, HomeFragment.TAG)
    }


    override fun showTaskCreationFragment(task: Task) {
        if (taskCreatorFragment == null) {
            taskCreatorFragment = TaskCreatorFragment.newInstance(task)
        }
        showFragment(taskCreatorFragment, HomeFragment.TAG)
    }

}

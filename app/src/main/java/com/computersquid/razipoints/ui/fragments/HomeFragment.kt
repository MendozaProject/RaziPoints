package com.computersquid.razipoints.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.computersquid.razipoints.R
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.ui.adapter.TaskAdapter
import com.computersquid.razipoints.ui.navigation.FragmentNavigationDirectory
import com.computersquid.razipoints.ui.mvvm.BaseFragment
import com.computersquid.razipoints.ui.viewmodel.contract.HomeViewModelContract
import com.computersquid.razipoints.ui.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.layout_home_toolbar.*
import javax.inject.Inject



class HomeFragment : BaseFragment() {

    private var navigation: FragmentNavigationDirectory? = null
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var viewModelContract: HomeViewModelContract

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentNavigationDirectory){
            navigation = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidSupportInjection.inject(this)
        viewModelContract = ViewModelProviders.of(this, viewModelFactory)
                .get(HomeViewModel::class.java)

        viewModelContract.tasksLiveData.observe(this, Observer<List<Task>> { tasks: List<Task> ->
            taskAdapter.tasks = tasks as MutableList<Task>
            taskAdapter.notifyDataSetChanged()
        })

//        viewModelContract.userLiveData.observe(this,
//                Observer<User> { user: User ->
//                    numPoints.text = user.points.toString()
//                })

        taskAdapter = TaskAdapter(context!!, R.layout.item_task, viewModelContract.tasks as MutableList<Task>)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = taskAdapter
        }

        addActionFab.setOnClickListener {
            navigation!!.showTaskCreationFragment(Task())
        }
        toolbarTitle.text = "Taskboard"
        numPoints.text = resources.getQuantityString(R.plurals.num_points, viewModelContract.user.points, viewModelContract.user.points)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


    override fun onDetach() {
        super.onDetach()
        navigation = null
    }


    companion object {

        @JvmStatic
        val TAG: String = this::class.java.simpleName

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
package com.computersquid.razipoints.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.computersquid.razipoints.R
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User
import com.computersquid.razipoints.ui.adapter.TaskAdapter
import com.computersquid.razipoints.ui.mvvm.BaseFragment
import com.computersquid.razipoints.ui.viewmodel.HomeViewModel
import com.computersquid.razipoints.ui.viewmodel.contract.HomeViewModelContract
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_home_toolbar.*
import javax.inject.Inject


class HomeFragment : BaseFragment() {

    private lateinit var taskAdapter: TaskAdapter
    private lateinit var viewModel: HomeViewModelContract

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidSupportInjection.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(HomeViewModel::class.java)
        taskAdapter = TaskAdapter(context!!, R.layout.item_task, emptyList())
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

        viewModel.tasksLiveData.observe(this, Observer<List<Task>> { tasks: List<Task> ->
            taskAdapter.tasks = tasks as MutableList<Task>
            taskAdapter.notifyDataSetChanged()
        })
        viewModel.userLiveData.observe(this, Observer<User> { user: User ->
            numPoints.text = resources.getQuantityString(R.plurals.num_points, user.points, user.points)
        })
        addActionFab.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTaskInputStartFragment (Task())
            view.findNavController().navigate(action)
        }
        toolbarTitle.text = "Taskboard"
    }

    override fun onDetach() {
        super.onDetach()
    }
}
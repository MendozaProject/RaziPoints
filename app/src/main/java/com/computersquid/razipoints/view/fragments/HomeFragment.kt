package com.computersquid.razipoints.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.computersquid.razipoints.R
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User
import com.computersquid.razipoints.view.adapter.TaskAdapter
import com.computersquid.razipoints.mvvm.BaseFragment
import com.computersquid.razipoints.viewmodel.HomeViewModel
import com.computersquid.razipoints.viewmodel.HomeViewModelImpl
import kotlinx.android.synthetic.main.fragment_home.*
import dagger.android.support.AndroidSupportInjection
import io.objectbox.android.ObjectBoxLiveData
import kotlinx.android.synthetic.main.item_task.*
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    private lateinit var taskAdapter: TaskAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        AndroidSupportInjection.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(HomeViewModelImpl::class.java)

        viewModel.tasksLiveData.observe(this, Observer<List<Task>> { tasks: List<Task> ->
            taskAdapter.tasks = tasks as MutableList<Task>
            taskAdapter.notifyDataSetChanged()
        })

        viewModel.userLiveData.observe(this, Observer<User> { user: User ->
            pointsValueText.text = user.points.toString()
        })

        taskAdapter = TaskAdapter(context!!, R.layout.item_task, viewModel.getTasks() as MutableList<Task>)

        viewManager = LinearLayoutManager(context)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = taskAdapter
        }

        addActionFab.setOnClickListener {
            viewModel.showActionDialog(fragmentManager!!, 0)
            //viewModel.addTestTask(Task(0, "New Task", 12, false))
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }


    override fun onDetach() {
        super.onDetach()
    }


    companion object {

        @JvmStatic
        val TAG: String = this::class.java.simpleName

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}

private fun <T> ObjectBoxLiveData<T>.observe(homeFragment: HomeFragment, observer: Observer<T>) {

}

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
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    private lateinit var user: User
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidSupportInjection.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[HomeViewModelImpl::class.java]

        taskAdapter = TaskAdapter(context!!, R.layout.item_action, viewModel.tasks.value!!)
        viewManager = LinearLayoutManager(context)

        viewModel.tasks.observe(this, Observer<List<Task>> {
            taskAdapter.notifyDataSetChanged()
        })
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = taskAdapter
        }

        addActionFab.setOnClickListener {
            viewModel.showActionDialog(fragmentManager!!, 0)
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

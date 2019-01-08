package com.computersquid.razipoints.view.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.computersquid.razipoints.R
import com.computersquid.razipoints.model.Task
import com.computersquid.razipoints.model.User
import com.computersquid.razipoints.view.adapter.TaskAdapter
import com.computersquid.razipoints.mvvm.BaseFragment
import com.computersquid.razipoints.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import dagger.android.support.AndroidSupportInjection

class HomeFragment : BaseFragment() {


    //region  Properties

    private var actions = ArrayList<Task>()

    private lateinit var user: User
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewModel: HomeViewModel

    private var homeFragmentListener: HomeFragmentContract? = null

    //endregion


    //region  Methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidSupportInjection.inject(this)

        actions.add(Task(0, "Do thing 1", 1))
        actions.add(Task(1, "Do thing 2", 2))
        actions.add(Task(2, "Do thing -1", -1))
        actions.add(Task(3, "Do thing -2", -2))

        taskAdapter = TaskAdapter(context!!, R.layout.item_action, actions)
        viewManager = LinearLayoutManager(context)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
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
        if (context is HomeFragmentContract) {
            homeFragmentListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement HomeFragmentContract")
        }
    }


    override fun onDetach() {
        super.onDetach()
        homeFragmentListener = null
    }


    //endregion


    //region  Contract Interfaces

    interface HomeFragmentContract {
        fun onFragmentInteraction(uri: Uri)
    }

    //endregion


    //region Companion Object

    companion object {

        @JvmStatic
        val TAG: String = this::class.java.simpleName

        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    //endregion
}

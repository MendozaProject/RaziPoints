package com.computersquid.razipoints.ui.views.home

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.computersquid.razipoints.R



class HomeFragment : Fragment() {

    //region Properties

    private var homeFragmentListener: HomeFragmentContract? = null

    //endregion


    //region LifeCycleMethods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
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

    interface HomeFragmentContract {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        @JvmStatic
        val TAG: String = this::class.java.simpleName

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}

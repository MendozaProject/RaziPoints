package com.computersquid.razipoints.ui.views.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.computersquid.razipoints.model.Action
import com.computersquid.razipoints.model.User

class HomeViewModelImpl : HomeViewModel, ViewModel() {

    override var user: MutableLiveData<User> = MutableLiveData()

    override var actions: MutableLiveData<List<Action>> = MutableLiveData()

    fun HomeViewModelImpl(){
        // TODO: Inject UserModel and ActionsModel here

    }

}
package com.computersquid.razipoints.ui.views.action

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.computersquid.razipoints.model.Action

class ActionDialogViewModelImpl(override var action: MutableLiveData<Action>) : ActionDialogViewModel, ViewModel() {

}

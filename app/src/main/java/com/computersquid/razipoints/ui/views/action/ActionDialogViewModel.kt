package com.computersquid.razipoints.ui.views.action

import androidx.lifecycle.MutableLiveData
import com.computersquid.razipoints.model.Action

public interface ActionDialogViewModel {
    var action: MutableLiveData<Action>
}
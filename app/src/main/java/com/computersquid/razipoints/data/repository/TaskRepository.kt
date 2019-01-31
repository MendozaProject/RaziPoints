package com.computersquid.razipoints.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.Task_
import io.objectbox.BoxStore
import io.objectbox.android.ObjectBoxLiveData
import javax.inject.Inject

class TaskRepository

@Inject
constructor(boxStore: BoxStore)
    : LocalRepository<Task>(boxStore, Task::class.java) {

    fun getAll(): List<Task> {
        return box.query().order(Task_.id).build().find()
    }


    fun getAllLiveData(): ObjectBoxLiveData<Task> {
        return ObjectBoxLiveData(box.query().order(Task_.id).build())
    }


    fun getById(id: Long): ObjectBoxLiveData<Task> {
        return ObjectBoxLiveData(box.query().equal(Task_.id, id).build())
    }


    fun add(task: Task): Long {
        return box.put(task)
    }


    fun update(task: Task):Long {
        return box.put(task)
    }


    companion object {
        @JvmStatic val TAG: String = this::class.java.simpleName
    }
}
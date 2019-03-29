//package com.computersquid.razipoints.data.repository
//
//import com.computersquid.razipoints.data.model.Task
//import com.computersquid.razipoints.data.model.Task_
//import com.computersquid.razipoints.data.model.User
//import com.computersquid.razipoints.data.model.User_
//import io.objectbox.BoxStore
//import io.objectbox.android.ObjectBoxLiveData
//import javax.inject.Inject
//
//class UserRepository
//
//@Inject
//constructor(boxStore: BoxStore)
//    : LocalRepository<User>(boxStore, User::class.java) {
//
//    fun getAll(): List<User> {
//        return box.query().order(User_.id).build().find()
//    }
//
//    fun getById(id: Long): User {
//        return box.get(id)
//    }
//
//    fun getUserLiveData(id: Long): ObjectBoxLiveData<User> {
//        return ObjectBoxLiveData<User>(box.query().equal(User_.id, id).build())
//    }
//
//    fun add(user: User): Long {
//        return box.put(user)
//    }
//
//    fun update(user: User):Long {
//        return box.put(user)
//    }
//}
package com.computersquid.razipoints.data.repository
import androidx.lifecycle.LiveData
import com.computersquid.razipoints.data.dao.UserDao
import com.computersquid.razipoints.data.model.Task
import com.computersquid.razipoints.data.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao){

    fun getById(id: Int): LiveData<User> {
        return userDao.getById(id)
    }

    fun add(user: User) {
        userDao.insertAll(user)
    }
}
package com.computersquid.razipoints.data.repository
import androidx.lifecycle.LiveData
import com.computersquid.razipoints.data.dao.UserDao
import com.computersquid.razipoints.data.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao){

    init {
        userDao.getAll()
        userDao.insert(User())
    }

    fun getById(id: Int): LiveData<User> {
        return userDao.getById(id)
    }

    fun add(user: User) {
        userDao.insert(user)
    }
}
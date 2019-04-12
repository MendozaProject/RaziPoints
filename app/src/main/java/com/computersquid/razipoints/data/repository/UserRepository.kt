package com.computersquid.razipoints.data.repository
import androidx.lifecycle.LiveData
import com.computersquid.razipoints.data.dao.UserDao
import com.computersquid.razipoints.data.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao){

    init {
        // Initializes the default User if none exists
        if (userDao.count() == 0){
            userDao.insert(User())
        }
        assert(userDao.count() <= 1)
    }

    fun getUser(): LiveData<User> {
        return userDao.getById(1)
    }

    fun add(user: User) {
        userDao.insert(user)
    }
}
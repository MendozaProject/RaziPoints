package com.computersquid.razipoints.data

import com.computersquid.razipoints.model.User
import io.objectbox.BoxStore
import javax.inject.Inject

class UserRepository : LocalRepository<User> {
    @Inject constructor(boxStore: BoxStore): super(boxStore, User::class.java) {

    }
}
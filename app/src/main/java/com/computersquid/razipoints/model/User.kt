package com.computersquid.razipoints.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class User(
        @Id var id: Long = 0,
        var points: Int
)
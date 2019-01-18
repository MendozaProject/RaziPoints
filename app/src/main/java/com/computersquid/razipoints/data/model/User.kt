package com.computersquid.razipoints.data.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class User(
        @Id var id: Long = 0,
        var points: Int
)
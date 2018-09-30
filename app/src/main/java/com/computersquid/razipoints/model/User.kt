package com.computersquid.razipoints.model

import io.objectbox.annotation.Id

data class User(
        @Id var id: Long = 0,
        var points: Int
)
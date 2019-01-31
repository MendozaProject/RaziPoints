package com.computersquid.razipoints.data.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Task(
        @Id var id: Long = 0,
        var name: String = "New Task",
        var value: Int = 0,
        var done: Boolean = false
)
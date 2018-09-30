package com.computersquid.razipoints.ui.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class ExampleEntity(
        @Id var id: Long = 0
)
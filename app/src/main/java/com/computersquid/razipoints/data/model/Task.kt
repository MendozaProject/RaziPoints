package com.computersquid.razipoints.data.model

import android.annotation.SuppressLint
import android.os.Parcelable
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import kotlinx.android.parcel.Parcelize

@Entity
@SuppressLint("ParcelCreator")
@Parcelize
data class Task(
        @Id var id: Long = 0,
        var name: String = "New Task",
        var value: Int = 0,
        var done: Boolean = false
): Parcelable
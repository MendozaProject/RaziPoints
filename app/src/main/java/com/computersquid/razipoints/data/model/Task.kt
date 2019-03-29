package com.computersquid.razipoints.data.model

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tasks")
@SuppressLint("ParcelCreator")
@Parcelize
data class Task(
        @PrimaryKey var id: Long = 0,
        @ColumnInfo(name = "name") var name: String = "New Task",
        @ColumnInfo(name = "value") var value: Int = 0,
        @ColumnInfo(name = "done") var done: Boolean = false
): Parcelable
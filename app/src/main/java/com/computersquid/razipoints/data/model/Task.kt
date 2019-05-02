package com.computersquid.razipoints.data.model

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
@Entity(tableName = TASK_TABLE_NAME)
data class Task(
        @PrimaryKey(autoGenerate = true) var id: Long = 0,
        @ColumnInfo(name = "name") var name: String = "New Task",
        @ColumnInfo(name = "description") var description: String = "",
        @ColumnInfo(name = "value") var value: Int = 0,
        @ColumnInfo(name = "done") var done: Boolean = false
): Parcelable
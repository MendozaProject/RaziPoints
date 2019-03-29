package com.computersquid.razipoints.data.repository

import android.content.Context
import androidx.room.Room
import com.computersquid.razipoints.data.database.AppDatabase


open class LocalRepository<T>(context: Context, tableName: String) {



    init {
        var noteDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "app-database").build()
    }
}
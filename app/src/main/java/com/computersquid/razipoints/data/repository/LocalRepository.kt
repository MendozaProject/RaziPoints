package com.computersquid.razipoints.data.repository

import io.objectbox.BoxStore
import io.objectbox.Box


open class LocalRepository<T>(boxStore: BoxStore, val clazz: Class<T>) {

    val box: Box<T>

    init {
        box = boxStore.boxFor(clazz)
    }

    companion object {

    }
}
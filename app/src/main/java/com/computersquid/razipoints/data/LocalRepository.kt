package com.computersquid.razipoints.data

import io.objectbox.BoxStore
import io.objectbox.Box

open class LocalRepository<T>(boxStore: BoxStore, clazz: Class<T>) {
    val box: Box<T>

    init {
        box = boxStore.boxFor(clazz);
    }



    companion object {
    }
}
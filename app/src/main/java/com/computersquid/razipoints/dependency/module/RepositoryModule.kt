package com.computersquid.razipoints.dependency.module

import com.computersquid.razipoints.data.repository.TaskRepository
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import javax.inject.Singleton

@Module(
        includes = [AppModule::class]
)
object RepositoryModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideTaskRepository(boxStore: BoxStore): TaskRepository {
        return TaskRepository(boxStore)
    }
}
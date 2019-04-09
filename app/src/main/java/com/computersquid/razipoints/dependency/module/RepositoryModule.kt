package com.computersquid.razipoints.dependency.module

import com.computersquid.razipoints.data.dao.TaskDao
import com.computersquid.razipoints.data.repository.TaskRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
        includes = [AppModule::class]
)
object RepositoryModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideTaskRepository(taskDao: TaskDao): TaskRepository {
        return TaskRepository(taskDao)
    }
}
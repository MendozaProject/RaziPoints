package com.computersquid.razipoints.dependency.module

import com.computersquid.razipoints.data.dao.TaskDao
import com.computersquid.razipoints.data.dao.UserDao
import com.computersquid.razipoints.data.database.AppDatabase
import com.computersquid.razipoints.data.repository.TaskRepository
import com.computersquid.razipoints.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
        includes = [AppModule::class]
)
object RoomModule {
    @Singleton
    @Provides
    @JvmStatic
    fun provideTaskDao(appDatabase: AppDatabase): TaskDao {
        return appDatabase.taskDao()
    }

    @Singleton
    @Provides
    @JvmStatic
    fun provideTaskRepository(taskDao: TaskDao): TaskRepository {
        return TaskRepository(taskDao)
    }

    @Singleton
    @Provides
    @JvmStatic
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Singleton
    @Provides
    @JvmStatic
    fun provideUserRepository(userDao: UserDao): UserRepository {
        return UserRepository(userDao)
    }
}
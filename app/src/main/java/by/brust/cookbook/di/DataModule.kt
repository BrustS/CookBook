package by.brust.cookbook.di

import android.content.Context
import by.brust.cookbook.data.repository.RecipeRepositoryImpl
import by.brust.cookbook.data.repository.UserRepositoryImpl
import by.brust.cookbook.domain.repository.RecipeRepository
import by.brust.cookbook.domain.repository.UserRepository
import by.brust.finaltask.data.repository.LocalData
import by.brust.finaltask.data.repository.LocalDataImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideLocalData(@ApplicationContext context: Context) : LocalData {
        return LocalDataImpl(context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(localData: LocalData): UserRepository{
        return UserRepositoryImpl(localData)
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(localData: LocalData): RecipeRepository{
        return RecipeRepositoryImpl(localData)
    }
}
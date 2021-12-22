package by.brust.cookbook.di

import android.content.Context
import by.brust.cookbook.data.repository.RecipeRepositoryImpl
import by.brust.cookbook.data.repository.UserRepositoryImpl
import by.brust.cookbook.data.storage.local.room.FavoriteRecipeDatabase
import by.brust.cookbook.data.storage.remote.RemoteData
import by.brust.cookbook.data.storage.remote.RemoteDataImpl
import by.brust.cookbook.data.storage.remote.UserAPI
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
    fun provideRemoteData(userAPI: UserAPI): RemoteData{
        return RemoteDataImpl(userAPI)
    }

    @Provides
    @Singleton
    fun provideUserRepository(localData: LocalData, remoteData: RemoteData): UserRepository{
        return UserRepositoryImpl(localData, remoteData)
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(localData: LocalData): RecipeRepository{
        return RecipeRepositoryImpl(localData)
    }
}
package by.brust.cookbook.di

import by.brust.cookbook.domain.repository.RecipeRepository
import by.brust.cookbook.domain.repository.UserRepository
import by.brust.cookbook.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideLoginUserByEmailUseCase(userRepository: UserRepository): LoginUserByEmailUseCase {
        return LoginUserByEmailUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideSaveUserToSharedPrefUseCase(userRepository: UserRepository): SaveUserToSharedPrefUserCase {
        return SaveUserToSharedPrefUserCase(userRepository)
    }
    @Provides
    @Singleton
    fun provideGetPopularRecipesUseCase(recipeRepository: RecipeRepository): GetPopularRecipesUseCase {
        return  GetPopularRecipesUseCase(recipeRepository)
    }
    @Provides
    @Singleton
    fun provideGetUserFromSharedPrefsUseCase(userRepository: UserRepository): GetUserFromSharedPrefsUseCase {
        return GetUserFromSharedPrefsUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideRegistrationUserUseCase(userRepository: UserRepository): RegistrationUserUseCase{
        return RegistrationUserUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteRecipeFromFavoriteUseCase(recipeRepository: RecipeRepository): DeleteRecipeFromFavoriteUseCase {
        return DeleteRecipeFromFavoriteUseCase(recipeRepository)
    }
}
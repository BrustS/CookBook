package by.brust.cookbook.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import by.brust.cookbook.data.models.FavoriteRecipe
import by.brust.cookbook.data.models.Recipe
import by.brust.cookbook.data.storage.local.room.FavoriteRecipeDatabase
import by.brust.cookbook.domain.repository.RecipeRepository
import by.brust.finaltask.data.repository.LocalData
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val localData: LocalData): RecipeRepository {
    override fun getRecipes(): List<Recipe> {
       return localData.getRecipes()
    }

    override suspend fun getFavoriteRecipe(): LiveData<List<FavoriteRecipe>>? =
       localData.getFavoriteRecipe()


    override suspend fun addRecipeToFavorite(recipe: Recipe) {
        return localData.addRecipesToFavorite(recipe)
    }

    override suspend fun removeRecipeFromFavorite(recipe: FavoriteRecipe) {
        return localData.deleteRecipeFromFavorite(recipe)
    }


}
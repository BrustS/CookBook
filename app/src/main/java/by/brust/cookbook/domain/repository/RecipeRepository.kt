package by.brust.cookbook.domain.repository

import androidx.lifecycle.LiveData
import by.brust.cookbook.data.models.FavoriteRecipe
import by.brust.cookbook.data.models.Recipe
import java.util.concurrent.Flow

interface RecipeRepository {
    fun getRecipes(): List<Recipe>
    suspend fun getFavoriteRecipe() : LiveData< List<FavoriteRecipe>>?

    suspend  fun  addRecipeToFavorite(recipe: Recipe)

    suspend fun removeRecipeFromFavorite(recipe: FavoriteRecipe)
}
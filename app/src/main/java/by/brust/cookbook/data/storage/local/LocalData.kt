package by.brust.finaltask.data.repository

import androidx.lifecycle.LiveData
import by.brust.cookbook.data.models.FavoriteRecipe
import by.brust.cookbook.data.models.Recipe
import by.brust.cookbook.data.models.SavedUser
import by.brust.cookbook.data.models.User


interface LocalData {

    suspend fun getUsers():List<User>
    fun saveUser(user: SavedUser)
    fun getActiveUser(): SavedUser
    fun getRecipes(): List<Recipe>
    suspend fun getFavoriteRecipe(): LiveData<List<FavoriteRecipe>>?
    suspend fun addRecipesToFavorite(recipe: Recipe)
    suspend fun deleteRecipeFromFavorite(recipe: FavoriteRecipe)
}
package by.brust.cookbook.data.storage.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import by.brust.cookbook.data.models.FavoriteRecipe

@Dao
interface FavoriteDAO {
    @Query("SELECT * FROM favorite_recipe_table WHERE email=:userEmail")
    fun getAllFavoriteRecipes(userEmail: String): LiveData<List<FavoriteRecipe>>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorite(favoriteRecipe: FavoriteRecipe)

    @Delete
    suspend fun deleteRecipeFromFavorite(favoriteRecipe: FavoriteRecipe)
}
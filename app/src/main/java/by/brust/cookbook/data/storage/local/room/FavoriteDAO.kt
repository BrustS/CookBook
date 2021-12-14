package by.brust.cookbook.data.storage.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import by.brust.cookbook.data.models.FavoriteRecipe

@Dao
interface FavoriteDAO {
    @Query("SELECT * FROM favorite_recipe_table ORDER BY email ASC")
    fun getAllFavoriteRecipes(): LiveData<List<FavoriteRecipe>>

    @Insert
    suspend fun addTofavorite(favoriteRecipe: FavoriteRecipe)

    @Delete
    suspend fun deleteRecipeFromFavorite(favoriteRecipe: FavoriteRecipe)
}
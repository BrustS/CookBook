package by.brust.finaltask.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import by.brust.cookbook.data.models.FavoriteRecipe
import by.brust.cookbook.data.models.Recipe
import by.brust.cookbook.data.models.SavedUser
import by.brust.cookbook.data.models.User
import by.brust.cookbook.data.storage.local.room.FavoriteRecipeDatabase
import by.brust.cookbook.domain.usecases.SaveUserToSharedPrefUserCase
import by.brust.cookbook.utils.Constants
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class LocalDataImpl(private val context: Context) : LocalData {

    val sharedPreferences =
        context.getSharedPreferences(Constants.SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override suspend fun getUsers(): List<User> {
        val json = context.assets.open("users.json").bufferedReader().use {
            it.readText()
        }
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val type = Types.newParameterizedType(List::class.java, User::class.java)
        val jsonAdapter: JsonAdapter<List<User>> = moshi.adapter(type)
        return jsonAdapter.fromJson(json)!!
    }

    override fun saveUser(user: SavedUser) {
        sharedPreferences.edit().putString(Constants.KEY_USER_NAME, user.name).apply()
        sharedPreferences.edit().putString(Constants.KEY_USER_EMAIL, user.email).apply()
    }

    override fun getActiveUser(): SavedUser {
        val savesname = sharedPreferences.getString(Constants.KEY_USER_NAME, "") ?: ""
        val savedemail = sharedPreferences.getString(Constants.KEY_USER_EMAIL, "") ?: ""
        return SavedUser(savesname, savedemail)
    }

    override fun getRecipes(): List<Recipe> {
        val json = context.assets.open("recipes.json").bufferedReader().use {
            it.readText()
        }
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val type = Types.newParameterizedType(List::class.java, Recipe::class.java)
        val jsonAdapter: JsonAdapter<List<Recipe>> = moshi.adapter(type)
        return jsonAdapter.fromJson(json)!!
    }

    override suspend fun getFavoriteRecipe(): LiveData< List<FavoriteRecipe>>? {

        return FavoriteRecipeDatabase.getFavoriteRecipeDatabase(context).favoriteDAO()
            .getAllFavoriteRecipes(getActiveUser().email)
    }

    override suspend fun addRecipesToFavorite(recipe: Recipe) {

        val favoriteRecipe = FavoriteRecipe(
            title = recipe.title,
            imageurl = recipe.imageurl,
            shortdescription = recipe.shortdescription,
            fulldecription = recipe.fulldecription,
            rating = recipe.rating,
            userEmail = getActiveUser().email
        )
        return FavoriteRecipeDatabase.getFavoriteRecipeDatabase(context).favoriteDAO()
            .addToFavorite(favoriteRecipe)
    }

    override suspend fun deleteRecipeFromFavorite(recipe: FavoriteRecipe) {
        FavoriteRecipeDatabase.getFavoriteRecipeDatabase(context).favoriteDAO().deleteRecipeFromFavorite(recipe)
    }
}

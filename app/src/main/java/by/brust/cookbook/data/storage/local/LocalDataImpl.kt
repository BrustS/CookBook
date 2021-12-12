package by.brust.finaltask.data.repository

import android.content.Context
import by.brust.cookbook.data.models.Recipe
import by.brust.cookbook.data.models.SavedUser
import by.brust.cookbook.data.models.User
import by.brust.cookbook.domain.usecases.SaveUserToSharedPrefUserCase
import by.brust.cookbook.utils.Constants
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@ExperimentalStdlibApi
class LocalDataImpl(private val context: Context) : LocalData {

    val sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFS_NAME, Context.MODE_PRIVATE)

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
        val moshi = Moshi.Builder() .addLast(KotlinJsonAdapterFactory()).build()
        val type = Types.newParameterizedType(List::class.java, Recipe::class.java)
        val jsonAdapter: JsonAdapter<List<Recipe>> = moshi.adapter(type)
        return jsonAdapter.fromJson(json)!!
    }

    override fun addUser(user: User): Boolean {
//        val json = context.assets.open("users.json")
        val moshi = Moshi.Builder() .addLast(KotlinJsonAdapterFactory()).build()
        val jsonAdapter: JsonAdapter<User> = moshi.adapter<User>()

        val json = jsonAdapter.toJson(user)


    }
}

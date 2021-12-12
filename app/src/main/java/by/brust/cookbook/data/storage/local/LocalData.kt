package by.brust.finaltask.data.repository

import by.brust.cookbook.data.models.Recipe
import by.brust.cookbook.data.models.SavedUser
import by.brust.cookbook.data.models.User


interface LocalData {

    suspend fun getUsers():List<User>
    fun saveUser(user: SavedUser)
    fun getActiveUser(): SavedUser
    fun getRecipes(): List<Recipe>
    fun addUser(user: User):Boolean
}
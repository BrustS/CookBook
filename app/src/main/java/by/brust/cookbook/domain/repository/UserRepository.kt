package by.brust.cookbook.domain.repository

import by.brust.cookbook.data.models.SavedUser
import by.brust.cookbook.data.models.User
import by.brust.cookbook.domain.models.LoginigUser

interface UserRepository {
    suspend fun getUser(email:String, password: String) : LoginigUser?
    suspend fun addUser(user: User)
    fun saveUser(user:SavedUser)
    fun checkUser():SavedUser
    fun logoutUser(): Boolean
}
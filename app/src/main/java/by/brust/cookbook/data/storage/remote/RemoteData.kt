package by.brust.cookbook.data.storage.remote

import by.brust.cookbook.data.models.User

interface RemoteData {
    suspend fun getUsers(): List<User>
    suspend fun addUser(user: User)
}
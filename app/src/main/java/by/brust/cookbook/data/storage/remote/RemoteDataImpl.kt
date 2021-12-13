package by.brust.cookbook.data.storage.remote

import by.brust.cookbook.data.models.User
import javax.inject.Inject

class RemoteDataImpl @Inject constructor(private val userAPI: UserAPI): RemoteData {
    override suspend fun getUsers(): List<User> {
        return userAPI.getUsers().list
    }

    override suspend fun addUser(user: User) {
        userAPI.addUser(user)
    }
}
package by.brust.cookbook.data.repository

import by.brust.cookbook.data.models.SavedUser
import by.brust.cookbook.data.models.User
import by.brust.cookbook.data.storage.remote.RemoteData
import by.brust.cookbook.domain.models.LoginigUser
import by.brust.cookbook.domain.repository.UserRepository
import by.brust.finaltask.data.repository.LocalData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val localData: LocalData,
private val remoteData: RemoteData) : UserRepository {
    override suspend fun getUser(email: String, password: String): LoginigUser? {
        val loginigUser = CoroutineScope(Dispatchers.IO).async {
           val list = remoteData.getUsers()
          val user= list.firstOrNull{ it.email == email && it.password == password}
       return@async  if (user != null) LoginigUser(id = user.id, name = user.name, password = user.password, email = user.email) else null
       }
        return loginigUser.await()
    }


    override suspend fun addUser(user: User) {
      return remoteData.addUser(user)
    }

    override fun saveUser(user: SavedUser) {
        return localData.saveUser(user)
    }

    override fun checkUser(): SavedUser {
      return  localData.getActiveUser()
    }

    override fun logoutUser(): Boolean {
        TODO("Not yet implemented")
    }
}
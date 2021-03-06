package by.brust.cookbook.data.storage.remote

import by.brust.cookbook.data.models.User
import by.brust.cookbook.data.models.UserData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserAPI {
    companion object {
        const val BASE_URL = "http://my-json-server.typicode.com/"
    }

    @GET("BrustS/Json-server/users")
    suspend fun getUsers() : List<User>

    @POST("BrustS/Json-server/users")
    suspend fun addUser(
        @Body user: User)
}
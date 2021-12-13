package by.brust.cookbook.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
class UserData (
    @Json(name ="users")
    val list: List<User>)
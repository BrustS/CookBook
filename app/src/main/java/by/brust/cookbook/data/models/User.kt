package by.brust.cookbook.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
data class User (
 @Json(name = "id")
 val id: Int = 0,
 @Json(name = "name")
 val name: String = "",
 @Json(name = "email")
 val email:String ="",
 @Json(name = "password")
 val password: String=""
 )
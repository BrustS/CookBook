package by.brust.cookbook.data.models

import android.icu.text.CaseMap
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = false)
@Parcelize
data class Recipe(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "title")
    val title: String = "",
    @Json(name = "imageurl")
    val imageurl: String = "",
    @Json(name = "shortdescription")
    val shortdescription: String = "",
    @Json(name = "fulldescription")
    val fulldecription: String = "",
    @Json(name = "rating")
    val rating: Double = 0.0
) : Parcelable

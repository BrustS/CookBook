package by.brust.cookbook.data.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "favorite_recipe_table")
data class FavoriteRecipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1,
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "imageurl")
    val imageurl: String = "",
    @ColumnInfo(name = "shortdescription")
    val shortdescription: String = "",
    @ColumnInfo(name = "fulldescription")
    val fulldecription: String = "",
    @ColumnInfo(name = "rating")
    val rating: Double = 0.0,
    @ColumnInfo(name = "email")
    val userEmail: String
) : Parcelable

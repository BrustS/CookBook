package by.brust.cookbook.data.storage.local.room.mappers

import by.brust.cookbook.data.models.FavoriteRecipe
import by.brust.cookbook.data.models.Recipe

fun FavoriteRecipe.ToRecipe(): Recipe {
    return Recipe(id = this.id,
    title = this.title,
    imageurl = this.imageurl,
    shortdescription = this.shortdescription,
    fulldecription = this.fulldecription,
    rating = this.rating)
}
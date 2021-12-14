package by.brust.cookbook.data.storage.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.brust.cookbook.data.models.FavoriteRecipe

@Database(entities = arrayOf(FavoriteRecipe::class), version = 1)
abstract class FavoriteRecipeDatabase : RoomDatabase() {
    abstract fun favoriteDAO(): FavoriteDAO

    companion object {
        @Volatile
        private var INSTANCE: FavoriteRecipeDatabase? = null

        @Synchronized
        fun getFavoriteRecipeDatabase(context: Context): FavoriteRecipeDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    FavoriteRecipeDatabase::class.java,
                    "favorite.db"
                ).build()
            }
            return INSTANCE!!
        }
    }
}
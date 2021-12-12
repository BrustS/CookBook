package by.brust.cookbook.data.repository

import by.brust.cookbook.data.models.Recipe
import by.brust.cookbook.domain.repository.RecipeRepository
import by.brust.finaltask.data.repository.LocalData
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val localData: LocalData): RecipeRepository {
    override fun getRecipes(): List<Recipe> {
       return localData.getRecipes()
    }
}
package by.brust.cookbook.domain.repository

import by.brust.cookbook.data.models.Recipe

interface RecipeRepository {
    fun getRecipes(): List<Recipe>
}
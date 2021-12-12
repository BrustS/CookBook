package by.brust.cookbook.domain.usecases

import by.brust.cookbook.data.models.Recipe
import by.brust.cookbook.domain.repository.RecipeRepository
import javax.inject.Inject

class GetPopularRecipesUseCase @Inject constructor(private val recipeRepository: RecipeRepository){

    fun execute() : List<Recipe> {
        return recipeRepository.getRecipes()
    }
}
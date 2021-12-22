package by.brust.cookbook.domain.usecases

import by.brust.cookbook.data.models.Recipe
import by.brust.cookbook.domain.repository.RecipeRepository
import javax.inject.Inject

class AddRecipesToFavoriteUseCase @Inject constructor(private val recipeRepository: RecipeRepository){

    suspend fun execute(recipe: Recipe) {
        recipeRepository.addRecipeToFavorite(recipe)
    }
}
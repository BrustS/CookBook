package by.brust.cookbook.domain.usecases

import by.brust.cookbook.data.models.FavoriteRecipe
import by.brust.cookbook.domain.repository.RecipeRepository
import javax.inject.Inject

class DeleteRecipeFromFavoriteUseCase @Inject constructor(private val recipeRepository: RecipeRepository) {
    suspend fun execute(favorite: FavoriteRecipe) {
            recipeRepository.removeRecipeFromFavorite(favorite)
    }

}
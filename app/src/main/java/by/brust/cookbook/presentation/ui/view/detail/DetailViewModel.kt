package by.brust.cookbook.presentation.ui.view.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.brust.cookbook.data.models.FavoriteRecipe
import by.brust.cookbook.data.models.Recipe
import by.brust.cookbook.domain.repository.RecipeRepository
import by.brust.cookbook.domain.usecases.AddRecipesToFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val state: SavedStateHandle,
private val addRecipesToFavoriteUseCase: AddRecipesToFavoriteUseCase) : ViewModel() {
    val recipe by lazy {
        state.get<Recipe>("recipe")
    }

     fun addRecipeToFavorite()  =
         viewModelScope.launch(Dispatchers.IO) {
             recipe?.let { addRecipesToFavoriteUseCase.execute(it) }
         }

}
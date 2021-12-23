package by.brust.cookbook.presentation.ui.view.favoritelist

import android.util.Log
import androidx.lifecycle.*
import by.brust.cookbook.data.models.FavoriteRecipe
import by.brust.cookbook.data.models.Recipe
import by.brust.cookbook.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val recipeRepository: RecipeRepository) : ViewModel() {

     lateinit var recipeList: LiveData<List<FavoriteRecipe>>

    init {
        viewModelScope.launch {
            recipeRepository.getFavoriteRecipe().let{
                if (it != null) {
                    recipeList = it
                }
            }
        }
    }
}
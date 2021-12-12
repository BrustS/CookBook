package by.brust.cookbook.presentation.ui.view.recipelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.brust.cookbook.data.models.Recipe
import by.brust.cookbook.domain.usecases.GetPopularRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getPopularRecipesUseCase: GetPopularRecipesUseCase) :
    ViewModel() {
        val recipes : List<Recipe> = getPopularRecipesUseCase.execute()
}

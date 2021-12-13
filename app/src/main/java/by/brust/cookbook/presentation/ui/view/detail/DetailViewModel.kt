package by.brust.cookbook.presentation.ui.view.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import by.brust.cookbook.data.models.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val state: SavedStateHandle) : ViewModel() {
    val recipe by lazy {
        state.get<Recipe>("recipe")
    }
}
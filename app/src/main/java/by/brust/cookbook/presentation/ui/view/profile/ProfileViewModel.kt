package by.brust.cookbook.presentation.ui.view.profile

import androidx.lifecycle.ViewModel
import by.brust.cookbook.data.models.SavedUser
import by.brust.cookbook.domain.usecases.GetUserFromSharedPrefsUseCase
import by.brust.cookbook.domain.usecases.SaveUserToSharedPrefUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    getUserFromSharedPrefsUseCase: GetUserFromSharedPrefsUseCase,
    private val saveUserToSharedPrefUserCase: SaveUserToSharedPrefUserCase
) : ViewModel() {

    val user: SavedUser = getUserFromSharedPrefsUseCase.execute()
    fun save(user:SavedUser) {
        saveUserToSharedPrefUserCase.execute(user)
    }
}
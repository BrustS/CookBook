package by.brust.cookbook.presentation.ui.view.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.brust.cookbook.data.models.SavedUser
import by.brust.cookbook.domain.models.LoginigUser
import by.brust.cookbook.domain.usecases.GetUserFromSharedPrefsUseCase
import by.brust.cookbook.domain.usecases.LoginUserByEmailUseCase
import by.brust.cookbook.domain.usecases.SaveUserToSharedPrefUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUserByEmailUseCase: LoginUserByEmailUseCase,
    private val saveUserToSharedPrefUserCase: SaveUserToSharedPrefUserCase,
    private val getUserFromSharedPrefsUseCase: GetUserFromSharedPrefsUseCase
) : ViewModel() {

    private val userLiveMutable = MutableLiveData<LoginigUser?>()
    val userLiveData = userLiveMutable

    fun get(email: String, password: String) {
        viewModelScope.launch {
            userLiveMutable.value = loginUserByEmailUseCase.execute(email, password)
        }
    }

    fun save(savedUser: SavedUser) {
            saveUserToSharedPrefUserCase.execute(savedUser)
    }

    fun getSavedUser():Boolean {
        val user = getUserFromSharedPrefsUseCase.execute()
       return user.name !="" && user.email !=""
    }
}
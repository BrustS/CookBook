package by.brust.cookbook.presentation.ui.view.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.brust.cookbook.data.models.User
import by.brust.cookbook.domain.usecases.RegistrationUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val registrationUserUseCase: RegistrationUserUseCase) :
    ViewModel() {

        fun add(user: User) {
            viewModelScope.launch {
                registrationUserUseCase.execute(user)
            }
        }
}